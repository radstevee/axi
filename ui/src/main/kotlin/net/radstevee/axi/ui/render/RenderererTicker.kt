package net.radstevee.axi.ui.render

import io.papermc.paper.event.packet.ClientTickEndEvent
import net.radstevee.axi.core.ecs.get
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

internal object RenderererTicker : Listener {
  @EventHandler
  private fun on(event: ClientTickEndEvent) {
    val player = event.player
    val renderState = player.get<RenderStateComponent>() ?: return

    renderState.currentlyRenderedRenderables.forEach { renderable ->
      renderable.renderTick(Bukkit.getCurrentTick(), player)
    }
  }
}
