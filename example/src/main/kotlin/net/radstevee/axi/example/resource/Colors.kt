package net.radstevee.axi.example.resource

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.radstevee.axi.ui.text.ColorRegistry

object Colors : ColorRegistry() {
  val Green: TextColor = register(NamedTextColor.GREEN, 0x94f7c5)
  val Yellow: TextColor = register(NamedTextColor.YELLOW, 0xf6d48f)
}
