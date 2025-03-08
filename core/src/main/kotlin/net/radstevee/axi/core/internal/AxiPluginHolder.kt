package net.radstevee.axi.core.internal

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import net.radstevee.axi.core.AxiPlugin
import net.radstevee.axi.core.internal.AxiPluginHolder.plugin

/** Holds the main axi plugin. */
public object AxiPluginHolder {
    private var plugin: AxiPlugin? = null

    /** Gets the axi plugin, or throws if it has not been initialized. */
    @Throws(IllegalStateException::class)
    public fun plugin(): AxiPlugin {
        require(plugin != null) { "axi plugin has not initialized!" }
        return plugin!!
    }

    /** Sets [plugin] to this plugin if it is unset, gracefully calls [block] and resets [plugin] if [block] threw an exception. */
    internal suspend fun AxiPlugin.gracefully(block: suspend CoroutineScope.() -> Unit) {
        if (plugin == null) {
            plugin = this
        }

        coroutineScope {
            runCatching {
                block()
            }.onFailure { exception ->
                slF4JLogger.error("Failed enabling axi plugin", exception)
                plugin = null
            }
        }
    }
}
