package net.radsteve.axi.game.type

import net.kyori.adventure.key.Key
import net.kyori.adventure.key.Keyed
import net.kyori.adventure.text.Component

/** Metadata about [GameType]s. */
public data class GameTypeMetadata(
  /** The key of this game type. */
  public val key: Key,
  /** The name displayed to players. */
  public val displayName: Component,
  /** The description displayed to players. */
  public val description: Component? = null,
) : Keyed {
  override fun key(): Key {
    return key
  }
}
