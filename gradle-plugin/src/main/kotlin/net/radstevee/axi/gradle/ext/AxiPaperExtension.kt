package net.radstevee.axi.gradle.ext

import net.radstevee.axi.gradle.AxiDependencies
import org.gradle.api.provider.Property

public abstract class AxiPaperExtension {
  public abstract val internals: Property<Boolean>
  public abstract val apiCoordinates: Property<String>
  public abstract val devBundleCoordinates: Property<String>

  public fun internals() {
    internals.set(true)
  }

  public fun api(coordinates: String = AxiDependencies.Coordinates.PAPER_API) {
    apiCoordinates.set(coordinates)
  }

  public fun internals(coordinates: String) {
    devBundleCoordinates.set(coordinates)
  }
}
