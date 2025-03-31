package net.radsteve.axi.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.radsteve.axi.ecs.addDebounce
import net.radsteve.axi.ecs.onClickEntity
import net.radsteve.axi.ecs.waitUntilDebounced
import net.radsteve.axi.example.resource.ExamplePack
import net.radsteve.axi.example.resource.OtherLayer
import net.radsteve.axi.example.resource.testRenderLayer
import net.radsteve.axi.event.SuspendingListener
import net.radsteve.axi.npc.NPC
import net.radsteve.axi.npc.SkinData
import net.radsteve.axi.ui.render.layer.addRenderable
import net.radsteve.axi.ui.resource.pack.send.sendAxiPack
import net.radsteve.axi.ui.text.TextBuilder
import net.radsteve.axi.ui.text.buildText
import net.radsteve.axi.ui.text.send
import net.radsteve.axi.utility.nms
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
        append("fake ")
        red()

        append(player.name) {
          yellow()
        }
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
