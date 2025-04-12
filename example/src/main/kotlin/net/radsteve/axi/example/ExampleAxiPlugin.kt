package net.radsteve.axi.example

import net.radsteve.axi.coroutines.registerEventListeners
import net.radsteve.axi.example.game.GameTypes
import net.radsteve.axi.example.resource.ExamplePack
import net.radsteve.axi.plugin.AxiPlugin
import net.radsteve.axi.ui.AxiUI

public class ExampleAxiPlugin : AxiPlugin() {
  override suspend fun enable() {
    ExamplePack.save()

    registerEventListeners(ConnectionListener)

    GameTypes

    ExampleSystem.startTicking()

    AxiUI.theme = Decayce
  }
}
