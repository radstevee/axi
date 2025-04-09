package net.radsteve.axi.ui.theme

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor

/** A theme, consisting of colours and a suffix/prefix. */
public data class Theme(
  /** The foreground colour. */
  public val foreground: TextColor? = null,
  /** The accent colour. */
  public val accent: TextColor? = null,
  /** The "regular" colour palette consisting of all other colours. */
  public val palette: ColorPalette? = ColorPalette(),
  /** The text prefix. */
  public val prefix: Component? = null,
  /** The text suffix. */
  public val suffix: Component? = null,
) {
  public companion object {
    public val Default: Theme = Theme()
  }
}
