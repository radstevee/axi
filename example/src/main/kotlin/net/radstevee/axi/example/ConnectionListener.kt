package net.radstevee.axi.example

import kotlinx.coroutines.launch
import net.radstevee.axi.ecs.onClickEntity
import net.radstevee.axi.example.resource.ExamplePack
import net.radstevee.axi.example.resource.testRenderLayer
import net.radstevee.axi.plugin.event.SuspendingListener
import net.radstevee.axi.ui.render.layer.addRenderable
import net.radstevee.axi.ui.resource.pack.send.sendAxiPack
import net.radstevee.axi.ui.text.TextBuilder
import net.radstevee.axi.ui.text.send
import org.bukkit.Bukkit
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent

public object ConnectionListener : SuspendingListener {
  @EventHandler
  private suspend fun on(event: PlayerJoinEvent) {
    val player = event.player
    // In case the player has some kind of mod installed to
    // interact with the server before the pack loads, we
    // launch a job to immediately apply the on click
    // component. Our pig listener is VERY important!
    launch {
      player
        .onClickEntity { (player, entity) ->
          player.sendRichMessage("You clicked a pig called <rainbow>${entity.name}</rainbow>!")
        }
        .filtering { (_, entity) -> entity.type == EntityType.PIG }
    }

    player.send {
      append("You started loading the pack at: ")
      append(Bukkit.getCurrentTick(), TextBuilder::green)
      append(" ticks!")
      yellow()
    }
    player.sendAxiPack(ExamplePack)
    player.send {
      append("You loaded the pack at: ")
      append(Bukkit.getCurrentTick(), TextBuilder::yellow)
      append(" ticks!")
      green()
    }

    player.addRenderable(testRenderLayer(Bukkit.getCurrentTick()))
  }
}
