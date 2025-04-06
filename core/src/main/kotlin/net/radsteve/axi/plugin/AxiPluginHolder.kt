package net.radsteve.axi.plugin

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

/** Holds the main axi plugin. */
public object AxiPluginHolder {
  private var plugin: AxiPlugin? = null

  /** Gets the axi plugin, or throws if it has not been initialized. */
  public fun plugin(): AxiPlugin {
    return requireNotNull(plugin) { "axi plugin has not initialized" }
  }

  /** Sets [plugin] to this plugin if it is unset, calls [block] and resets [plugin] if [block] threw an exception. */
  internal fun AxiPlugin.gracefully(lifecyclePhase: String, block: suspend CoroutineScope.() -> Unit) {
    if (plugin == null) {
      plugin = this
    }

    runBlocking {
      coroutineScope {
        runCatching {
          block()
        }.onFailure { exception ->
          slF4JLogger.error("Failed to $lifecyclePhase axi plugin", exception)
          plugin = null
        }
      }
    }
  }
}
