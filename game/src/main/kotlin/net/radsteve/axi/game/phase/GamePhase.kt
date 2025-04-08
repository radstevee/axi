@file:OptIn(ExperimentalTime::class)

package net.radsteve.axi.game.phase

import net.kyori.adventure.audience.ForwardingAudience
import net.radsteve.axi.event.Handleable
import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.game.world.GameWorld
import net.radsteve.axi.game.world.GameWorldProvider
import net.radsteve.axi.tick.TickDuration.inWholeTicks
import org.bukkit.entity.Player
import kotlin.coroutines.CoroutineContext
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

/** A phase of a game. This phase can have a specific duration or go on indefinitely. */
public open class GamePhase<T : GameInstance<T>>(
  /** The current game instance. */
  instance: GameInstance<T>,
) : Handleable,
  GameWorldProvider,
  ForwardingAudience by instance {
  /** The current game instance. */
  @Suppress("UNCHECKED_CAST")
  public val instance: T = instance as T

  /** The current tick of this phase. Starts at [durationTicks] and decrements. */
  public open var tick: Int = -1
    internal set

  /** The duration of this phase. */
  public open var duration: Duration? = null

  /** The duration of this phase in seconds. */
  public val durationSeconds: Int? get() = duration?.inWholeSeconds?.toInt()

  /** The duration of this phase in ticks. */
  public val durationTicks: Int? get() = duration?.inWholeTicks?.toInt()

  /** The tick this instance was initialised in. */
  public var tickInitialized: Int by Delegates.notNull()
    internal set

  override val coroutineContext: CoroutineContext by lazy(instance::coroutineContext)

  /** Called at the end of this phase. */
  public open suspend fun end() {}

  /** Whether this phase is currently ending and the schedule should be resumed. */
  public open suspend fun ending(): Boolean {
    return false
  }

  /** Called at the start of this phase. */
  public open suspend fun start() {}

  /** Sets up displays for the given [player]. */
  public open suspend fun displaySetup(player: Player) {}

  // By default, we return the instance's current world.
  override suspend fun gameWorld(instance: GameInstance<*>): GameWorld {
    return instance.initialWorld
  }

  /** Ticks this instance at the given [tick]. */
  public open suspend fun tick(tick: Int) {}

  /** Ticks the displays of this instance for the given [displayTick]. Runs every second, **after tick()**. */
  public open suspend fun displayTick(tick: Int, displayTick: Int) {}

  /**
   * Utility to get the current countdown tick from the given [countdownStart] and [displayTick].
   *
   * Returns null if the given [countdownStart] is higher than the given [displayTick].
   */
  public fun countdownTick(countdownStart: Int, displayTick: Int): Int? {
    if (countdownStart > displayTick) {
      return null
    }

    val tick = (durationSeconds ?: error("phase has no duration")) - displayTick
    return if (tick >= 0) {
      tick
    } else {
      null
    }
  }
}
