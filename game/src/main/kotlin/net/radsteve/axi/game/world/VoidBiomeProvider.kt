package net.radsteve.axi.game.world

import org.bukkit.block.Biome
import org.bukkit.generator.BiomeProvider
import org.bukkit.generator.WorldInfo

/** A biome provider that only returns the void. */
public object VoidBiomeProvider : BiomeProvider() {
  override fun getBiome(worldInfo: WorldInfo, x: Int, y: Int, z: Int): Biome {
    return Biome.THE_VOID
  }

  override fun getBiomes(worldInfo: WorldInfo): List<Biome?> {
    return emptyList()
  }
}
