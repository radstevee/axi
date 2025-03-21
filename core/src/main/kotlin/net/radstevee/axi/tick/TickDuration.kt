package net.radstevee.axi.tick

import kotlin.time.Duration
import kotlin.time.Duration.Companion.nanoseconds

/** Holds utilities about tick durations. */
public object TickDuration {
  /** The duration of a single tick, in nanoseconds. */
  public const val NANOS_PER_TICK: Long = 1_000_000_000L / 20

  /** The duration of a single tick. */
  public val SINGLE_TICK: Duration = NANOS_PER_TICK.nanoseconds

  public inline val Int.ticks: Duration get() = toLong().ticks
  public inline val Long.ticks: Duration get() = (this * NANOS_PER_TICK).nanoseconds
  public inline val Double.ticks: Duration get() = toLong().ticks
  public inline val Duration.inWholeTicks: Long get() = inWholeNanoseconds / NANOS_PER_TICK
}
