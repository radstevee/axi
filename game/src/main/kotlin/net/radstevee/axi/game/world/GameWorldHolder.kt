package net.radstevee.axi.game.world

import net.radstevee.axi.game.instance.GameInstance

/** Represents something that can hold a [GameWorld]. */
public interface GameWorldHolder<T : GameInstance<T>> {
  /** The held world. */
  public val world: GameWorld<T>
}
