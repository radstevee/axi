package net.radsteve.axi.worldedit

import com.sk89q.worldedit.extent.clipboard.Clipboard
import com.sk89q.worldedit.function.mask.ExistingBlockMask
import com.sk89q.worldedit.function.operation.ForwardExtentCopy
import com.sk89q.worldedit.function.operation.Operations
import com.sk89q.worldedit.math.BlockVector3
import org.bukkit.World

/** Pastes this clipboard into the given [world] at the given [location]. */
public fun Clipboard.pasteFast(world: World, location: BlockVector3) {
  val session = editSession(world)
  paste(session, location, false, true, hasBiomes())
  session.flushQueue()
  val fec = ForwardExtentCopy(this, region, origin, session, location)
  fec.isCopyingEntities = true
  fec.sourceMask = ExistingBlockMask(this)
  try {
    Operations.completeLegacy(fec)
  } finally {
    session.close()
  }
}
