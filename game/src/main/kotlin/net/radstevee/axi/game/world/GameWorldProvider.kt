package net.radstevee.axi.game.world

import net.kyori.adventure.util.TriState
import net.radstevee.axi.game.instance.GameInstance
import net.radstevee.axi.utility.bukkit
import org.bukkit.WorldCreator
import org.bukkit.WorldType

/** A provider for [GameWorld]s. */
public fun interface GameWorldProvider<T : GameInstance<T>> {
  /** Gets the [GameWorld] for a given [instance]. */
  public fun gameWorld(instance: GameInstance<T>): GameWorld<T>

  public companion object {
    /** Creates a void world. */
    public fun <T : GameInstance<T>> void(): GameWorldProvider<T> = GameWorldProvider { instance ->
      GameWorld(
        WorldCreator.ofKey(TemporaryWorldNameProvider[instance.key()].bukkit())
          .biomeProvider(VoidBiomeProvider)
          .generator(VoidChunkGenerator)
          .type(WorldType.FLAT)
          .keepSpawnLoaded(TriState.FALSE)
          .generateStructures(false)
          .createWorld()
          ?: error("failed creating world")
      )
    }
  }
}
