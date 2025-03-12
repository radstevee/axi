package net.radstevee.axi.ui.render

import net.radstevee.axi.ui.text.TextConvertible

/** Represents something that can be rendered to an audience. */
public interface Renderable : TextConvertible {
  /** The renderer for this renderable. */
  public val renderer: Renderer
}
