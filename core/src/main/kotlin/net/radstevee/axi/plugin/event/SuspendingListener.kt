package net.radstevee.axi.plugin.event

import kotlinx.coroutines.CoroutineScope
import net.radstevee.axi.coroutines.AxiCoroutines.syncContext
import org.bukkit.event.Listener
import kotlin.coroutines.CoroutineContext

/** A suspending event listener. For convenience. */
public interface SuspendingListener :
  Listener,
  CoroutineScope {
  override val coroutineContext: CoroutineContext
    get() = syncContext
}
