package net.radsteve.axi.game

import net.radsteve.axi.coroutines.registerEventListeners
import net.radsteve.axi.event.HandleableHandler
import net.radsteve.axi.game.instance.GameInstanceController
import net.radsteve.axi.game.instance.GameInstanceTicker
import net.radsteve.axi.mod.AxiModule
import net.radsteve.axi.plugin.AxiPlugin

/** The Axi game module. */
public class AxiGame : AxiModule {
  override suspend fun enable(plugin: AxiPlugin) {
    GameInstanceTicker.startTicking()
    plugin.registerEventListeners(GameInstanceController)
    plugin.registerEventListeners(HandleableHandler { GameInstanceController.cachedHandleables })
  }
}
