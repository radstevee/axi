package net.radstevee.axi.ui.render

/** The currently rendered renderables of an attachable. */
public data class PlayerRenderedComponent(
  /** The currently rendered renderables. */
  public val currentlyRenderedRenderables: MutableList<Renderable> = mutableListOf(),
)
