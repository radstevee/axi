@file:OptIn(ExperimentalTime::class)

package net.radstevee.axi.game.instance

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.key.Key
import net.kyori.adventure.key.Key.key
import net.kyori.adventure.key.Keyed
import net.radstevee.axi.game.type.GameType
import net.radstevee.axi.game.utility.IdentificationAware
import net.radstevee.axi.tick.TickDuration.ticks
import java.util.UUID
import kotlin.time.Clock.System.now
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/** The context of a game instance. */
public data class GameContext(
  /** The instance UUID. */
  public override val uuid: UUID,

  /** The type of the game instance. */
  public val type: GameType<*>,

  /** The instance's audience. */
  public var audience: Audience,

  /** The list of players in this instance. */
  public val members: MutableList<UUID>,
) : IdentificationAware,
  Keyed {
  /** When this instance started. */
  public val start: Instant = now()

  /** The tick this instance started. */
  public val startTick: Int = start.ticks.toInt()

  /** The duration between now and the [start]. */
  public val duration: Duration get() = start - now()

  /** The id of this game context. */
  public override val id: String = "${type.metadata.id}-$uuid"

  override fun key(): Key {
    return key(type.key().namespace(), id)
  }
}
