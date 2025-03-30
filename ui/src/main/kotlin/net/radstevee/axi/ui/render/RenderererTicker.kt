package net.radstevee.axi.ui.render

import io.papermc.paper.event.packet.ClientTickEndEvent
import net.radstevee.axi.ecs.get
import net.radstevee.axi.event.SuspendingListener
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler

internal object RenderererTicker : SuspendingListener {
  @EventHandler
  private suspend fun on(event: ClientTickEndEvent) {
    val player = event.player
    val renderState = player.renderState

    renderState.currentlyRenderedRenderables.forEach { renderable ->
      renderable.renderTick(Bukkit.getCurrentTick(), player)
    }
  }
}
