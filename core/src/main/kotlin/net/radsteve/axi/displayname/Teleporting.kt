package net.radsteve.axi.displayname

import io.papermc.paper.entity.TeleportFlag
import net.radsteve.axi.ecs.get
import org.bukkit.Location
import org.bukkit.entity.Player

/** Teleports the player to the given [location] whilst retaining passengers. */
public fun Player.axiTeleport(location: Location): Boolean {
  val textDisplay = get<DisplayNameComponent>()?.textDisplay
  textDisplay?.let(::removePassenger)
  val result = teleport(location, TeleportFlag.EntityState.RETAIN_PASSENGERS)
  textDisplay?.let(::addPassenger)
  return result
}
