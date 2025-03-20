package net.radstevee.axi.ui.render.layer

import net.radstevee.axi.ui.render.RedrawableRenderable
import net.radstevee.axi.ui.render.renderState
import org.bukkit.entity.Player

/** Adds and displays the given [renderable] to the player. */
public fun Player.addRenderable(renderable: RedrawableRenderable) {
  renderState.currentlyRenderedRenderables.add(renderable)
}
