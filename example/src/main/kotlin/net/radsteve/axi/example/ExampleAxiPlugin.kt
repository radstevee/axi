package net.radsteve.axi.example

import net.radsteve.axi.coroutines.registerEventListeners
import net.radsteve.axi.example.resource.Colors
import net.radsteve.axi.example.resource.ExamplePack
import net.radsteve.axi.plugin.AxiPlugin

public class ExampleAxiPlugin : AxiPlugin() {
  override suspend fun enable() {
    ExamplePack.save()

    registerEventListeners(ConnectionListener)
    Colors

    ExampleSystem.startTicking()
  }
}
