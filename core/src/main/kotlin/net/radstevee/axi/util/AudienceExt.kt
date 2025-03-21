package net.radstevee.axi.util

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.audience.ForwardingAudience
import net.kyori.adventure.identity.Identity
import net.radstevee.axi.ecs.Attachable
import net.radstevee.axi.ecs.attachable
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

/** Gets the UUID of this audience, or null. */
public fun Audience.uuidOrNull(): UUID? = get(Identity.UUID).getOrNull()

/** Gets the UUID of this audience, or throws. */
public fun Audience.uuid(): UUID = uuidOrNull() ?: error("audience does not have a UUID")

/** Executes [block] for each player in this audience. */
// Implementation note: This is so utterly complex just because
// I have had terrible experiences with many stack overflows before.
public fun Audience.forEachPlayer(block: (Player) -> Unit) {
  val visited = mutableSetOf<Audience>()
  val queue = ArrayDeque<Audience>()

  queue.add(this)

  while (queue.isNotEmpty()) {
    val current = queue.removeFirst()

    if (current in visited) {
      continue
    }

    visited.add(current)

    if (current is Player) {
      block(current)
    } else {
      current.uuidOrNull()?.let(Bukkit::getPlayer)?.let(block)

      if (current is ForwardingAudience) {
        current.forEachAudience { child ->
          if (child !in visited) {
            queue.add(child)
          }
        }
      }
    }
  }
}

/** Gets the players contained in this audience. */
public fun Audience.players(): Set<Player> = buildSet { forEachPlayer(::add) }

/** Applies [transform] on each player and returns the result. */
public fun <R> Audience.mapPlayers(transform: (Player) -> R): Set<R> = buildSet {
  forEachPlayer { player -> add(transform(player)) }
}

/** Gets all attachables in this audience. */
public fun Audience.attachables(): Set<Attachable> = mapPlayers(Player::attachable)
