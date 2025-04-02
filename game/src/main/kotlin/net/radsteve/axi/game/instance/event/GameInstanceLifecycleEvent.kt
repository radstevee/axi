package net.radsteve.axi.game.instance.event

import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.game.instance.GameLifecycle
import org.bukkit.event.HandlerList

/** Called when a game instance has changed its lifecycle state. */
public class GameInstanceLifecycleEvent<T : GameInstance<T>>(
  /** The old lifecycle state. */
  public val old: GameLifecycle,
  /** The new lifecycle state. */
  public val new: GameLifecycle,

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
