package net.radstevee.axi.core.tick

/** Something that can tick once a second. */
public fun interface DisplayTickable : Tickable {
  /** Ticks this display tickable. */
  public fun displayTick(tick: Int, displayTick: Int)

  override fun tick(startTick: Int, currentTick: Int) {
    val tick = currentTick - startTick

    if (tick % 20 == 0) {
      displayTick(tick, tick / 20)
    }
  }
}
