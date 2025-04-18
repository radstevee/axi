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
        appendLine("Game Roundup:", blue, underlined)

        fun stat(text: String, value: Int) {
          appendLine {
            append(text)
            append(value) {
              append(" time")
              if (value > 1 || value == 0) {
                append("s")
              }
              red()
              bold()
            }

            append(".")
            yellow()
          }
        }

        stat("You have been tagged ", stats.timesTagged)
        stat("You have tagged somebody ", stats.tags)
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
