package net.radsteve.axi.example.resource

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.radsteve.axi.ui.text.ColorRegistry

public object Colors : ColorRegistry() {
  public val Green: TextColor = register(NamedTextColor.GREEN, 0x94f7c5)
  public val Yellow: TextColor = register(NamedTextColor.YELLOW, 0xf6d48f)
}
