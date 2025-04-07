@file:OptIn(ExperimentalTime::class)

package net.radsteve.axi.game.instance

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.key.Key
import net.kyori.adventure.key.Key.key
import net.kyori.adventure.key.Keyed
import net.radsteve.axi.game.type.GameType
import net.radsteve.axi.tick.TickDuration.ticks
import net.radsteve.axi.utility.Identified
import org.bukkit.Bukkit
import java.util.UUID
import kotlin.time.Clock.System.now
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/** The context of a game instance. */
public data class GameContext<T : GameInstance<T>>(
  /** The type of the game instance. */
  public val type: GameType<T>,

  /** The instance's audience. */
  public var audience: Audience,

  /** The list of players in this instance. */
  public val members: MutableList<UUID>,
) : Identified,
  Keyed {
  /** When this instance started. */
  public val start: Instant = now()

  /** The tick this instance started. */
  public val startTick: Int = Bukkit.getCurrentTick()

  /** The duration between now and the [start]. */
  public val duration: Duration get() = start - now()

  override val uuid: UUID = UUID.randomUUID()

  /** The id of this game context. */
  public override val id: String = "${type.key().value()}-$uuid"

  override fun key(): Key {
    return key(type.key().namespace(), id)
  }
}
