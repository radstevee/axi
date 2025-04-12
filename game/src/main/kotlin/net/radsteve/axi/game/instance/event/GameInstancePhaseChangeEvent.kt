package net.radsteve.axi.game.instance.event

import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.game.phase.GamePhase
import org.bukkit.event.Cancellable
import org.bukkit.event.HandlerList

/** Called when a game instance's current phase changes.
 *
 * This **does not** fire on initialisation.
 *
 * This is called before the new phase starts ticking,
 * so if you are doing any logic on the phase itself,
 * you may have to wait a tick, depending on the
 * initialisation and cleanup logic of the phases.*/
public class GameInstancePhaseChangeEvent<T : GameInstance<T>>(
  /** The old, previous phase. */
  public val old: GamePhase<T>,
  /** The new phase. */
  public val new: GamePhase<T>,

  instance: GameInstance<T>,
) : GameInstanceEvent<T>(instance),
  Cancellable {
  private var cancelled: Boolean = false

  override fun getHandlers(): HandlerList {
    return HANDLER_LIST
  }

  override fun setCancelled(cancel: Boolean) {
    cancelled = cancel
  }

  override fun isCancelled(): Boolean {
    return cancelled
  }

  public companion object {
    @JvmStatic
    private val HANDLER_LIST: HandlerList = HandlerList()

    @JvmStatic
    public fun getHandlerList(): HandlerList = HANDLER_LIST
  }
}
