package net.radsteve.axi.coroutines

import com.github.shynixn.mccoroutine.bukkit.asyncDispatcher
import com.github.shynixn.mccoroutine.bukkit.minecraftDispatcher
import com.github.shynixn.mccoroutine.bukkit.registerSuspendingEvents
import com.github.shynixn.mccoroutine.bukkit.scope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.plus
import kotlinx.coroutines.withContext
import net.radsteve.axi.plugin.AxiPlugin
import org.bukkit.event.Listener
import kotlin.coroutines.CoroutineContext

/** The [CoroutineScope] of this plugin. */
public val AxiPlugin.coroutineScope: CoroutineScope get() = CoroutineScope(syncContext)

/** The synchronous dispatcher. */
public val AxiPlugin.syncContext: CoroutineContext get() = minecraftDispatcher + LoggingExceptionHandler

/** The asynchronous dispatcher. */
public val AxiPlugin.asyncContext: CoroutineContext get() = asyncDispatcher + LoggingExceptionHandler

/** Launches a sync task on the main [org.bukkit.scheduler.BukkitScheduler]. */
public fun <R> AxiPlugin.sync(block: suspend CoroutineScope.() -> R): Deferred<R> {
  return coroutineScope.async(syncContext, block = block)
}

/** Launches an asynchronous task on the async [org.bukkit.scheduler.BukkitScheduler]. */
public fun <R> AxiPlugin.async(block: suspend CoroutineScope.() -> R): Deferred<R> {
  return coroutineScope.async(asyncContext, block = block)
}

/** Executes [block] on the [syncContext]. */
public suspend fun <R> AxiPlugin.syncContext(block: suspend CoroutineScope.() -> R): R {
  return withContext(syncContext, block = block)
}

/** Executes [block] on the [asyncContext]. */
public suspend fun <R> AxiPlugin.asyncContext(block: suspend CoroutineScope.() -> R): R {
  return withContext(asyncContext, block = block)
}

/** Registers suspending event listeners. */
public fun AxiPlugin.registerEventListeners(vararg listeners: Listener) {
  listeners.forEach { listener ->
    server.pluginManager.registerSuspendingEvents(listener, this)
  }
}
