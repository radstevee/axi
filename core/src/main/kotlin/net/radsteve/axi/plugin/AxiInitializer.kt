package net.radsteve.axi.plugin

import kotlinx.coroutines.runBlocking
import net.radsteve.axi.command.CommandManager
import net.radsteve.axi.coroutines.registerEventListeners
import net.radsteve.axi.ecs.ECS
import net.radsteve.axi.ecs.component.EntityClickedComponent
import net.radsteve.axi.ecs.internal.ECSConnectionListener
import net.radsteve.axi.ecs.internal.ECSImpl
import net.radsteve.axi.ecs.internal.SystemTicker
import net.radsteve.axi.mod.AxiModuleLoader
import net.radsteve.axi.plugin.event.AxiInitializeEvent
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.logger.slf4jLogger

/** Initialises axi plugins. */
internal object AxiInitializer {
  /** Initialises the given [plugin]. */
  operator fun invoke(plugin: AxiPlugin) {
    plugin.module = module {
      single<AxiPlugin> { plugin }
      single { ECSImpl() }.bind<ECS>()

      runBlocking {
        with(plugin) { module() }
        with(AxiModuleLoader) { module(plugin) }
      }
    }

    startKoin {
      modules(plugin.module)
      slf4jLogger()
      createEagerInstances()
    }

    plugin.commandManager = CommandManager(plugin)
    plugin.registerEventListeners(ECSConnectionListener)
    plugin.registerEventListeners(EntityClickedComponent.Handler)
    plugin.registerEventListeners(SystemTicker)

    plugin.server.pluginManager.callEvent(AxiInitializeEvent(plugin, AxiModuleLoader.collectServices(plugin)))
  }
}
