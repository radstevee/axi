package net.radstevee.axi.core.ecs

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

internal object ECSConnectionListener : Listener {
    @EventHandler
    private fun on(event: PlayerQuitEvent) {
        val player = event.player

        ECSDataTracker.clear(player.attachable)
        PlayerTracker.unset(player.uniqueId)
    }
}
