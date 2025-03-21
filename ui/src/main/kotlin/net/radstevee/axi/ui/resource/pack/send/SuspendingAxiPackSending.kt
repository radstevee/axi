package net.radstevee.axi.ui.resource.pack.send

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import net.radstevee.axi.plugin.event.SuspendingListener
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.player.PlayerResourcePackStatusEvent
import org.bukkit.event.player.PlayerResourcePackStatusEvent.Status
import java.util.UUID

internal object SuspendingAxiPackSending : SuspendingListener {
  private data class Entry(val player: UUID, val pack: UUID, val loaded: Boolean)

  private val flow: MutableSharedFlow<Entry> = MutableSharedFlow()
  private val discardedStatuses: Set<Status> = setOf(
    Status.ACCEPTED,
    Status.DOWNLOADED,
  )
  private val loadingPacks: MutableMap<UUID, MutableList<UUID>> = mutableMapOf()

  suspend fun wait(uuid: UUID, packId: UUID): Boolean {
    loadingPacks.getOrPut(uuid, ::mutableListOf).add(packId)
    return flow.first { (player, pack) -> player == uuid && pack == packId }.loaded
  }

  @EventHandler
  private suspend fun on(event: PlayerQuitEvent) {
    val player = event.player.uniqueId

    loadingPacks[player]?.forEach { pack ->
      flow.emit(Entry(event.player.uniqueId, player, false))
    }
    loadingPacks.remove(player)
  }

  @EventHandler
  private suspend fun on(event: PlayerResourcePackStatusEvent) {
    val status = event.status
    if (status in discardedStatuses) {
      return
    }
    val player = event.player.uniqueId
    val loaded = status == Status.SUCCESSFULLY_LOADED
    flow.emit(Entry(player, event.id, loaded))
    loadingPacks.getOrPut(player, ::mutableListOf).remove(event.id)
  }
}
