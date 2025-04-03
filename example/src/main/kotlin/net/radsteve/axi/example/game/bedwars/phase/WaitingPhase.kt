package net.radsteve.axi.example.game.bedwars.phase

import net.radsteve.axi.example.game.bedwars.BedWarsInstance
import net.radsteve.axi.game.phase.GamePhase
import net.radsteve.axi.ui.text.send

public class WaitingPhase(instance: BedWarsInstance) : GamePhase<BedWarsInstance>(instance) {
  override suspend fun start() {
    instance.send {
      append("omg welcome yall")
    }
  }
}
