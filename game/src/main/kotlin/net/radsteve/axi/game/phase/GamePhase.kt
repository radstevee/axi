package net.radsteve.axi.game.phase

import net.radsteve.axi.event.Handleable
import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.game.world.GameWorld
import net.radsteve.axi.game.world.GameWorldProvider
import net.radsteve.axi.tick.DisplayTickable
import net.radsteve.axi.tick.TickDuration.inWholeTicks
import net.radsteve.axi.tick.Tickable
import org.bukkit.entity.Player
import kotlin.coroutines.CoroutineContext
import kotlin.properties.Delegates
import kotlin.time.Duration

/** A phase of a game. This phase can have a specific duration or go on indefinitely. */
public open class GamePhase<T : GameInstance<T>>(
  /** The current game instance. */
  instance: GameInstance<T>,
) : Tickable,
  DisplayTickable,
  Handleable,
  GameWorldProvider {
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

  override suspend fun displayTick(tick: Int, displayTick: Int) {}

  override val coroutineContext: CoroutineContext
    get() = instance.coroutineContext

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
}
