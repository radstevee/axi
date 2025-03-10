package net.radstevee.axi.core.command

import net.radstevee.axi.core.coroutines.registerEventListeners
import net.radstevee.axi.core.ecs.ECSConnectionListener
import net.radstevee.axi.core.ecs.component.EntityClickedComponent
import net.radstevee.axi.core.plugin.AxiPlugin

/** Initialises axi plugins. */
internal object AxiInitializer {
    /** Initialises the given [plugin]. */
    operator fun invoke(plugin: AxiPlugin) {
        plugin.commandManager = CommandManager(plugin)
        plugin.registerEventListeners(ECSConnectionListener)
        plugin.registerEventListeners(EntityClickedComponent)
    }
}
