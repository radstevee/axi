package net.radstevee.axi.example

import net.radstevee.axi.core.ecs.onClickEntity
import net.radstevee.axi.example.resource.ExampleAxiPack
import net.radstevee.axi.ui.resource.pack.send.sendAxiPack
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

public object ConnectionListener : Listener {
  @EventHandler
  private fun on(event: PlayerJoinEvent) {
    val player = event.player
    player.sendAxiPack(ExampleAxiPack)

    player
      .onClickEntity { (player, entity) ->
        player.sendRichMessage("You clicked a pig called <rainbow>${entity.name}</rainbow>!")
      }
      .filtering { (_, entity) -> entity.type == EntityType.PIG }
  }
}
