package net.radstevee.axi.ui.resource.pack

import net.radstevee.axi.DelegatingRegistry
import net.radstevee.axi.Registry
import net.radstevee.packed.core.key.Key
import net.radstevee.packed.negativespaces.NegativeSpaces

/** A registry of resource packs, delegating to [AxiPacks]. */
public open class AxiPackRegistry : DelegatingRegistry<String, AxiPack>(AxiPacks) {
  /** Delegating resource pack registry. */
  public companion object AxiPacks : Registry<String, AxiPack>(modifiable = true) {
    public var negativeSpaces: NegativeSpaces = NegativeSpaces(Key("axi", "spaces"))
  }
}
