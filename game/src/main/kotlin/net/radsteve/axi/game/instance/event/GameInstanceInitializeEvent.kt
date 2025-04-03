package net.radsteve.axi.game.instance.event

import net.radsteve.axi.game.instance.GameInstance
import org.bukkit.event.HandlerList

/** Always called when a game instance has initialised. */
public class GameInstanceInitializeEvent<T : GameInstance<T>>(
  instance: GameInstance<T>,
) : GameInstanceEvent<T>(instance) {
  override fun getHandlers(): HandlerList {
    return HANDLER_LIST
  }

  public companion object {
    @JvmStatic
    private val HANDLER_LIST: HandlerList = HandlerList()

    @JvmStatic
    public fun getHandlerList(): HandlerList = HANDLER_LIST
  }
}
