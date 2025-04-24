package net.radsteve.axi.ui.render.layer

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.radsteve.axi.ui.render.redraw.RedrawResult
import net.radsteve.axi.ui.render.redraw.Redrawable

/** The content of a render layer. */
public data class RenderLayerContents(
  /** The text contents of this layer. */
  public val contentProvider: suspend () -> Component,
  public val redrawHandler: Redrawable = Redrawable { _ -> RedrawResult.Redraw },
) {
  internal var cachedContent: Component? = null

  internal suspend fun content(redraw: Boolean): Component {
    return if (redraw) {
      cachedContent = contentProvider()
      cachedContent!!
    } else {
      if (cachedContent == null) {
        cachedContent = contentProvider()
      }

      cachedContent!!
    }
  }
}
