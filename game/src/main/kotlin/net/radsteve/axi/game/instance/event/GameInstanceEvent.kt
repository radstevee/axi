package net.radsteve.axi.game.instance.event

import net.radsteve.axi.game.instance.GameInstance
import org.bukkit.event.Event

/** An event associated with a game instance of type [T]. */
public abstract class GameInstanceEvent<T : GameInstance<T>>(
  /** The associated game instance. */
  public open val instance: GameInstance<T>,
) : Event()
