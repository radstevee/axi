package net.radsteve.axi.example.game.tnttag.phase

import net.radsteve.axi.example.game.tnttag.TntTagInstance
import net.radsteve.axi.game.phase.GamePhase
import net.radsteve.axi.utility.players

public class FinalPhase(instance: TntTagInstance) : GamePhase<TntTagInstance>(instance) {
  override suspend fun start() {
    players.forEach { player ->
      player.allowFlight = true
      player.isFlying = true
      player.inventory.clear()
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
