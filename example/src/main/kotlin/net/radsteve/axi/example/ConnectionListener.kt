package net.radsteve.axi.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.kyori.adventure.text.format.TextColor.color
import net.radsteve.axi.displayname.displayNameTag
import net.radsteve.axi.ecs.onClickEntity
import net.radsteve.axi.event.SuspendingListener
import net.radsteve.axi.example.resource.ExamplePack
import net.radsteve.axi.example.resource.OtherLayer
import net.radsteve.axi.example.resource.testRenderLayer
import net.radsteve.axi.npc.NPC
import net.radsteve.axi.npc.SkinData
import net.radsteve.axi.tick.TickDuration.ticks
import net.radsteve.axi.ui.render.layer.addRenderable
import net.radsteve.axi.ui.resource.pack.send.sendAxiPack
import net.radsteve.axi.ui.text.TextBuilder
import net.radsteve.axi.ui.text.buildText
import net.radsteve.axi.ui.text.send
import net.radsteve.axi.utility.lerpColor
import net.radsteve.axi.utility.nms
import org.bukkit.Bukkit
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent
import kotlin.math.abs
import kotlin.math.sin

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

    launch {
      val color = color(0xFF0000)
      val targetColor = color(0x00FFF0)

      while (player.isOnline) {
        val currentTime = Bukkit.getCurrentTick() / 20f
        val lerpedAmount = abs(sin(currentTime))
        val lerpedColor = lerpColor(lerpedAmount, color, targetColor)

        player.displayNameTag = buildText {
          append(player.name)
          color(lerpedColor)
        }
        delay(1.ticks)
      }
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
    NPC(
      buildText {
        append("fake ")
        red()

        append(player.name) {
          yellow()
        }
      },
      player.location.clone().add(0.0, 2.0, 0.0),
      SkinData(
        playerSkin.value,
        playerSkin.signature!!
      ),
    ).show(player)

    player.addRenderable(testRenderLayer(Bukkit.getCurrentTick()))
    player.addRenderable(OtherLayer)
  }
}
