package net.radsteve.axi.game.type

import net.kyori.adventure.key.Key
import net.radsteve.axi.DelegatingRegistry
import net.radsteve.axi.Registry
import net.radsteve.axi.game.instance.GameInstance

/** A game type registry, delegating to [AxiGameTypes]. */
public open class GameTypeRegistry : DelegatingRegistry<Key, GameType<*>>(AxiGameTypes) {
  /** Registers the given [gameType]. */
  public fun <T : GameInstance<T>> register(gameType: GameType<T>): GameType<T> {
    register(gameType.metadata.key, gameType)
    return gameType
  }

  /** Delegating game type registry. */
  public object AxiGameTypes : Registry<Key, GameType<*>>(modifiable = true)
}
