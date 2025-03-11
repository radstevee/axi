package net.radstevee.axi.ui.resource.pack.send

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.resource.ResourcePackRequest
import net.radstevee.axi.core.util.uuid
import net.radstevee.axi.ui.resource.pack.AxiPack
import java.util.UUID

private typealias SentPacksList = MutableList<Pair<ResourcePackRequest, AxiPack>>

internal object SentResourcePackTracker {
  private val sentPacks: MutableMap<UUID, SentPacksList> = mutableMapOf()

  fun trackAdd(uuid: UUID, request: ResourcePackRequest, pack: AxiPack) {
    sentPacks.getOrPut(uuid, ::mutableListOf).add(request to pack)
  }

  fun trackRemovePack(uuid: UUID, pack: AxiPack) {
    sentPacks.getOrPut(uuid, ::mutableListOf).removeIf { (_, axiPack) -> axiPack == pack }
  }

  fun clear(uuid: UUID) {
    sentPacks.remove(uuid)
  }

  fun Audience.sentPacks(): SentPacksList = sentPacks[uuid()] ?: mutableListOf()
}
