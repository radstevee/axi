package net.radstevee.axi.ui.resource.pack.send

import net.kyori.adventure.resource.ResourcePackRequest
import net.radstevee.axi.ui.resource.pack.AxiPack

/** A component that holds the currently sent resource packs. */
public data class AxiPacksComponent(
  /** The resource packs. Do not mutate this but rather use [sendAxiPack] and [removeAxiPack]. */
  public val packs: MutableMap<ResourcePackRequest, AxiPack> = mutableMapOf(),
)
