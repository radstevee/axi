package net.radstevee.axi.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.radstevee.axi.coroutines.AxiCoroutines.asyncContext
import net.radstevee.axi.coroutines.AxiCoroutines.syncContext
import net.radstevee.axi.plugin.AxiPlugin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.coroutines.CoroutineContext

/** Coroutine extensions for the main axi plugin. */
public object AxiCoroutines : KoinComponent {
  private val plugin: AxiPlugin by inject()

  /** The [CoroutineScope] of the main [AxiPlugin]. */
  public val coroutineScope: CoroutineScope get() = plugin.coroutineScope

  /** The synchronous dispatcher. */
  public val syncContext: CoroutineContext get() = plugin.syncContext

  /** The asynchronous dispatcher. */
  public val asyncContext: CoroutineContext get() = plugin.asyncContext

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
    return withContext(Dispatchers.IO + LoggingExceptionHandler, block = block)
  }
}
