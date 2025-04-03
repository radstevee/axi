package net.radsteve.axi.game.instance

/** The lifecycle state of a game instance. */
public enum class GameLifecycle {
  /** The instance is idling and has not been initialised yet. */
  Idling,

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
