package net.radsteve.axi.ui.render

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.TextComponent
import net.radsteve.axi.ui.text.send

/** Renders a renderable. */
public fun interface Renderer {
  /** Renders a given [renderable] for the given [audience]. The entire stacked content is provided with [stackedContent]. */
  public suspend fun render(audience: Audience, renderable: Renderable, stackedContent: TextComponent)

  /** Built-in renderers. */
  public companion object Builtins {
    /** Renders a renderable to an audience's action bar. */
    public val Actionbar: Renderer = Renderer { audience, _, stacked ->
      audience.sendActionBar(stacked)
    }

    public val Chat: Renderer = Renderer { audience, _, stacked ->
      audience.send {
        repeat(16) { appendNewline() }
      }
      audience.sendMessage(stacked)
    }
  }
}
