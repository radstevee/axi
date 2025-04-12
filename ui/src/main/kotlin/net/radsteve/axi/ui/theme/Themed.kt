package net.radsteve.axi.ui.theme

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.ComponentBuilderApplicable
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.format.TextColor
import net.radsteve.axi.ui.text.TextBuilder
import net.radsteve.axi.ui.text.buildText
import net.radsteve.axi.ui.text.send
import net.radsteve.axi.ui.text.text

/** Represents something that has a theme. */
public interface Themed {
  /** The theme. */
  public val theme: Theme

  /** Builds a component of the given [block] with this theme. */
  public fun buildText(applyFixes: Boolean = false, block: TextBuilder.() -> Unit = {}): TextComponent {
    return buildText(theme, applyFixes, block)
  }

  /** Builds a text component from the given [content] and applies the given [applicables]. */
  public fun text(
    content: Any,
    vararg applicables: ComponentBuilderApplicable?,
  ): TextComponent {
    return text(content, theme, *applicables)
  }

  /** Sends the audience a message built from the given [block] and this theme. */
  public fun Audience.send(block: TextBuilder.() -> Unit): TextComponent {
    return buildText(true, block).also(::sendMessage)
  }

  /** Builds a text component from the given [content], applies the given [applicables] and sends it. */
  public fun Audience.send(content: Any, vararg applicables: ComponentBuilderApplicable?): TextComponent {
    return send(content, theme, *applicables)
  }

  /** The foreground colour of the [theme]. */
  public val foreground: TextColor? get() = theme.foreground

  /** The accent colour of the [theme]. */
  public val accent: TextColor? get() = theme.accent

  /** The black colour of the [theme]. */
  public val black: TextColor? get() = theme.palette?.black

  /** The dark blue colour of the [theme]. */
  public val darkBlue: TextColor? get() = theme.palette?.darkBlue

  /** The dark green colour of the [theme]. */
  public val darkGreen: TextColor? get() = theme.palette?.darkGreen

  /** The dark aqua colour of the [theme]. */
  public val darkAqua: TextColor? get() = theme.palette?.darkAqua

  /** The dark red colour of the [theme]. */
  public val darkRed: TextColor? get() = theme.palette?.darkRed

  /** The dark purple colour of the [theme]. */
  public val darkPurple: TextColor? get() = theme.palette?.darkPurple

  /** The gold colour of the [theme]. */
  public val gold: TextColor? get() = theme.palette?.gold

  /** The gray colour of the [theme]. */
  public val gray: TextColor? get() = theme.palette?.gray

  /** The dark gray colour of the [theme]. */
  public val darkGray: TextColor? get() = theme.palette?.darkGray

  /** The blue colour of the [theme]. */
  public val blue: TextColor? get() = theme.palette?.blue

  /** The green colour of the [theme]. */
  public val green: TextColor? get() = theme.palette?.green

  /** The aqua colour of the [theme]. */
  public val aqua: TextColor? get() = theme.palette?.aqua

  /** The red colour of the [theme]. */
  public val red: TextColor? get() = theme.palette?.red

  /** The pink colour of the [theme]. */
  public val pink: TextColor? get() = theme.palette?.pink

  /** The yellow colour of the [theme]. */
  public val yellow: TextColor? get() = theme.palette?.yellow

  /** The white colour of the [theme]. */
  public val white: TextColor? get() = theme.palette?.white
}
