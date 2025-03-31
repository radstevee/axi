package net.radsteve.axi.game.instance

/** The lifecycle state of a game instance. */
public enum class GameLifecycle {
  /** The instance is initialising. */
  Initializing,

  /** The instance is running. */
  Running,

  /** The instance is stopping. */
  Stopping,

  /** The instance is cleaning itself up. */
  Cleanup,

  /** The instance has ended. */
  Ended,
}
