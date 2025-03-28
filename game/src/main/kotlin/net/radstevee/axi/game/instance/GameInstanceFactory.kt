package net.radstevee.axi.game.instance

/** A factory for creating [GameInstance]s. */
public interface GameInstanceFactory<T : GameInstance<T>> {
  /** Creates a game instance of the given [ctx]. */
  public fun createInstance(ctx: GameContext): GameInstance<T>
}
