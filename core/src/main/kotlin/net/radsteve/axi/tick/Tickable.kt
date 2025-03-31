package net.radsteve.axi.tick

/** Something that can tick. */
public fun interface Tickable {
  /** Ticks this tickable. */
  public suspend fun tick(startTick: Int, tick: Int)
}
