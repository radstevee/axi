package net.radstevee.axi.ui

import net.radstevee.axi.core.coroutines.registerEventListeners
import net.radstevee.axi.core.mod.AxiModule
import net.radstevee.axi.core.plugin.AxiPlugin
import net.radstevee.axi.ui.render.RenderererTicker

/** Initialises the axi UI module. */
public class AxiUI : AxiModule {
  public override suspend fun enable(plugin: AxiPlugin) {
    plugin.registerEventListeners(RenderererTicker)

    // The negative spaces hook just iterates through characters which adventure isn't a large fan of
    // This also does not fix it so you have to add this to the JVM flags
    System.setProperty("net.kyori.adventure.text.warnWhenLegacyFormattingDetected", "false")
  }
}
