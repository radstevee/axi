package net.radstevee.axi.game.world

import net.radstevee.axi.game.instance.GameInstance
import org.bukkit.World

/** A world used by a game instance. */
public class GameWorld<T : GameInstance<T>>(
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
}
