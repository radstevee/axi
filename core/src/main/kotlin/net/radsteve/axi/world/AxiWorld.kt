package net.radsteve.axi.world

import live.minehub.polarpaper.Polar
import live.minehub.polarpaper.PolarReader
import live.minehub.polarpaper.PolarWorld
import net.radsteve.axi.coroutines.AxiCoroutines.ioContext
import net.radsteve.axi.utility.Identified
import java.util.UUID

/** An identified polar world. */
public class AxiWorld(
  override val id: String,
  public val polarWorld: PolarWorld,
) : Identified {
  override val uuid: UUID = UUID.nameUUIDFromBytes(id.toByteArray())

  public companion object {
    public suspend fun load(id: String, bytes: ByteArray): AxiWorld = ioContext {
      val world = PolarReader.read(bytes)
      Polar.loadWorld(world, id)
      AxiWorld(id, world)
    }
  }
}
