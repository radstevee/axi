package net.radstevee.axi.core.internal

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import net.radstevee.axi.core.AxiPlugin

public object AxiPluginHolder {
    private var plugin: AxiPlugin? = null

    public fun plugin(): AxiPlugin {
        require(plugin != null) { "axi plugin has not initialized!" }
        return plugin!!
    }

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
