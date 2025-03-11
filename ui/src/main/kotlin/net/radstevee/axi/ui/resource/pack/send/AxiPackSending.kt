package net.radstevee.axi.ui.resource.pack.send

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.resource.ResourcePackInfo.resourcePackInfo
import net.kyori.adventure.resource.ResourcePackRequest.addingRequest
import net.radstevee.axi.core.util.uuid
import net.radstevee.axi.ui.resource.host.buildServerURI
import net.radstevee.axi.ui.resource.pack.AxiPack
import net.radstevee.axi.ui.resource.pack.send.SentResourcePackTracker.sentPacks

/** Sends an [AxiPack] to an audience if it is not applied yet. */
public fun Audience.sendAxiPack(pack: AxiPack) {
  val uri = buildServerURI("packs/${pack.name}")
  val info = resourcePackInfo()
    .hash(pack.hash)
    .uri(uri)
    .build()

  val request = addingRequest(info)

  forEachAudience { audience ->
    // Pack is already applied.
    if (audience.sentPacks().any { (_, axiPack) -> axiPack == pack }) {
      return@forEachAudience
    }

    sendResourcePacks(request)
    SentResourcePackTracker.trackAdd(audience.uuid(), request, pack)
  }
}

/** Removes an [AxiPack] from an audience. */
public fun Audience.removeAxiPack(pack: AxiPack) {
  forEachAudience { audience ->
    val (sentRequest) = sentPacks().find { (_, axiPack) -> axiPack == pack } ?: return@forEachAudience

    removeResourcePacks(sentRequest)
    SentResourcePackTracker.trackRemovePack(uuid(), pack)
  }
}
