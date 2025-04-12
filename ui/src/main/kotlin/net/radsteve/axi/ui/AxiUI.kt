package net.radsteve.axi.ui

import net.radsteve.axi.coroutines.registerEventListeners
import net.radsteve.axi.mod.AxiModule
import net.radsteve.axi.plugin.AxiPlugin
import net.radsteve.axi.ui.render.RenderererTicker
import net.radsteve.axi.ui.resource.pack.send.AxiPackSendingService
import net.radsteve.axi.ui.resource.pack.send.AxiPackSendingServiceImpl
import net.radsteve.axi.ui.theme.Theme
import net.radsteve.axi.ui.theme.Themed
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

/** Initialises the axi UI module. */
public class AxiUI :
  AxiModule,
  Themed {
  public override suspend fun enable(plugin: AxiPlugin) {
    plugin.registerEventListeners(RenderererTicker)
    plugin.registerEventListeners(plugin.get<AxiPackSendingServiceImpl>())

    // The negative spaces hook just iterates through characters which adventure isn't a large fan of
    // This also does not fix it so you have to add this to the JVM flags
    System.setProperty("net.kyori.adventure.text.warnWhenLegacyFormattingDetected", "false")
  }

  override suspend fun Module.module(plugin: AxiPlugin) {
    singleOf(::AxiPackSendingServiceImpl) bind AxiPackSendingService::class
  }

  override var theme: Theme = Theme.Default

  public companion object : KoinComponent, Themed {
    private val ui: AxiUI by inject()

    override var theme: Theme
      get() = ui.theme
      set(value) {
        ui.theme = value
      }
  }
}
