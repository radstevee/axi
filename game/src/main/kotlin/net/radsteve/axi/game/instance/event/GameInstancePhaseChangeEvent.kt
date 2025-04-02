package net.radsteve.axi.game.instance.event

import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.game.phase.GamePhase
import org.bukkit.event.HandlerList

/**
 * Called when a game instance's current phase changes.
 *
 * This **does not** fire on initialisation.
 */
public class GameInstancePhaseChangeEvent<T : GameInstance<T>>(
  /** The old, previous phase. */
  public val old: GamePhase<T>,
  /** The new phase. */
  public val new: GamePhase<T>,

  instance: GameInstance<T>,
) : GameInstanceEvent<T>(instance) {
  override fun getHandlers(): HandlerList {
    return HANDLER_LIST
  }

  public companion object {
    @JvmStatic
    private val HANDLER_LIST: HandlerList = HandlerList()

    @JvmStatic
    internal fun getHandlerList(): HandlerList = HANDLER_LIST
  }
}
