package net.radstevee.axi.ui.render

/** The currently rendered renderables of an attachable. */
public data class RenderStateComponent(
  /** The currently rendered renderables. */
  public val currentlyRenderedRenderables: MutableSet<RedrawableRenderable> = mutableSetOf(),
)
