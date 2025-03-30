package net.radstevee.axi.game.phase

import net.radstevee.axi.game.instance.GameInstance
import kotlin.reflect.KClass
import kotlin.time.Duration

/** A schedule of [GamePhase]s for a game instance. */
public class GameSchedule<T : GameInstance<T>> {
  /** A schedule entry. */
  public data class ScheduleEntry<T : GameInstance<T>>(
    /** The supplier of the game phase. */
    public val phaseSupplier: (GameInstance<T>) -> GamePhase<T>,
    /** The klass of the return type of [phaseSupplier]. */
    public val phaseKlass: KClass<out GamePhase<T>>,
    /** The duration of this phase. */
    public val duration: Duration? = null,
  )

  private val schedule: MutableList<ScheduleEntry<T>> = mutableListOf()

  /** Adds the given [entry]. */
  public fun add(entry: ScheduleEntry<T>) {
    schedule.add(entry)
  }

  /** Adds an entry of the given [phaseSupplier] for the given [duration]. */
  public inline fun <reified P : GamePhase<T>> add(
    duration: Duration? = null,
    noinline phaseSupplier: (GameInstance<T>) -> P,
  ) {
    add(ScheduleEntry(phaseSupplier, P::class, duration))
  }

  /** Adds the given phases [roundCount] times. */
  public inline fun <
    reified Waiting : GamePhase<T>,
    reified Round : GamePhase<T>,
    reified Ending : GamePhase<T>,
    > addRoundPhases(
    roundCount: Int,
    waitingDuration: Duration?,
    roundDuration: Duration?,
    endingDuration: Duration?,
    noinline waitingPhaseSupplier: (GameInstance<T>) -> Waiting,
    noinline roundPhaseSupplier: (GameInstance<T>) -> Round,
    noinline endingPhaseSupplier: (GameInstance<T>) -> Ending,
  ) {
    repeat(roundCount) {
      add(waitingDuration, waitingPhaseSupplier)
      add(roundDuration, roundPhaseSupplier)
      add(endingDuration, endingPhaseSupplier)
    }
  }

  /** Calls [block] for the next scheduled entry, if it exists, and returns whether it has been called. */
  public suspend fun accept(block: suspend (ScheduleEntry<T>) -> Unit): Boolean {
    val entry = schedule.removeFirstOrNull()
    entry?.apply { block(this) }
    return entry != null
  }

  /** Gets the total duration of this schedule. */
  public fun totalDuration(): Duration {
    return schedule
      .mapNotNull(ScheduleEntry<T>::duration)
      .fold(Duration.ZERO) { acc, elem -> acc + elem }
  }

  /** Clears this schedule. */
  public fun clear() {
    schedule.clear()
  }

  /** Checks whether the schedule is empty. */
  public fun empty(): Boolean {
    return schedule.isEmpty()
  }

  override fun toString(): String = buildString {
    append("GameSchedule[")

    append(
      schedule.joinToString { supplier ->
        // Format: <klass>(<duration>s)
        buildString {
          append(supplier.phaseKlass.simpleName)
          append("(")
          append(supplier.duration?.inWholeSeconds ?: -1)
          append("s)")
        }
      },
    )

    append("]")
  }

  public companion object {
    /** Builds a game schedule using the given [block]. */
    public inline fun <T : GameInstance<T>> buildSchedule(block: GameSchedule<T>.() -> Unit = {}): GameSchedule<T> {
      return GameSchedule<T>().apply(block)
    }
  }
}
