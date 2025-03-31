package net.radsteve.axi.ui.render

import net.kyori.adventure.text.TextComponent

/** Represents something that can be rendered to an audience. */
public interface Renderable {
  /** The renderer for this renderable. */
  public val renderer: Renderer

  /** Renders this renderable. */
  public suspend fun render(): TextComponent
}
