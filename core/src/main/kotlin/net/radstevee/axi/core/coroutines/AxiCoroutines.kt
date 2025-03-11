package net.radstevee.axi.core.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import net.radstevee.axi.core.plugin.AxiPlugin
import net.radstevee.axi.core.plugin.AxiPluginHolder
import kotlin.coroutines.CoroutineContext

/** The [CoroutineScope] of the main [AxiPlugin]. */
public val coroutineScope: CoroutineScope get() = AxiPluginHolder.plugin().coroutineScope

/** The synchronous dispatcher. */
public val syncContext: CoroutineContext get() = AxiPluginHolder.plugin().syncContext

/** The asynchronous dispatcher. */
public val asyncContext: CoroutineContext get() = AxiPluginHolder.plugin().asyncContext

/** Launches a sync task on the main [org.bukkit.scheduler.BukkitScheduler]. */
public fun sync(block: suspend CoroutineScope.() -> Unit): Job = AxiPluginHolder.plugin().sync(block)

/** Launches an asynchronous task on the async [org.bukkit.scheduler.BukkitScheduler]. */
public fun async(block: suspend CoroutineScope.() -> Unit): Job = AxiPluginHolder.plugin().async(block)

/** Executes [block] on the [syncContext]. */
public suspend fun <R> syncContext(block: suspend CoroutineScope.() -> R): R = AxiPluginHolder.plugin().syncContext(block)

/** Executes [block] on the [asyncContext]. */
public suspend fun <R> asyncContext(block: suspend CoroutineScope.() -> R): R = AxiPluginHolder.plugin().asyncContext(block)
