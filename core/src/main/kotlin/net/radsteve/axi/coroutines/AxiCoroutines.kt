package net.radsteve.axi.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.radsteve.axi.coroutines.AxiCoroutines.asyncContext
import net.radsteve.axi.coroutines.AxiCoroutines.syncContext
import net.radsteve.axi.plugin.AxiPlugin
import net.radsteve.axi.utility.PluginAware
import kotlin.coroutines.CoroutineContext

/** Coroutine extensions for the main axi plugin. */
public object AxiCoroutines : PluginAware {
  /** The [CoroutineScope] of the main [AxiPlugin]. */
  public val coroutineScope: CoroutineScope get() = plugin.coroutineScope

  /** The synchronous dispatcher. */
  public val syncContext: CoroutineContext get() = plugin.syncContext

  /** The asynchronous dispatcher. */
  public val asyncContext: CoroutineContext get() = plugin.asyncContext

  /** The IO dispatcher. */
  public val ioContext: CoroutineContext = Dispatchers.IO + LoggingExceptionHandler

  /** Launches a sync task on the main [org.bukkit.scheduler.BukkitScheduler]. */
  public fun <R> sync(block: suspend CoroutineScope.() -> R): Deferred<R> {
    return plugin.sync(block)
  }

  /** Launches an asynchronous task on the async [org.bukkit.scheduler.BukkitScheduler]. */
  public fun <R> async(block: suspend CoroutineScope.() -> R): Deferred<R> {
    return plugin.async(block)
  }

  /** Executes [block] on the [syncContext]. */
  public suspend fun <R> syncContext(block: suspend CoroutineScope.() -> R): R {
    return plugin.syncContext(block)
  }

  /** Executes [block] on the [asyncContext]. */
  public suspend fun <R> asyncContext(block: suspend CoroutineScope.() -> R): R {
    return plugin.asyncContext(block)
  }

  /** Executes [block] on the I/O dispatcher. */
  public suspend fun <R> ioContext(block: suspend CoroutineScope.() -> R): R {
    return withContext(ioContext, block = block)
  }
}
