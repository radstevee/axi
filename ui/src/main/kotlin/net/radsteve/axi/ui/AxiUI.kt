package net.radsteve.axi.ui

import net.radsteve.axi.coroutines.registerEventListeners
import net.radsteve.axi.mod.AxiModule
import net.radsteve.axi.plugin.AxiPlugin
import net.radsteve.axi.ui.render.RenderererTicker
import net.radsteve.axi.ui.resource.pack.send.AxiPackSendingService
import net.radsteve.axi.ui.resource.pack.send.AxiPackSendingServiceImpl
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf

/** Initialises the axi UI module. */
public class AxiUI : AxiModule {
  public override suspend fun enable(plugin: AxiPlugin) {
    plugin.registerEventListeners(RenderererTicker)
    plugin.registerEventListeners(plugin.get<AxiPackSendingServiceImpl>())

    // The negative spaces hook just iterates through characters which adventure isn't a large fan of
    // This also does not fix it so you have to add this to the JVM flags
    System.setProperty("net.kyori.adventure.text.warnWhenLegacyFormattingDetected", "false")
  }

  override suspend fun Module.module(plugin: AxiPlugin) {
    singleOf(::AxiPackSendingServiceImpl) { bind<AxiPackSendingService>() }
  }
}
