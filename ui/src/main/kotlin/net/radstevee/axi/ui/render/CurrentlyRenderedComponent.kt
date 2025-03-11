package net.radstevee.axi.ui.render

/** The currently rendered renderables of an attachable. */
public data class CurrentlyRenderedComponent(
    /** The currently rendered renderables. */
    public val currentlyRenderedRenderables: MutableList<Renderable> = mutableListOf()
)
