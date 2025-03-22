package net.radstevee.axi.ui

import net.radstevee.axi.coroutines.registerEventListeners
import net.radstevee.axi.mod.AxiModule
import net.radstevee.axi.plugin.AxiPlugin
import net.radstevee.axi.ui.render.RenderererTicker
import net.radstevee.axi.ui.resource.pack.send.AxiPackSendingService
import net.radstevee.axi.ui.resource.pack.send.AxiPackSendingServiceImpl
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
