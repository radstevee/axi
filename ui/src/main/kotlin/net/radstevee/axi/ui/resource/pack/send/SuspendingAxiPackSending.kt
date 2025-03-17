package net.radstevee.axi.ui.resource.pack.send

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerResourcePackStatusEvent
import java.util.UUID

internal object SuspendingAxiPackSending : Listener {
  private val flow: MutableSharedFlow<Pair<UUID, UUID>> = MutableSharedFlow()

  suspend fun wait(uuid: UUID, packId: UUID) {
    flow.first { (player, pack) -> player == uuid && pack == packId }
  }

  @EventHandler
  private suspend fun on(event: PlayerResourcePackStatusEvent) {
    if (event.status == PlayerResourcePackStatusEvent.Status.ACCEPTED) {
      return
    }

    flow.emit(event.player.uniqueId to event.id)
  }
}
