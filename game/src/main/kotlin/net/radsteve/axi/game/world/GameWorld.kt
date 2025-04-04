package net.radsteve.axi.game.world

import org.bukkit.Bukkit
import org.bukkit.World

/** A world used by a game instance. */
public class GameWorld(
  /** The inner world. */
  public val world: World,
  /** Whether this world should be removed after the instance ends. */
  public val isTemporary: Boolean = false,
) {
  init {
    if (isTemporary) {
      world.worldFolder.deleteOnExit()
    }
  }

  /** Unloads this game world. */
  public fun unload() {
    Bukkit.unloadWorld(world, false)
    world.worldFolder.deleteRecursively()
  }
}
