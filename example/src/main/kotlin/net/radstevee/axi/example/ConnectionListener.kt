package net.radstevee.axi.example

import net.radstevee.axi.example.resource.ExampleAxiPack
import net.radstevee.axi.ui.resource.pack.send.sendAxiPack
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

public object ConnectionListener : Listener {
    @EventHandler
    private fun on(event: PlayerJoinEvent) {
        event.player.sendAxiPack(ExampleAxiPack)
    }
}
