package net.radstevee.axi.game

import net.radstevee.axi.coroutines.registerEventListeners
import net.radstevee.axi.event.HandleableHandler
import net.radstevee.axi.game.instance.GameInstanceController
import net.radstevee.axi.game.instance.GameInstanceTicker
import net.radstevee.axi.mod.AxiModule
import net.radstevee.axi.plugin.AxiPlugin

/** The Axi game module. */
public class AxiGame : AxiModule {
  override suspend fun enable(plugin: AxiPlugin) {
    GameInstanceTicker.startTicking()
    plugin.registerEventListeners(
      HandleableHandler {
        buildSet {
          GameInstanceController.collect().forEach { instance ->
            add(instance)
            add(instance.controller.currentPhase)
          }
        }
      },
    )
  }
}
