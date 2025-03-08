package net.radstevee.axi.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import net.radstevee.axi.core.AxiPlugin
import net.radstevee.axi.core.internal.AxiPluginHolder
import kotlin.coroutines.CoroutineContext

/** The [CoroutineScope] of the main [AxiPlugin]. */
public val coroutineScope: CoroutineScope get() = AxiPluginHolder.plugin().coroutineScope
/** The synchronous dispatcher. */
public val syncContext: CoroutineContext get() = AxiPluginHolder.plugin().syncContext
/** The asynchronous dispatcher. */
public val asyncContext: CoroutineContext get() = AxiPluginHolder.plugin().asyncContext

/** Launches a sync task on the main [org.bukkit.scheduler.BukkitScheduler]. */
public fun sync(block: suspend CoroutineScope.() -> Unit): Job {
    return AxiPluginHolder.plugin().sync(block)
}

/** Launches an asynchronous task on the async [org.bukkit.scheduler.BukkitScheduler]. */
public fun async(block: suspend CoroutineScope.() -> Unit): Job {
    return AxiPluginHolder.plugin().async(block)
}

/** Executes [block] on the [syncContext]. */
public suspend fun <R> syncContext(block: suspend CoroutineScope.() -> R): R {
    return AxiPluginHolder.plugin().syncContext(block)
}

/** Executes [block] on the [asyncContext]. */
public suspend fun <R> asyncContext(block: suspend CoroutineScope.() -> R): R {
    return AxiPluginHolder.plugin().asyncContext(block)
}
