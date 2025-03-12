package net.radstevee.axi.example

import net.radstevee.axi.core.coroutines.registerEventListeners
import net.radstevee.axi.core.plugin.AxiPlugin
import net.radstevee.axi.example.resource.ExampleAxiPack

public class ExampleAxiPlugin : AxiPlugin() {
  override suspend fun enable() {
    ExampleAxiPack.save()

    registerEventListeners(ConnectionListener)
  }
}
