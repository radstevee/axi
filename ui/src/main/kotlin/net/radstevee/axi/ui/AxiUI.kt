package net.radstevee.axi.ui

import net.radstevee.axi.coroutines.registerEventListeners
import net.radstevee.axi.mod.AxiModule
import net.radstevee.axi.plugin.AxiPlugin
import net.radstevee.axi.ui.render.RenderererTicker
import net.radstevee.axi.ui.resource.pack.send.SuspendingAxiPackSending

/** Initialises the axi UI module. */
public class AxiUI : AxiModule {
  public override suspend fun enable(plugin: AxiPlugin) {
    plugin.registerEventListeners(RenderererTicker)
    plugin.registerEventListeners(SuspendingAxiPackSending)

    // The negative spaces hook just iterates through characters which adventure isn't a large fan of
    // This also does not fix it so you have to add this to the JVM flags
    System.setProperty("net.kyori.adventure.text.warnWhenLegacyFormattingDetected", "false")
  }
}
