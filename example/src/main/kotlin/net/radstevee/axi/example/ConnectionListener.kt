package net.radstevee.axi.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.radstevee.axi.ecs.addDebounce
import net.radstevee.axi.ecs.onClickEntity
import net.radstevee.axi.ecs.waitUntilDebounced
import net.radstevee.axi.example.resource.ExamplePack
import net.radstevee.axi.example.resource.OtherLayer
import net.radstevee.axi.example.resource.testRenderLayer
import net.radstevee.axi.event.SuspendingListener
import net.radstevee.axi.npc.NPC
import net.radstevee.axi.npc.SkinData
import net.radstevee.axi.ui.render.layer.addRenderable
import net.radstevee.axi.ui.resource.pack.send.sendAxiPack
import net.radstevee.axi.ui.text.TextBuilder
import net.radstevee.axi.ui.text.buildText
import net.radstevee.axi.ui.text.send
import net.radstevee.axi.utility.nms
import org.bukkit.Bukkit
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent
import kotlin.time.Duration.Companion.seconds

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
        .withFilter { (_, entity) -> entity.type == EntityType.PIG }
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

    val playerSkin = player.nms.gameProfile.properties.get("textures").first()
    NPC(
      buildText {
        append("weeee")
        green()
      },
      player.location,
      SkinData(
        playerSkin.value,
        playerSkin.signature!!
      ),
    ).show(player)

    player.addRenderable(testRenderLayer(Bukkit.getCurrentTick()))
    delay(1.seconds)
    player.addRenderable(OtherLayer)

    player.send {
      append("Started waiting at: ")
      append(Bukkit.getCurrentTick(), TextBuilder::yellow)
      append(" ticks")
      green()
    }
    player.addDebounce(ConnectionListener::class, 5.seconds) // 100 ticks
    player.waitUntilDebounced(ConnectionListener::class)
    player.send {
      append("Finished waiting at: ")
      append(Bukkit.getCurrentTick(), TextBuilder::green)
      append(" ticks")
      yellow()
    }
  }
}
