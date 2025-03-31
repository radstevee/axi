package net.radsteve.axi.game.type

import net.kyori.adventure.key.Key
import net.radsteve.axi.DelegatingRegistry
import net.radsteve.axi.Registry

/** A game type registry, delegating to [AxiGameTypes]. */
public class GameTypeRegistry : DelegatingRegistry<Key, GameType<*>>(AxiGameTypes) {
  /** Delegating game type registry. */
  public object AxiGameTypes : Registry<Key, GameType<*>>(modifiable = true)
}
