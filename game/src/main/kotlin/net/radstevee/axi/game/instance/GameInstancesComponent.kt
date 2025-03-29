package net.radstevee.axi.game.instance

/** Tracks the state of current game instances. */
public data class GameInstancesComponent(
  /** The currently running game instances. */
  public val instances: MutableSet<GameInstance<*>> = mutableSetOf(),
)
