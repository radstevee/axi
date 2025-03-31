package net.radsteve.axi.world

import live.minehub.polarpaper.Polar
import live.minehub.polarpaper.PolarReader
import live.minehub.polarpaper.PolarWriter
import net.radsteve.axi.coroutines.AxiCoroutines.ioContext
import net.radsteve.axi.utility.PluginAware
import java.nio.file.Path
import kotlin.io.path.createParentDirectories
import kotlin.io.path.readBytes

/** Reads and writes worlds from the main [net.radsteve.axi.plugin.AxiPlugin]'s data directory. */
public class FileWorldService(
  /** The path that worlds should be stored in. */
  public val directory: Path,
) : AxiWorldService, PluginAware {
  override suspend fun save(world: AxiWorld) {
    ioContext {
      val target = directory.resolve("${world.id}.polar")

      target.createParentDirectories()

      Polar.saveWorld(PolarWriter.write(world.polarWorld), target)
    }
  }

  override suspend fun load(id: String): Result<AxiWorld> = ioContext {
    val target = directory.resolve("$id.polar")

    runCatching {
      val bytes = target.readBytes()
      val world = PolarReader.read(bytes)

      AxiWorld(id, world)
    }
  }
}
