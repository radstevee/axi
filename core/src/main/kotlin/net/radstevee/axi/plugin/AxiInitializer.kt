package net.radstevee.axi.plugin

import kotlinx.coroutines.runBlocking
import net.radstevee.axi.command.CommandManager
import net.radstevee.axi.coroutines.registerEventListeners
import net.radstevee.axi.ecs.ECS
import net.radstevee.axi.ecs.component.EntityClickedComponent
import net.radstevee.axi.ecs.internal.ECSConnectionListener
import net.radstevee.axi.ecs.internal.ECSImpl
import net.radstevee.axi.ecs.internal.SystemTicker
import net.radstevee.axi.mod.AxiModuleLoader
import net.radstevee.axi.plugin.event.AxiInitializeEvent
import net.radstevee.axi.world.AxiWorldService
import net.radstevee.axi.world.FileWorldService
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
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
      single(named<FileWorldService>()) { FileWorldService(plugin.dataPath.resolve("axi/worlds") ) }.bind<AxiWorldService>()

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
