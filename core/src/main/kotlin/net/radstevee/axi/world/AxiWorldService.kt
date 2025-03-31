package net.radstevee.axi.world

import live.minehub.polarpaper.Polar
import live.minehub.polarpaper.PolarReader
import net.radstevee.axi.coroutines.AxiCoroutines.ioContext
import org.koin.core.component.KoinComponent

/** A service which saves polar worlds. */
public interface AxiWorldService : KoinComponent {
  /** Saves the given [world]. */
  public suspend fun save(world: AxiWorld)

  /** Loads a world from a given [id]. */
  public suspend fun load(id: String): Result<AxiWorld>

  /** Loads a world from a given [id] and its [bytes]. */
  public suspend fun load(id: String, bytes: ByteArray): AxiWorld = ioContext {
    val world = PolarReader.read(bytes)
    Polar.loadWorld(world, id)
    AxiWorld(id, world)
  }
}
