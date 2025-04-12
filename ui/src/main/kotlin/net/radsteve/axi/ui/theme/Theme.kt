package net.radsteve.axi.ui.theme

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor

/** A theme, consisting of colours and a suffix/prefix. */
public data class Theme(
  /** The foreground colour. */
  public val foreground: TextColor? = NamedTextColor.WHITE,

  /** The accent colour. */
  public val accent: TextColor? = NamedTextColor.BLUE,

  /** The "regular" colour palette consisting of all other colours. */
  public val palette: ColorPalette? = ColorPalette.Minecraft,

  /** The text prefix. */
  public val prefix: Component? = null,

  /** The text suffix. */
  public val suffix: Component? = null,
) {
  public companion object {
    /** The default theme, with Minecraft colours. */
    public val Default: Theme = Theme()
  }
}
