package net.radsteve.axi.ecs.component

import kotlinx.coroutines.delay
import net.radsteve.axi.tick.TickDuration.inWholeTicks
import net.radsteve.axi.tick.TickDuration.ticks
import org.bukkit.Bukkit
import kotlin.reflect.KClass
import kotlin.time.Duration

/** Holds debounce information for attachables. */
public data class DebounceComponent(
  /** The debounce entries. */
  public val entries: MutableMap<KClass<out Any>, DebounceEntry> = mutableMapOf(),
) {
  /** A debounce entry. */
  public data class DebounceEntry(
    /** The duration of the debounce. */
    public val durationTicks: Long,
    /** The timestamp for the start of the debounce period. */
    public val startTick: Int,
  )

  /** Adds an entry to the component. */
  public fun add(klass: KClass<out Any>, duration: Duration): DebounceEntry {
    val entry = DebounceEntry(duration.inWholeTicks, Bukkit.getCurrentTick())
    entries[klass] = entry
    return entry
  }

  /** Checks the entries for the given debounce [klass], removes the entry if it elapsed and returns whether it has elapsed. */
  public fun check(klass: KClass<out Any>): Boolean {
    val entry = entries[klass] ?: return true
    val currentTick = Bukkit.getCurrentTick()
    val elapsedTicks = currentTick - entry.startTick

    val elapsed = elapsedTicks >= entry.durationTicks

    if (elapsed) {
      entries.remove(klass)
    }

    return elapsed
  }

  /** Suspends until the debounce entry for the given  [klass] has expired
   * and returns whether it had to wait, if the entry did not exist,
   * it will return false.*/
  public suspend fun wait(klass: KClass<out Any>): Boolean {
    entries[klass] ?: return false

    while (!check(klass)) {
      delay(1.ticks)
    }

    return true
  }
}
