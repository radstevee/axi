package net.radstevee.axi.npc

import net.radstevee.axi.DelegatingRegistry
import net.radstevee.axi.Registry

/** A skin data registry, delegating to [AxiSkins]. */
public class SkinRegistry : DelegatingRegistry<String, SkinData>(AxiSkins) {
  /** Delegating skin data registry. */
  public companion object AxiSkins : Registry<String, SkinData>()
}
