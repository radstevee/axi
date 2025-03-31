package net.radsteve.axi.ecs.internal

import net.radsteve.axi.ecs.WrappedAttachable
import net.radsteve.axi.ecs.component.IdentityComponent
import net.radsteve.axi.ecs.set
import java.util.UUID

/** Tracks an online player's attachable. */
internal object PlayerTracker {
  val attachables: MutableMap<UUID, WrappedAttachable<UUID>> = mutableMapOf()

  operator fun get(uuid: UUID): WrappedAttachable<UUID> {
    return attachables.getOrPut(uuid) {
      WrappedAttachable(uuid, UUID::class).also { attachable ->
        attachable.set(IdentityComponent(uuid))
      }
    }
  }

  fun unset(uuid: UUID) {
    attachables.remove(uuid)
  }
}
