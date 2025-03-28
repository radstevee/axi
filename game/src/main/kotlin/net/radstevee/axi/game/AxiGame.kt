package net.radstevee.axi.game

import net.radstevee.axi.game.instance.GameInstanceTicker
import net.radstevee.axi.mod.AxiModule
import net.radstevee.axi.plugin.AxiPlugin

/** The Axi game module. */
public class AxiGame : AxiModule {
  override suspend fun enable(plugin: AxiPlugin) {
    GameInstanceTicker.startTicking()
  }
}
