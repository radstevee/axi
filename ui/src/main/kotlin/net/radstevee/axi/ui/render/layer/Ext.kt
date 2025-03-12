package net.radstevee.axi.ui.render.layer

import net.radstevee.axi.core.ecs.getOrPut
import net.radstevee.axi.ui.render.RenderStateComponent
import org.bukkit.entity.Player

/** Adds the given [layer] to the player. */
public fun Player.addRenderLayer(layer: RenderLayer) {
  val renderState = getOrPut(RenderStateComponent())
  renderState.currentlyRenderedRenderables.add(layer)
}
