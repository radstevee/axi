package net.radsteve.axi.ui.render.layer

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.radsteve.axi.ui.AxiUI
import net.radsteve.axi.ui.render.Renderer
import net.radsteve.axi.ui.render.redraw.RedrawResult
import net.radsteve.axi.ui.render.redraw.Redrawable
import net.radsteve.axi.ui.text.TextBuilder
import net.radsteve.axi.ui.text.buildText
import net.radsteve.axi.ui.theme.Theme

/** A builder for [RenderLayer]s. */
public class RenderedLayerBuilder {
  private val contents = mutableListOf<RenderLayerContents>()
  private var renderer: Renderer = Renderer.Actionbar

  /** A builder for [RenderLayerContents] */
  public inner class RenderLayerContentBuilder(
    /** The theme. */
    private val theme: Theme,
  ) {
    public var contentProvider: suspend () -> Component = { Component.empty() }
    public var redrawHandler: Redrawable = Redrawable { _ -> RedrawResult.Redraw }

    /** Sets the content provider, and if applicable, with the given [offset]. */
    public fun content(offset: Int = 0, block: suspend TextBuilder.() -> Unit) {
      if (offset == 0) {
        contentProvider = { buildText(theme) { block() } }
        return
      }
      contentProvider = {
        buildText(theme) {
          appendSpace(offset)
          block()
        }
      }
    }

    /** Adds a constant content with the given [offset]. */
    public fun content(offset: Int = 0, content: Component) {
      if (offset == 0) {
        contentProvider = { content }
        return
      }
      contentProvider = {
        buildText(theme) {
          appendSpace(offset)
        }
      }
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

  /** Adds a content entry to this layer. */
  public fun add(theme: Theme = AxiUI.theme, block: RenderLayerContentBuilder.() -> Unit): RenderLayerContents {
    val content = RenderLayerContentBuilder(theme).apply(block).build()
    contents.add(content)
    return content
  }

  /** Adds a constant entry to this layer of the given [content]. */
  public fun constant(content: Component, offset: Int = 0, theme: Theme = AxiUI.theme): RenderLayerContents {
    return add(theme) {
      content(offset, content)
    }
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

/** Builds a render layer from the given [block]. */
public fun buildRenderLayer(block: RenderedLayerBuilder.() -> Unit): RenderLayer {
  return RenderedLayerBuilder().apply(block).build()
}
