package net.radsteve.axi.ecs.internal

import net.radsteve.axi.ecs.ECS
import net.radsteve.axi.ecs.attachable
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

internal object ECSConnectionListener : Listener {
  @EventHandler
  private fun on(event: PlayerQuitEvent) {
    val player = event.player

    ECS.Companion.remove(player.attachable)
    PlayerTracker.unset(player.uniqueId)
  }
}
