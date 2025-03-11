package net.radstevee.axi.ui.render.layer

import net.kyori.adventure.text.TextComponent
import net.radstevee.axi.ui.render.Renderable
import net.radstevee.axi.ui.render.layer.layered.buildLayeredText

/** A layer of components that can be rendered to an Audience, by using anything that can display text. */
public class RenderedLayer(
  /** The contents of this layer. */
  public val contents: List<RenderLayerContents>,
) : Renderable {
  /** Compiles this render layer to a component. */
  override fun asText(): TextComponent = buildLayeredText(contents.flatMap(RenderLayerContents::contents))
}
