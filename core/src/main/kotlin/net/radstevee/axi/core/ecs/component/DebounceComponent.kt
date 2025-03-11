package net.radstevee.axi.core.ecs.component

import kotlin.reflect.KClass
import kotlin.time.Duration

/** Holds debounce information for players. */
public data class DebounceComponent(
  /** The debounce entries. */
  public val entries: MutableMap<KClass<out Any>, DebounceEntry> = mutableMapOf(),
) {
  /** A debounce entry. */
  public data class DebounceEntry(
    /** The duration of the debounce. */
    public val duration: Duration,
    /** The timestamp for the start of the debounce period. */
    public val startTimestamp: Long,
  )

  /** Adds an entry to the component. */
  public fun add(klass: KClass<out Any>, duration: Duration): DebounceEntry {
    val entry = DebounceEntry(duration, System.currentTimeMillis())
    entries[klass] = entry
    return entry
  }

  /** Checks the entries for the given debounce [klass], removes the entry if it elapsed and returns whether it has elapsed. */
  public fun check(klass: KClass<out Any>): Boolean {
    val entry = entries[klass] ?: return true
    val currentTimestamp = System.currentTimeMillis()
    val elapseTimestamp = entry.startTimestamp + entry.duration.inWholeMilliseconds

    val elapsed = currentTimestamp >= elapseTimestamp

    if (elapsed) {
      entries.remove(klass)
    }

    return elapsed
  }
}
