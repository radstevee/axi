package net.radsteve.axi.game.world

import net.kyori.adventure.key.Key
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.pathString

/** Provides world names for temporary worlds so they are stored in the OS temp directory. */
public object TemporaryWorldNameProvider {
  private val TEMP_DIR: Path = Path(System.getProperty("java.io.tmpdir"), "axi-temporary-worlds")

  /** Gets the temporary world name for a world named the given [key]. */
  public operator fun get(key: Key): Key {
    val dir = TEMP_DIR.resolve(key.namespace()).resolve(key.value())
    dir.createDirectories()
    return Key.key(key.namespace(), dir.pathString)
  }
}
