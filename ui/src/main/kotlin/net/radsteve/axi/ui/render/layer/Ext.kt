package net.radsteve.axi.ui.render.layer

import net.radsteve.axi.ui.render.RedrawableRenderable
import net.radsteve.axi.ui.render.renderState
import org.bukkit.entity.Player

/** Adds and displays the given [renderable] to the player. */
public fun Player.addRenderable(renderable: RedrawableRenderable) {
  renderState.currentlyRenderedRenderables.add(renderable)
}

/** Clears the currently rendered renderables. */
public fun Player.clearRenderables() {
  renderState.currentlyRenderedRenderables.clear()
}
