package net.radstevee.axi.core.plugin

import net.radstevee.axi.core.command.CommandManager
import net.radstevee.axi.core.coroutines.registerEventListeners
import net.radstevee.axi.core.ecs.ECSConnectionListener
import net.radstevee.axi.core.ecs.component.EntityClickedComponent
import net.radstevee.axi.core.plugin.event.AxiInitializeEvent

/** Initialises axi plugins. */
internal object AxiInitializer {
  /** Initialises the given [plugin]. */
  operator fun invoke(plugin: AxiPlugin) {
    plugin.commandManager = CommandManager(plugin)
    plugin.registerEventListeners(ECSConnectionListener)
    plugin.registerEventListeners(EntityClickedComponent.Handler)

    plugin.server.pluginManager.callEvent(AxiInitializeEvent(plugin))
  }
}
