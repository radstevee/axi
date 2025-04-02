package net.radsteve.axi.event

import com.github.shynixn.mccoroutine.bukkit.callSuspendingEvent
import kotlinx.coroutines.joinAll
import net.radsteve.axi.plugin.AxiPluginHolder
import org.bukkit.Bukkit
import org.bukkit.event.Event

/** Calls the given [event]. */
public suspend fun callEvent(event: Event) {
  Bukkit.getPluginManager().callSuspendingEvent(event, AxiPluginHolder.plugin()).joinAll()
}
