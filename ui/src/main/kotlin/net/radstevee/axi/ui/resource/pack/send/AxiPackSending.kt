package net.radstevee.axi.ui.resource.pack.send

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.resource.ResourcePackInfo.resourcePackInfo
import net.kyori.adventure.resource.ResourcePackRequest.addingRequest
import net.radstevee.axi.core.ecs.getOrPut
import net.radstevee.axi.core.util.forEachPlayer
import net.radstevee.axi.ui.resource.host.buildServerURI
import net.radstevee.axi.ui.resource.pack.AxiPack

/** Sends an [AxiPack] to an audience if it is not applied yet. */
public fun Audience.sendAxiPack(pack: AxiPack) {
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
    packsComponent.packs[request] = pack
  }
}

/** Removes an [AxiPack] from an audience. */
public fun Audience.removeAxiPack(pack: AxiPack) {
  forEachPlayer { player ->
    val packsComponent = player.getOrPut(AxiPacksComponent())
    val (sentRequest) = packsComponent.packs.entries.find { (_, axiPack) -> axiPack == pack } ?: return@forEachPlayer

    removeResourcePacks(sentRequest)
    packsComponent.packs.remove(sentRequest)
  }
}
