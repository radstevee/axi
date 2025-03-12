package net.radstevee.axi.core.ecs

import java.util.UUID

/** Tracks an online player's attachable. */
internal object PlayerTracker {
  val attachables: MutableMap<UUID, WrappedAttachable<UUID>> = mutableMapOf()

  operator fun get(uuid: UUID): WrappedAttachable<UUID> = attachables.getOrPut(uuid) { WrappedAttachable(uuid, UUID::class) }

  fun unset(uuid: UUID) {
    attachables.remove(uuid)
  }
}
