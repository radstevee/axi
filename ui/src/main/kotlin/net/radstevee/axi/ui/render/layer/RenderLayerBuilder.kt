package net.radstevee.axi.ui.render.layer

import net.kyori.adventure.text.TextComponent
import net.radstevee.axi.ui.render.Renderer
import net.radstevee.axi.ui.render.redraw.RedrawResult
import net.radstevee.axi.ui.render.redraw.Redrawable
import net.radstevee.axi.ui.text.TextBuilder
import net.radstevee.axi.ui.text.buildText

/** A builder for [RenderLayer]s. */
public class RenderedLayerBuilder {
  private val contents = mutableListOf<RenderLayerContents>()
  private var renderer: Renderer = Renderer.Actionbar

  /** A builder for [RenderLayerContents] */
  public inner class RenderLayerContentBuilder(private val offset: Int) {
    private var contentProvider: () -> TextComponent = { buildText() }
    private var redrawHandler: Redrawable = Redrawable { _ -> RedrawResult.Redraw }

    /** Sets the content provider, and if applicable, with the given [offset]. */
    public fun content(offset: Int = 0, block: TextBuilder.() -> Unit) {
      if (offset == 0) {
        contentProvider = { buildText(block) }
        return
      }
      contentProvider = { buildText { appendSpace(offset); apply(block) } }
    }

    /** Sets the redraw handler to the given [redrawable]. */
    public fun redraw(redrawable: Redrawable) {
      redrawHandler = redrawable
    }

    /** Builds this to [RenderLayerContents]. */
    public fun build(): RenderLayerContents {
      return RenderLayerContents(contentProvider, redrawHandler)
    }
  }

  /** Adds a content entry to this layer, and if applicable, with the given [offset]. */
  public fun add(offset: Int = 0, block: RenderLayerContentBuilder.() -> Unit): RenderLayerContents {
    val content = RenderLayerContentBuilder(offset).apply(block).build()
    contents.add(content)
    return content
  }

  /** Sets the renderer. */
  public fun renderer(renderer: Renderer) {
    this.renderer = renderer
  }

  /** Builds this to a [RenderLayer]. */
  public fun build(): RenderLayer {
    return RenderLayer(contents, renderer)
  }
}

public fun buildRenderLayer(block: RenderedLayerBuilder.() -> Unit): RenderLayer {
  return RenderedLayerBuilder().apply(block).build()
}
