package net.radsteve.axi.example.resource

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.radsteve.axi.ui.text.ColorRegistry

public object Colors : ColorRegistry() {
  // We're using the decayce theme here
  public val Green: TextColor = register(NamedTextColor.GREEN, 0x94f7c5)
  public val Yellow: TextColor = register(NamedTextColor.YELLOW, 0xf6d48f)
  public val Red: TextColor = register(NamedTextColor.RED, 0xdd6777)
  public val Blue: TextColor = register(NamedTextColor.BLUE, 0x86aaec)
}
