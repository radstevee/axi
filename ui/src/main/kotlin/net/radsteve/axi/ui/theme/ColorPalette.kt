package net.radsteve.axi.ui.theme

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor

/** A palette of 16 colours representing the 16 vanilla colours. */
public data class ColorPalette(
  public val black: TextColor? = NamedTextColor.BLACK,
  public val darkBlue: TextColor? = NamedTextColor.DARK_BLUE,
  public val darkGreen: TextColor? = NamedTextColor.DARK_GREEN,
  public val darkAqua: TextColor? = NamedTextColor.DARK_AQUA,
  public val darkRed: TextColor? = NamedTextColor.DARK_RED,
  public val darkPurple: TextColor? = NamedTextColor.DARK_PURPLE,
  public val gold: TextColor? = NamedTextColor.GOLD,
  public val gray: TextColor? = NamedTextColor.GRAY,
  public val darkGray: TextColor? = NamedTextColor.DARK_GRAY,
  public val blue: TextColor? = NamedTextColor.BLUE,
  public val green: TextColor? = NamedTextColor.GREEN,
  public val aqua: TextColor? = NamedTextColor.AQUA,
  public val red: TextColor? = NamedTextColor.RED,
  public val pink: TextColor? = NamedTextColor.LIGHT_PURPLE,
  public val yellow: TextColor? = NamedTextColor.YELLOW,
  public val white: TextColor? = NamedTextColor.WHITE,
) {
  public companion object {
    public val Default: ColorPalette = ColorPalette()
  }
}
