package net.radsteve.axi.example.game.tnttag.phase

import net.radsteve.axi.example.game.tnttag.TntTagInstance
import net.radsteve.axi.game.phase.GamePhase
import net.radsteve.axi.ui.text.send

public class WaitingPhase(instance: TntTagInstance) : GamePhase<TntTagInstance>(instance) {
  override suspend fun start() {
    instance.send {
      append("omg welcome yall")
    }
  }
}
