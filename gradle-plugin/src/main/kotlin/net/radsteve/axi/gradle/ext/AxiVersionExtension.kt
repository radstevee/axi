package net.radsteve.axi.gradle.ext

import org.gradle.api.provider.Property
import org.jetbrains.annotations.ApiStatus

public abstract class AxiVersionExtension {
  public abstract val axi: Property<String>
  public abstract val minecraft: Property<String>

  public fun axi(version: String) {
    axi.set(version)
  }

  @ApiStatus.Experimental
  public fun minecraft(version: String) {
    minecraft.set(version)
  }
}
