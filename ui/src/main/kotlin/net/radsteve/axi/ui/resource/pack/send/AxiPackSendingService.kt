package net.radsteve.axi.ui.resource.pack.send

import net.kyori.adventure.audience.Audience
import net.radsteve.axi.plugin.AxiPluginHolder
import net.radsteve.axi.ui.resource.pack.AxiPack
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.UUID

/** A service responsible for sending axi packs to audiences. */
public interface AxiPackSendingService : KoinComponent {
  /**
   * Sends an [AxiPack] to an audience if it is not applied yet and
   * returns whether it loaded successfully for each player.
   * If a player disconnects whilst loading the pack, it will return false for them.
   */
  public suspend fun Audience.sendAxiPack(pack: AxiPack): Map<UUID, Boolean>

  /** Removes an [AxiPack] from an audience. */
  public suspend fun Audience.removeAxiPack(pack: AxiPack)
}

private val service: AxiPackSendingService by AxiPluginHolder.plugin().inject()

/** Sends an [AxiPack] to an audience if it is not applied yet and
 * returns whether it loaded successfully for each player.
 * If a player disconnects whilst loading the pack, it will return false for them.
 *
 * @see AxiPackSendingService.sendAxiPack*/
public suspend fun Audience.sendAxiPack(pack: AxiPack): Map<UUID, Boolean> {
  return with(service) {
    sendAxiPack(pack)
  }
}

/** Removes an [AxiPack] from an audience.
 *
 * @see AxiPackSendingService.removeAxiPack*/
public suspend fun Audience.removeAxiPack(pack: AxiPack) {
  with(service) {
    removeAxiPack(pack)
  }
}
