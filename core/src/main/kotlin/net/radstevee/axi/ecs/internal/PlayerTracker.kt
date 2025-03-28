package net.radstevee.axi.ecs.internal

import net.radstevee.axi.ecs.WrappedAttachable
import net.radstevee.axi.ecs.component.IdentityComponent
import net.radstevee.axi.ecs.set
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
