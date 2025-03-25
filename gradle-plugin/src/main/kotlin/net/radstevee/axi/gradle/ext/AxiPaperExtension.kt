package net.radstevee.axi.gradle.ext

import org.gradle.api.provider.Property

public abstract class AxiPaperExtension {
  internal abstract val internals: Property<Boolean>

  public fun internals() {
    internals.set(true)
  }
}
