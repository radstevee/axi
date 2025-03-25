package net.radstevee.axi.gradle.ext

import org.gradle.api.provider.Property
import org.jetbrains.annotations.ApiStatus.Experimental

public abstract class AxiVersionExtension {
  internal abstract val ksp: Property<String>
  internal abstract val axi: Property<String>
  internal abstract val minecraft: Property<String>

  public fun ksp(version: String) {
    ksp.set(version)
  }

  public fun axi(version: String) {
    axi.set(version)
  }

  @Experimental
  public fun minecraft(version: String) {
    minecraft.set(version)
  }
}
