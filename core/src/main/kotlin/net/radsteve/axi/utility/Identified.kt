package net.radsteve.axi.utility

import java.util.UUID

/** Represents something that has a string and UUID identification. */
public interface Identified {
  /** The UUID identification. */
  public val uuid: UUID

  /** The string identification. */
  public val id: String get() = uuid.toString()
}
