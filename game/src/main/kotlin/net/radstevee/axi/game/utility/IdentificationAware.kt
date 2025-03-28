package net.radstevee.axi.game.utility

import java.util.UUID

/** Represents something that has a string and UUID identification. */
public interface IdentificationAware {
  /** The UUID identification. */
  public val uuid: UUID

  /** The string identification. */
  public val id: String get() = uuid.toString()
}
