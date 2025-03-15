package net.radstevee.axi.ui.render.layer

import net.radstevee.axi.ui.render.renderState
import org.bukkit.entity.Player

/** Adds the given [layer] to the player. */
public fun Player.addRenderLayer(layer: RenderLayer) {
  renderState.currentlyRenderedRenderables.add(layer)
}
