package net.radsteve.axi.example.game.tnttag.phase

import net.radsteve.axi.example.game.tnttag.TntTagInstance
import net.radsteve.axi.game.phase.GamePhase
import net.radsteve.axi.ui.theme.Themed
import net.radsteve.axi.utility.players

public class WaitingPhase(instance: TntTagInstance) : GamePhase<TntTagInstance>(instance), Themed by instance {
  override suspend fun start() {
    send {
      appendLine("Welcome to TNT tag!")
      append("I should probably write a description for this but I cba")
      blue()
    }

    players.forEach { player ->
      player.inventory.clear()
      player.clearActivePotionEffects()
    }
  }

  override suspend fun displayTick(tick: Int, displayTick: Int) {
    val countdownTick = countdownTick(7, displayTick) ?: return

    if (countdownTick == 0) {
      send("The game is starting!", green)

      return
    }

    send {
      append("The game is starting in ")
      append(countdownTick, green)
      append(" seconds", yellow)
      append("!")
      blue()
    }
  }
}
