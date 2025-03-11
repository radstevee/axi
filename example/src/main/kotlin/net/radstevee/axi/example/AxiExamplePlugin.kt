package net.radstevee.axi.example

import net.radstevee.axi.core.coroutines.registerEventListeners
import net.radstevee.axi.core.plugin.AxiPlugin
import net.radstevee.axi.example.resource.ExampleAxiPack
import net.radstevee.axi.ui.AxiUI

public class AxiExamplePlugin : AxiPlugin() {
  override suspend fun enable() {
    ExampleAxiPack.save()

    AxiUI.init(this)
    registerEventListeners(ConnectionListener)
  }
}
