package net.radstevee.axi.ui.resource.pack

import net.radstevee.packed.core.key.Key

/** Provides fallback resources for a resource pack. */
public interface FallbackResourceProvider {
  /** Gets the fallback sprite key. */
  public fun sprite(pack: AxiPack): Key?

  /** Gets the fallback font key. */
  public fun font(pack: AxiPack): Key?

  /** Gets the fallback sound key. */
  public fun sound(pack: AxiPack): Key?

  public companion object Empty : FallbackResourceProvider {
    override fun sprite(pack: AxiPack): Key? {
      return null
    }

    override fun font(pack: AxiPack): Key? {
      return null
    }

    override fun sound(pack: AxiPack): Key? {
      return null
    }
  }
}
