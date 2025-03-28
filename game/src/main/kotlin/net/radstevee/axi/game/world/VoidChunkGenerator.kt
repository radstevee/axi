package net.radstevee.axi.game.world

import org.bukkit.Location
import org.bukkit.World
import org.bukkit.generator.ChunkGenerator
import java.util.Random

/** A chunk generator that generates nothing. */
public object VoidChunkGenerator : ChunkGenerator() {
  override fun getFixedSpawnLocation(world: World, random: Random): Location? {
    return Location(world, 0.0, 0.0, 0.0)
  }
}
