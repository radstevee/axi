package net.radstevee.axi.ui.render.layer

import net.kyori.adventure.text.TextComponent
import net.radstevee.axi.ui.render.RedrawableRenderable
import net.radstevee.axi.ui.render.Renderer
import net.radstevee.axi.ui.render.layer.layered.buildLayeredText
import net.radstevee.axi.ui.render.redraw.RedrawResult

/** A layer of components that can be rendered to an Audience, by using anything that can display text. */
public class RenderLayer(
  /** The contents of this layer. */
  public var contents: List<RenderLayerContents>,

  /** The renderer for this layer. */
  public override val renderer: Renderer,
) : RedrawableRenderable {
  /** Compiles this render layer to a component. */
  override suspend fun render(): TextComponent {
    val contents = contents.map { content -> content.content(false) }
    return buildLayeredText(layers = contents)
  }

  override suspend fun tickRedraw(tick: Int): RedrawResult {
    val results = contents.associateWith { contents -> contents.redrawHandler.tickRedraw(tick) }
    var finalResult = RedrawResult.None
    val indicesToRemove = mutableListOf<Int>()

    results.entries.forEachIndexed { idx, (_, result) ->
      if (result == RedrawResult.Dispose) {
        indicesToRemove.add(idx)
        finalResult = RedrawResult.Redraw
      } else if (result == RedrawResult.Redraw) {
        finalResult = RedrawResult.Redraw
        contents[idx].content(true)
      }
    }
    // If all contents are being disposed, we dispose ourselves
    if (results.values.all { result -> result == RedrawResult.Dispose }) {
      finalResult = RedrawResult.Dispose
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
