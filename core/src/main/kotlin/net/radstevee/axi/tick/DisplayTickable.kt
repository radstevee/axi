package net.radstevee.axi.tick

/** Something that can tick once a second. */
public fun interface DisplayTickable : Tickable {
  /** Ticks this display tickable. */
  public fun displayTick(tick: Int, displayTick: Int)

  override fun tick(startTick: Int, tick: Int) {
    val currentTick = tick - startTick

    if (currentTick % 20 == 0) {
      displayTick(currentTick, currentTick / 20)
    }
  }
}
