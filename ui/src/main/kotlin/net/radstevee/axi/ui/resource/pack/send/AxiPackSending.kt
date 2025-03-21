package net.radstevee.axi.ui.resource.pack.send

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.resource.ResourcePackInfo.resourcePackInfo
import net.kyori.adventure.resource.ResourcePackRequest.addingRequest
import net.radstevee.axi.ecs.getOrPut
import net.radstevee.axi.ui.resource.host.buildServerURI
import net.radstevee.axi.ui.resource.pack.AxiPack
import net.radstevee.axi.util.forEachPlayer
import net.radstevee.axi.util.players
import java.util.UUID

/**
 * Sends an [AxiPack] to an audience if it is not applied yet and
 * returns whether it loaded successfully for each player.
 * If a player disconnects whilst loading the pack, it will return false for them.
 */
public suspend fun Audience.sendAxiPack(pack: AxiPack): Map<UUID, Boolean> {
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
          val hasLoaded = SuspendingAxiPackSending.wait(uuid, info.id())
          put(uuid, hasLoaded)
          if (hasLoaded) {
            player.getOrPut(::AxiPacksComponent).packs[request] = pack
          }
        }
      }
    }
  }.withDefault { false }
}

/** Removes an [AxiPack] from an audience. */
public suspend fun Audience.removeAxiPack(pack: AxiPack) {
  val players = players()

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
        SuspendingAxiPackSending.wait(player.uniqueId, packId ?: return@launch)
      }
    }
  }
}
