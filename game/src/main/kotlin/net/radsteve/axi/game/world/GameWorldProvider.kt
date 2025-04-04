package net.radsteve.axi.game.world

import com.sk89q.worldedit.bukkit.BukkitAdapter.adapt
import com.sk89q.worldedit.extent.clipboard.Clipboard
import com.sk89q.worldedit.math.BlockVector3
import net.kyori.adventure.util.TriState
import net.radsteve.axi.coroutines.AxiCoroutines.asyncContext
import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.tick.TickDuration.inWholeTicks
import net.radsteve.axi.utility.bukkit
import org.bukkit.WorldCreator
import org.bukkit.WorldType
import kotlin.time.measureTime

/** A provider for [GameWorld]s. */
public fun interface GameWorldProvider {
  /** Gets the [GameWorld] for a given [instance]. */
  public suspend fun gameWorld(instance: GameInstance<*>): GameWorld

  /** Delegates a world provider to the [other] provider. */
  public suspend fun GameInstance<*>.delegateWorldProvider(other: GameWorldProvider): GameWorld {
    return other.gameWorld(this)
  }

  public companion object {
    /** Creates a void world. */
    public fun void(): GameWorldProvider = GameWorldProvider { instance ->
      GameWorld(
        WorldCreator.ofKey(TemporaryWorldNameProvider[instance.key()].bukkit())
          .biomeProvider(VoidBiomeProvider)
          .generator(VoidChunkGenerator)
          .type(WorldType.FLAT)
          .keepSpawnLoaded(TriState.FALSE)
          .generateStructures(false)
          .createWorld()
          ?: error("failed creating world"),
      )
    }

    /** Creates a void world and pastes the given [clipboard] at (0, 0, 0). */
    public fun clipboard(clipboard: Clipboard): GameWorldProvider = GameWorldProvider { instance ->
      val world = void().gameWorld(instance)
      val time = measureTime {
        asyncContext {
          clipboard.paste(adapt(world.world), BlockVector3.ZERO, false, false, true, null)
        }
      }

      instance.logger.info("Clipboard pasted in ${time.inWholeSeconds}s (${time.inWholeTicks} ticks)")

      world
    }
  }
}
