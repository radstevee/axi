package net.radsteve.axi.example.game.tnttag.phase

import net.radsteve.axi.example.game.tnttag.TntTagInstance
import net.radsteve.axi.game.phase.GamePhase
import net.radsteve.axi.ui.text.send

public class WaitingPhase(instance: TntTagInstance) : GamePhase<TntTagInstance>(instance) {
  override suspend fun start() {
    send {
      appendLine("Welcome to TNT tag!")
      append("I should probably write a description for this but I cba")
      blue()
    }
  }

  override suspend fun displayTick(tick: Int, displayTick: Int) {
    val countdownTick = countdownTick(5, displayTick) ?: return

    if (countdownTick == 0) {
      send {
        append("The game is starting!")
        green()
      }

      return
    }

    send {
      append("The game is starting in ")
      append(countdownTick) {
        green()
        appendSpace()
      }
      append("seconds") {
        yellow()
      }
      append("!")
      blue()
    }
  }
}
