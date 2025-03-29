package net.radstevee.axi.game.type

import net.kyori.adventure.key.Key
import net.radstevee.axi.DelegatingRegistry
import net.radstevee.axi.Registry

/** A game type registry, delegating to [AxiGameTypes]. */
public class GameTypeRegistry : DelegatingRegistry<Key, GameType<*>>(AxiGameTypes) {
  /** Delegating game type registry. */
  public object AxiGameTypes : Registry<Key, GameType<*>>(modifiable = true)
}
