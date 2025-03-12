package net.radstevee.axi.ui.render.layer

import com.destroystokyo.paper.event.server.ServerTickEndEvent
import net.radstevee.axi.core.ecs.ECSDataTracker
import net.radstevee.axi.core.ecs.ECSDataTracker.get
import net.radstevee.axi.core.ecs.WrappedAttachable
import net.radstevee.axi.ui.render.RenderStateComponent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import java.util.UUID

internal object RenderLayerTicker : Listener {
  @EventHandler
  private fun on(event: ServerTickEndEvent) {
    ECSDataTracker.attachables()
      .forEach { attachable ->
        val renderState = attachable.get<RenderStateComponent>() ?: return@forEach
        // We only want to render for players.
        val wrappedAttachable = attachable as? WrappedAttachable<*> ?: return@forEach
        if (wrappedAttachable.klass != UUID::class) {
          return@forEach
        }

        val uuid = wrappedAttachable.wrapped as UUID
        val player = Bukkit.getPlayer(uuid) ?: return@forEach

        renderState.currentlyRenderedRenderables.forEach { renderable ->
          renderable.renderTick(event.tickNumber, player)
        }
      }
  }
}
