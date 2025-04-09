package net.radsteve.axi.ui.theme

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.TextComponent
import net.radsteve.axi.ui.text.TextBuilder
import net.radsteve.axi.ui.text.buildText

/** Represents something that has a theme. */
public interface Themed {
  /** The theme. */
  public val theme: Theme

  /** Builds a component of the given [block] with this theme. */
  public fun buildText(applyFixes: Boolean = false, block: TextBuilder.() -> Unit = {}): TextComponent {
    return buildText(theme, applyFixes, block)
  }

  /** Sends the audience a message built from the given [block] and this theme. */
  public fun Audience.send(block: TextBuilder.() -> Unit) {
    sendMessage(buildText(true, block))
  }
}
