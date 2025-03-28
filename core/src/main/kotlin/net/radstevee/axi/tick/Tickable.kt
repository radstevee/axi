package net.radstevee.axi.tick

/** Something that can tick. */
public fun interface Tickable {
  /** Ticks this tickable. */
  public fun tick(startTick: Int, tick: Int)
}
