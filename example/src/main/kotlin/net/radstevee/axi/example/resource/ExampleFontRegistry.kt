package net.radstevee.axi.example.resource

import net.radstevee.axi.ui.resource.font.AxiFontRegistry
import net.radstevee.axi.ui.resource.font.AxiOffsetFont
import net.radstevee.axi.ui.resource.font.StoredTruetypeFont
import java.io.File

public object ExampleFontRegistry : AxiFontRegistry() {
  public val Beaver: StoredTruetypeFont = registerStoredTtf("beaver", "axi", File("../assets/fonts/beaver.ttf"), ExampleAxiPack)
  public val BeaverOffsets: Map<Double, AxiOffsetFont> = registerOffsets(Beaver, ExampleAxiPack)
}
