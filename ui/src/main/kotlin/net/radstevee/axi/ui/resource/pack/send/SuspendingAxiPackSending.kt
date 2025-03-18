package net.radstevee.axi.ui.resource.pack.send

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import net.radstevee.axi.core.plugin.event.SuspendingListener
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerResourcePackStatusEvent
import org.bukkit.event.player.PlayerResourcePackStatusEvent.Status
import java.util.UUID

internal object SuspendingAxiPackSending : SuspendingListener {
  private val flow: MutableSharedFlow<Pair<UUID, UUID>> = MutableSharedFlow()
  private val discardedStatuses: Set<Status> = setOf(
    Status.ACCEPTED,
    Status.DOWNLOADED,
  )

  suspend fun wait(uuid: UUID, packId: UUID) {
    flow.first { (player, pack) -> player == uuid && pack == packId }
  }

  @EventHandler
  private suspend fun on(event: PlayerResourcePackStatusEvent) {
    if (event.status in discardedStatuses) {
      return
    }

    flow.emit(event.player.uniqueId to event.id)
  }
}
