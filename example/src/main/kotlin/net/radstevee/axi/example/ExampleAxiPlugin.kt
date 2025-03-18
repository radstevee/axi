package net.radstevee.axi.example

import net.radstevee.axi.core.coroutines.registerEventListeners
import net.radstevee.axi.core.plugin.AxiPlugin
import net.radstevee.axi.example.resource.Colors
import net.radstevee.axi.example.resource.ExamplePack

public class ExampleAxiPlugin : AxiPlugin() {
  override suspend fun enable() {
    ExamplePack.save()

    registerEventListeners(ConnectionListener)
    Colors
  }
}
