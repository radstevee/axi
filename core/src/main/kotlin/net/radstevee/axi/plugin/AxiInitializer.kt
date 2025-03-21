package net.radstevee.axi.plugin

import kotlinx.coroutines.runBlocking
import net.radstevee.axi.command.CommandManager
import net.radstevee.axi.coroutines.registerEventListeners
import net.radstevee.axi.ecs.ECSConnectionListener
import net.radstevee.axi.ecs.ECSDataTracker
import net.radstevee.axi.ecs.component.EntityClickedComponent
import net.radstevee.axi.ecs.internal.BasicECSDataTracker
import net.radstevee.axi.plugin.event.AxiInitializeEvent
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.logger.slf4jLogger

/** Initialises axi plugins. */
internal object AxiInitializer {
  /** Initialises the given [plugin]. */
  operator fun invoke(plugin: AxiPlugin) {
    plugin.module = module {
      single<AxiPlugin> { plugin }
      singleOf(::BasicECSDataTracker) { bind<ECSDataTracker>() }

      with(plugin) {
        // We're still in the initializer so this is fine.
        runBlocking {
          module()
        }
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

    plugin.server.pluginManager.callEvent(AxiInitializeEvent(plugin))
  }
}
