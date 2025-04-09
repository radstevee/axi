package net.radsteve.axi.example.game.tnttag.phase

import net.radsteve.axi.example.game.tnttag.TntTagInstance
import net.radsteve.axi.game.phase.GamePhase
import net.radsteve.axi.ui.theme.Themed
import net.radsteve.axi.utility.players

public class FinalPhase(instance: TntTagInstance) : GamePhase<TntTagInstance>(instance), Themed by instance {
  override suspend fun start() {
    players.forEach { player ->
      player.allowFlight = true
      player.isFlying = true
      player.inventory.clear()
      player.clearActivePotionEffects()
      val stats = with(instance) { player.stats }

      player.send {
        appendLine {
          append("Game Roundup:")
          blue()
          underlined()
        }

        appendLine {
          append("You have been tagged ")
          append(stats.timesTagged) {
            append(" time")
            if (stats.timesTagged > 1 || stats.timesTagged == 0) {
              append("s")
            }
            red()
            bold()
          }
          append(".")
          yellow()
        }

        append {
          append("You have tagged people ")
          append(stats.tags) {
            append(" time")
            if (stats.tags > 1 || stats.tags == 0) {
              append("s")
            }
            red()
            bold()
          }
          append(".")
          green()
        }
      }
    }
  }

  override suspend fun end() {
    players.forEach { player ->
      player.allowFlight = false
      player.isFlying = false
      player.inventory.clear()
    }
  }
}
