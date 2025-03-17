package net.radstevee.axi.ui.render.layer

import net.kyori.adventure.text.TextComponent
import net.radstevee.axi.ui.render.redraw.RedrawResult
import net.radstevee.axi.ui.render.redraw.Redrawable

/** The content of a render layer. */
public data class RenderLayerContents(
  /**
   * The text contents of this layer. If you do not wish to use
   * a text component here, add an empty text component with children.
   */
  public val contentProvider: suspend () -> TextComponent,
  public val redrawHandler: Redrawable = Redrawable { _ -> RedrawResult.Redraw },
) {
  internal var cachedContent: TextComponent? = null

  internal suspend fun content(redraw: Boolean): TextComponent = if (redraw) {
    cachedContent = contentProvider()
    cachedContent!!
  } else {
    if (cachedContent == null) {
      cachedContent = contentProvider()
    }

    cachedContent!!
  }
}
