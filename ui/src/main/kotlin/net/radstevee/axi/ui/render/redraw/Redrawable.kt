package net.radstevee.axi.ui.render.redraw

/** Something that can be redrawn. */
public fun interface Redrawable {
  /** Ticks this redrawable. */
  public fun tickRedraw(tick: Int): RedrawResult
}
