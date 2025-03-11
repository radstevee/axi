package net.radstevee.axi.example.resource

import net.radstevee.axi.ui.resource.pack.AxiPack
import net.radstevee.axi.ui.resource.pack.AxiPackRegistry
import net.radstevee.packed.core.asset.impl.SourceDirectoryAssetResolutionStrategy
import net.radstevee.packed.core.pack.PackFormat
import net.radstevee.packed.core.pack.ResourcePack
import net.radstevee.packed.core.pack.ResourcePackBuilder.Companion.resourcePack
import java.io.File

public object ExampleAxiPack : AxiPack("example") {
  override val pack: ResourcePack = resourcePack {
    meta {
      outputDir = outputDirectory
      description = "Example axi pack"
      format = PackFormat.V1_21_4
    }

    assetResolutionStrategy = SourceDirectoryAssetResolutionStrategy(File("../assets"))

    applyAxi()
  }

  init {
    AxiPackRegistry.AxiPacks.register("example", this)
  }
}
