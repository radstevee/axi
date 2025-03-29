package net.radstevee.axi.ui.resource.pack.send

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.resource.ResourcePackInfo.resourcePackInfo
import net.kyori.adventure.resource.ResourcePackRequest.addingRequest
import net.radstevee.axi.ecs.getOrPut
import net.radstevee.axi.plugin.event.SuspendingListener
import net.radstevee.axi.ui.resource.host.buildServerURI
import net.radstevee.axi.ui.resource.pack.AxiPack
import net.radstevee.axi.utility.forEachPlayer
import net.radstevee.axi.utility.players
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.player.PlayerResourcePackStatusEvent
import org.bukkit.event.player.PlayerResourcePackStatusEvent.Status
import java.util.UUID

internal class AxiPackSendingServiceImpl :
  SuspendingListener,
  AxiPackSendingService {
  private data class Entry(val player: UUID, val pack: UUID, val loaded: Boolean)

  private val flow: MutableSharedFlow<Entry> = MutableSharedFlow()
  private val discardedStatuses: Set<Status> = setOf(
    Status.ACCEPTED,
    Status.DOWNLOADED,
  )
  private val loadingPacks: MutableMap<UUID, MutableList<UUID>> = mutableMapOf()

  private suspend fun wait(uuid: UUID, packId: UUID): Boolean {
    loadingPacks.getOrPut(uuid, ::mutableListOf).add(packId)
    return flow.first { (player, pack) -> player == uuid && pack == packId }.loaded
  }

  @EventHandler
  private suspend fun on(event: PlayerQuitEvent) {
    val player = event.player.uniqueId

    loadingPacks[player]?.forEach { pack ->
      flow.emit(Entry(event.player.uniqueId, player, false))
    }
    loadingPacks.remove(player)
  }

  @EventHandler
  private suspend fun on(event: PlayerResourcePackStatusEvent) {
    val status = event.status
    if (status in discardedStatuses) {
      return
    }
    val player = event.player.uniqueId
    val loaded = status == Status.SUCCESSFULLY_LOADED
    flow.emit(Entry(player, event.id, loaded))
    loadingPacks.getOrPut(player, ::mutableListOf).remove(event.id)
  }

  override suspend fun Audience.sendAxiPack(pack: AxiPack): Map<UUID, Boolean> {
    val uri = buildServerURI("packs/${pack.name}")
    val info = resourcePackInfo()
      .hash(pack.hash)
      .uri(uri)
      .build()
    val request = addingRequest(info)
    val ignoredUuids = mutableListOf<UUID>()

    forEachPlayer { player ->
      val packsComponent = player.getOrPut(::AxiPacksComponent)
      // Pack is already applied.
      if (packsComponent.packs.any { (_, axiPack) -> axiPack == pack }) {
        ignoredUuids.add(player.uniqueId)
        return@forEachPlayer
      }

      sendResourcePacks(request)
    }

    return buildMap {
      supervisorScope {
        forEachPlayer { player ->
          val uuid = player.uniqueId
          if (uuid in ignoredUuids) {
            return@forEachPlayer
          }

          launch {
            val hasLoaded = wait(uuid, info.id())
            put(uuid, hasLoaded)
            if (hasLoaded) {
              player.getOrPut(::AxiPacksComponent).packs[request] = pack
            }
          }
        }
      }
    }
  }

  override suspend fun Audience.removeAxiPack(pack: AxiPack) {
    val players = players

    if (players.isEmpty()) {
      return
    }
    var packId: UUID? = null

    players.forEach { player ->
      val packsComponent = player.getOrPut(::AxiPacksComponent)
      val (sentRequest) = packsComponent.packs.entries.find { (_, axiPack) -> axiPack == pack } ?: return@forEach

      removeResourcePacks(sentRequest)
      packsComponent.packs.remove(sentRequest)

      packId = sentRequest.packs().first().id()
    }

    coroutineScope {
      forEachPlayer { player ->
        launch {
          wait(player.uniqueId, packId ?: return@launch)
        }
      }
    }
  }
}
