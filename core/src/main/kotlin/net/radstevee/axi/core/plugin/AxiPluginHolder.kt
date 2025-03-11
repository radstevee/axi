package net.radstevee.axi.core.plugin

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

/** Holds the main axi plugin. */
public object AxiPluginHolder {
  private var plugin: AxiPlugin? = null

  /** Gets the axi plugin, or throws if it has not been initialized. */
  @Throws(IllegalStateException::class)
  public fun plugin(): AxiPlugin {
    require(plugin != null) { "axi plugin has not initialized!" }
    return plugin!!
  }

  /** Sets [plugin] to this plugin if it is unset, calls [block] and resets [plugin] if [block] threw an exception. */
  internal suspend fun AxiPlugin.gracefully(lifecyclePhase: String, block: suspend CoroutineScope.() -> Unit) {
    if (plugin == null) {
      plugin = this
    }

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
