package net.radsteve.axi.ui.render.redraw

/** A result from a redraw. */
public enum class RedrawResult {
  /** Redraw the renderable. */
  Redraw,

  /** Disposes and removes the renderable. */
  Dispose,

  /** Does nothing. */
  None,
}
