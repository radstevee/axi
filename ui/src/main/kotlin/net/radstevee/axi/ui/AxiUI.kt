package net.radstevee.axi.ui

import net.radstevee.axi.core.coroutines.registerEventListeners
import net.radstevee.axi.core.mod.AxiModule
import net.radstevee.axi.core.plugin.AxiPlugin
import net.radstevee.axi.ui.render.layer.RenderLayerTicker

/** Initialises the axi UI module. */
public class AxiUI : AxiModule {
  public override suspend fun enable(plugin: AxiPlugin) {
    plugin.registerEventListeners(RenderLayerTicker)
  }
}
