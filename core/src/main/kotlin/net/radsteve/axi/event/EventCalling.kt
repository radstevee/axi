package net.radsteve.axi.event

import com.github.shynixn.mccoroutine.bukkit.callSuspendingEvent
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.future.asDeferred
import net.radsteve.axi.plugin.AxiPluginHolder
import org.bukkit.Bukkit
import org.bukkit.event.Cancellable
import org.bukkit.event.Event

/** Calls the given [event]. */
public suspend fun callEvent(event: Event) {
  // Not doing joinAll here because awaitAll launches
  // them concurrently
  Bukkit.getPluginManager()
    .callSuspendingEvent(event, AxiPluginHolder.plugin())
    .map { job -> job.asCompletableFuture().asDeferred() }
    .awaitAll()
}

/** Calls a given cancellable [event] and returns whether it is cancelled. */
public suspend fun <T> callCancellable(event: T): Boolean where T : Event, T : Cancellable {
  callEvent(event)
  return event.isCancelled
}
