package net.radsteve.axi.ui.render.redraw.redraw

/** Something that can be redrawn. */
public fun interface Redrawable {
  /** Ticks this redrawable. */
  public suspend fun tickRedraw(tick: Int): RedrawResult
}
