package net.radsteve.axi.npc

import net.radsteve.axi.DelegatingRegistry
import net.radsteve.axi.Registry

/** A skin data registry, delegating to [AxiSkins]. */
public class SkinRegistry : DelegatingRegistry<String, SkinData>(AxiSkins) {
  /** Delegating skin data registry. */
  public companion object AxiSkins : Registry<String, SkinData>()
}
