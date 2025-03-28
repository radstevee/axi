package net.radstevee.axi.game.type

import net.kyori.adventure.key.Keyed
import net.radstevee.axi.game.instance.GameInstance
import net.radstevee.axi.game.instance.GameInstanceFactory

/** A type of game instances. */
public class GameType<T : GameInstance<T>>(
  /** The factory to this game type. */
  public val factory: GameInstanceFactory<T>,
  /** The metadata about this game type. */
  public val metadata: GameTypeMetadata,
) : Keyed by metadata
