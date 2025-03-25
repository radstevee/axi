package net.radstevee.axi.ecs

import net.radstevee.axi.ecs.component.IdentityComponent
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
