package net.radstevee.axi.ui.render.layer

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.TextComponent
import net.radstevee.axi.ui.render.CompositeRenderer
import net.radstevee.axi.ui.render.Renderable
import net.radstevee.axi.ui.render.Renderer
import net.radstevee.axi.ui.render.layer.layered.buildLayeredText
import net.radstevee.axi.ui.render.redraw.RedrawResult
import net.radstevee.axi.ui.render.redraw.Redrawable

/** A layer of components that can be rendered to an Audience, by using anything that can display text. */
public class RenderedLayer(
  /** The contents of this layer. */
  public var contents: List<RenderLayerContents>,

  /** The renderer for this layer. */
  public val renderer: Renderer,
) : Renderable, Redrawable {
  /** Compiles this render layer to a component. */
  override fun asText(): TextComponent {
    val contents = contents.map { content -> content.content(true) }
    return buildLayeredText(contents)
  }

  /** Renders this layer using the [CompositeRenderer] to the given [audience]. */
  public fun render(audience: Audience) {
    CompositeRenderer.render(this, renderer, audience)
  }

  override fun tickRedraw(tick: Int): RedrawResult {
    val results = contents.associateWith { contents -> contents.redrawHandler.tickRedraw(tick) }
    var finalResult = RedrawResult.None
    val indicesToRemove = mutableListOf<Int>()

    results.entries.forEachIndexed { idx, (_, result) ->
      if (result == RedrawResult.Dispose) {
        indicesToRemove.add(idx)
        finalResult = RedrawResult.Redraw
      } else if (result == RedrawResult.Redraw) {
        finalResult = RedrawResult.Redraw
      }
    }

    contents = buildList {
      contents.forEachIndexed { idx, contents ->
        if (idx !in indicesToRemove) {
          add(contents)
        }
      }
    }

    return finalResult
  }
}
