package net.radsteve.axi.example.resource

import net.radsteve.axi.ui.resource.font.AxiFontRegistry
import net.radsteve.axi.ui.resource.font.AxiOffsetFont
import net.radsteve.axi.ui.resource.font.StoredTruetypeFont
import java.io.File

public object Fonts : AxiFontRegistry() {
  public val Beaver: StoredTruetypeFont = registerStoredTtf("beaver", "axi", File("../assets/fonts/beaver.ttf"), ExamplePack)
  public val BeaverOffsets: Map<Double, AxiOffsetFont> = registerOffsets(Beaver, ExamplePack)
}
