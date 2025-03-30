package net.radstevee.axi.game.instance

/** A factory for creating [GameInstance]s. */
public interface GameInstanceFactory<T : GameInstance<T>> {
  /** Creates a game instance of the given [context]. */
  public fun createInstance(context: GameContext<T>): T
}
