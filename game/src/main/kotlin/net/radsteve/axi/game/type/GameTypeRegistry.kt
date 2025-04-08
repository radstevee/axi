package net.radsteve.axi.game.type

import net.kyori.adventure.key.Key
import net.radsteve.axi.DelegatingRegistry
import net.radsteve.axi.Registry
import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.game.instance.GameInstanceFactory

/** A game type registry, delegating to [AxiGameTypes]. */
public open class GameTypeRegistry : DelegatingRegistry<Key, GameType<*>>(AxiGameTypes) {
  /** Registers the given [gameType]. */
  public fun <T : GameInstance<T>> register(gameType: GameType<T>): GameType<T> {
    register(gameType.metadata.key, gameType)
    return gameType
  }

  /** Registers a game type from its [factory] and [meta]. */
  public fun <T : GameInstance<T>> register(factory: GameInstanceFactory<T>, meta: GameTypeMetadata): GameType<T> {
    return register(GameType(factory, meta))
  }

  /** Delegating game type registry. */
  public object AxiGameTypes : Registry<Key, GameType<*>>(modifiable = true)
}
