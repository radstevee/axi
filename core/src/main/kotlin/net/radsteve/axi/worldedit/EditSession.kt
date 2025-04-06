package net.radsteve.axi.worldedit

import com.fastasyncworldedit.core.extent.processor.lighting.RelightMode
import com.sk89q.worldedit.EditSession
import com.sk89q.worldedit.WorldEdit
import com.sk89q.worldedit.bukkit.BukkitAdapter
import org.bukkit.World

/** Creates a new edit session for the given [world]. */
public fun editSession(world: World): EditSession {
  return WorldEdit.getInstance()
    .newEditSessionBuilder()
    .world(BukkitAdapter.adapt(world))
    .checkMemory(false)
    .allowedRegionsEverywhere()
    .fastMode(true)
    .relightMode(RelightMode.OPTIMAL)
    .limitUnlimited()
    .build()
}
