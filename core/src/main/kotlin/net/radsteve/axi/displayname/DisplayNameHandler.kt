package net.radsteve.axi.displayname

import com.destroystokyo.paper.event.player.PlayerPostRespawnEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.radsteve.axi.ecs.Attachable
import net.radsteve.axi.ecs.ECS
import net.radsteve.axi.ecs.get
import net.radsteve.axi.ecs.player
import net.radsteve.axi.ecs.set
import net.radsteve.axi.ecs.system.System
import net.radsteve.axi.event.SuspendingListener
import net.radsteve.axi.plugin.AxiPlugin
import net.radsteve.axi.plugin.AxiPluginHolder
import net.radsteve.axi.tick.TickDuration.ticks
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerGameModeChangeEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.player.PlayerTeleportEvent
import org.bukkit.event.server.PluginDisableEvent
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.Team
import kotlin.reflect.KClass

internal object DisplayNameHandler : System, SuspendingListener {
  override val archetypes: Sequence<KClass<out Any>> = sequenceOf(DisplayNameComponent::class)
  private val board: Scoreboard = Bukkit.getScoreboardManager().mainScoreboard
  val hiddenNameTeam: Team = board.getTeam("axi_hidden") ?: board.registerNewTeam("axi_hidden").apply {
    setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER)
  }

  override suspend fun tick(tick: Int, attachable: Attachable) {
    val player = attachable.player ?: return

    if (player.gameMode == GameMode.SPECTATOR) {
      return
    }
    val component = attachable.get<DisplayNameComponent>()!!

    component.create(player)
    component.textDisplay!!.text(component.displayName)
    hiddenNameTeam.addEntity(player)
    player.hideEntity(AxiPluginHolder.plugin(), component.textDisplay!!)
  }

  @EventHandler
  private fun on(event: PlayerTeleportEvent) {
    val player = event.player
    val component = player.get<DisplayNameComponent>() ?: return
    if (component.textDisplay == null) {
      return
    }
    val isAcrossWorlds = event.from.world.uid != event.to.world.uid

    player.removePassenger(component.textDisplay!!)
    if (isAcrossWorlds) {
      remove(player)
    }

    launch {
      delay(1.ticks)
      if (!isAcrossWorlds) {
        component.textDisplay?.let(player::addPassenger)
      } else {
        // remove(player)
      }
    }
  }

  @EventHandler
  private fun on(event: PlayerGameModeChangeEvent) {
    val player = event.player
    val component = player.get<DisplayNameComponent>() ?: return
    if (component.textDisplay == null) {
      return
    }

    if (event.newGameMode != GameMode.SPECTATOR) {
      return
    }

    component.textDisplay!!.remove()
    component.textDisplay = null
  }

  fun remove(player: Player, setToNull: Boolean = true) {
    val component = player.get<DisplayNameComponent>() ?: return
    component.textDisplay?.remove()
    if (setToNull) {
      component.textDisplay = null
    }
    hiddenNameTeam.removeEntity(player)
  }

  @EventHandler(priority = EventPriority.LOWEST)
  private fun on(event: PlayerQuitEvent) {
    remove(event.player)
  }

  @EventHandler
  private fun on(event: PlayerDeathEvent) {
    // We wait with setting it to null until the player respawns
    remove(event.player, setToNull = false)
  }

  @EventHandler
  private fun on(event: PlayerPostRespawnEvent) {
    remove(event.player)
  }

  @EventHandler
  private fun on(event: PluginDisableEvent) {
    if (event.plugin !is AxiPlugin) {
      return
    }

    ECS.entities().forEach { attachable ->
      val displayNameComponent = attachable.get<DisplayNameComponent>() ?: return@forEach
      displayNameComponent.textDisplay = null
      attachable.set<DisplayNameComponent>(null)
    }
  }
}
