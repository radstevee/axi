package net.radsteve.axi.ui.resource.pack

import net.radsteve.axi.DelegatingRegistry
import net.radsteve.axi.Registry
import net.radstevee.packed.core.key.Key
import net.radstevee.packed.negativespaces.NegativeSpaces

/** A registry of resource packs, delegating to [AxiPacks]. */
public open class AxiPackRegistry : DelegatingRegistry<String, AxiPack>(AxiPacks) {
  /** Delegating resource pack registry. */
  public companion object AxiPacks : Registry<String, AxiPack>(modifiable = true) {
    public var negativeSpaces: NegativeSpaces = NegativeSpaces(Key("axi", "spaces"))
  }
}
