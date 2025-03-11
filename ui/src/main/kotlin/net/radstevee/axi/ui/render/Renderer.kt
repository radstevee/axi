package net.radstevee.axi.ui.render

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.TextComponent

/** Renders a renderable. */
public fun interface Renderer {
  /** Renders a given [renderable] for the given [audience]. The entire stacked content is provided with [stackedContent]. */
  public fun render(audience: Audience, renderable: Renderable, stackedContent: TextComponent)

  /** Built-in renderers. */
  public companion object Builtins {
    /** Renders a renderable to an audience's action bar. */
    public val Actionbar: Renderer = Renderer { audience, _, stacked ->
      audience.sendActionBar(stacked)
    }
  }
}
