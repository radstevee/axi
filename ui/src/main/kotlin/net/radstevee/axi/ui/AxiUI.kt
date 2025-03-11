package net.radstevee.axi.ui

import net.radstevee.axi.core.coroutines.registerEventListeners
import net.radstevee.axi.core.plugin.AxiPlugin
import net.radstevee.axi.ui.render.layer.RenderLayerTicker

/** Initialises the axi UI module. */
public object AxiUI {
  /** Initialises axi UI for the given [plugin]. */
  public fun init(plugin: AxiPlugin) {
    plugin.registerEventListeners(RenderLayerTicker)
  }
}
