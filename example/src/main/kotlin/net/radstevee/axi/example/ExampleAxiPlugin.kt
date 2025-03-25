package net.radstevee.axi.example

import net.radstevee.axi.coroutines.registerEventListeners
import net.radstevee.axi.example.resource.Colors
import net.radstevee.axi.example.resource.ExamplePack
import net.radstevee.axi.plugin.AxiPlugin

class ExampleAxiPlugin : AxiPlugin() {
  override suspend fun enable() {
    ExamplePack.save()

    registerEventListeners(ConnectionListener)
    Colors

    ExampleSystem.start()
  }
}
