package net.radstevee.axi.ui.resource.pack.send

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.resource.ResourcePackInfo.resourcePackInfo
import net.kyori.adventure.resource.ResourcePackRequest.addingRequest
import net.radstevee.axi.core.ecs.getOrPut
import net.radstevee.axi.core.util.forEachPlayer
import net.radstevee.axi.core.util.players
import net.radstevee.axi.ui.resource.host.buildServerURI
import net.radstevee.axi.ui.resource.pack.AxiPack
import java.util.UUID

/** Sends an [AxiPack] to an audience if it is not applied yet. */
public suspend fun Audience.sendAxiPack(pack: AxiPack) {
  val uri = buildServerURI("packs/${pack.name}")
  val info = resourcePackInfo()
    .hash(pack.hash)
    .uri(uri)
    .build()
  val request = addingRequest(info)

  forEachPlayer { player ->
    val packsComponent = player.getOrPut(AxiPacksComponent())
    // Pack is already applied.
    if (packsComponent.packs.any { (_, axiPack) -> axiPack == pack }) {
      return@forEachPlayer
    }

    sendResourcePacks(request)
  }

  coroutineScope {
    forEachPlayer { player ->
      launch {
        SuspendingAxiPackSending.wait(player.uniqueId, info.id())
        player.getOrPut(AxiPacksComponent()).packs[request] = pack
      }
    }
  }
}

/** Removes an [AxiPack] from an audience. */
public suspend fun Audience.removeAxiPack(pack: AxiPack) {
  val players = players()

  if (players.isEmpty()) {
    return
  }

  var packId: UUID? = null

  players.forEach { player ->
    val packsComponent = player.getOrPut(AxiPacksComponent())
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
