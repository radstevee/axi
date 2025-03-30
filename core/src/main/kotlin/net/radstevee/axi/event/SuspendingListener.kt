package net.radstevee.axi.event

import kotlinx.coroutines.CoroutineScope
import net.radstevee.axi.coroutines.AxiCoroutines
import org.bukkit.event.Listener
import kotlin.coroutines.CoroutineContext

/** A suspending event listener. For convenience. */
public interface SuspendingListener :
  Listener,
  CoroutineScope {
  override val coroutineContext: CoroutineContext
    get() = AxiCoroutines.syncContext
}
