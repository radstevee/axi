package net.radstevee.axi.ui.resource.pack

import net.radstevee.axi.core.DelegatingRegistry
import net.radstevee.axi.core.Registry
import net.radstevee.packed.core.key.Key
import net.radstevee.packed.negativespaces.NegativeSpaces

/** A registry of resource packs, delegating to [AxiPacks]. */
public open class AxiPackRegistry : DelegatingRegistry<String, AxiPack>(AxiPacks) {
    /** Delegating resource pack registry. */
    public companion object AxiPacks : Registry<String, AxiPack>(modifiable = true) {
        public var NegativeSpaces: NegativeSpaces = NegativeSpaces(Key("axi", "spaces"))
    }
}
