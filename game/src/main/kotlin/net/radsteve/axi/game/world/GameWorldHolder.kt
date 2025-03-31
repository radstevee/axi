package net.radsteve.axi.game.world

import net.radsteve.axi.game.instance.GameInstance

/** Represents something that can hold a [GameWorld]. */
public interface GameWorldHolder<T : GameInstance<T>> {
  /** The held world. */
  public val world: GameWorld<T>
}
