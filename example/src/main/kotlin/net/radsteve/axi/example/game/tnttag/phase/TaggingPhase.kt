package net.radsteve.axi.example.game.tnttag.phase

import net.radsteve.axi.example.game.tnttag.TntTagInstance
import net.radsteve.axi.game.phase.GamePhase
import net.radsteve.axi.ui.theme.Themed
import net.radsteve.axi.utility.buildItemStack
import net.radsteve.axi.utility.onlinePlayer
import net.radsteve.axi.utility.players
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDropItemEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

public class TaggingPhase(instance: TntTagInstance) : GamePhase<TntTagInstance>(instance), Themed by instance {
  override suspend fun displayTick(tick: Int, displayTick: Int) {
    // Reroll the tagger every 20 seconds
    if (displayTick % 20 != 0) {
      return
    }

    // Don't reroll in the last second
    if (displayTick == durationSeconds!!) {
      return
    }

    val oldTagger = instance.currentTaggerOrNull()?.onlinePlayer
    val newTagger = instance.rerollTagger().onlinePlayer
    newTagger(newTagger, oldTagger, countsToStats = false)
    newTagger.send {
      append("You were randomly selected to be the ")
      append("tagger", red, bold)
      append("!")
      yellow()
    }
    oldTagger?.send {
      append("You are ")
      append("not ", red, bold)
      append("the tagger anymore!")
      green()
    }
  }

  private fun equipTagger(player: Player) {
    player.inventory.helmet = buildItemStack(Material.TNT)
    player.inventory.addItem(buildItemStack(Material.TNT))
    player.addPotionEffect(PotionEffect(PotionEffectType.SPEED, -1, 0, false, false, false))
  }

  private fun notifyNewTagger(newTagger: Player, oldTagger: Player? = null) {
    newTagger.send {
      append("You are now the ")
      append("tagger", red, bold)
      append("!")
      yellow()
    }
    oldTagger?.send {
      append("You are ")
      append("not ", red, bold)
      append("the tagger anymore!")
      green()
    }
  }

  private fun newTagger(newTagger: Player, oldTagger: Player? = null, countsToStats: Boolean = true) {
    with(instance) {
      if (!countsToStats) {
        return@with
      }

      newTagger.stats.timesTagged++
      if (oldTagger != null) {
        oldTagger.stats.tags++
      }
    }

    instance.newTagger(newTagger.uniqueId)
    equipTagger(newTagger)
    oldTagger?.inventory?.clear()
    oldTagger?.clearActivePotionEffects()
  }

  override suspend fun start() {
    val initialTagger = instance.rerollTagger()
    val player = initialTagger.onlinePlayer

    newTagger(initialTagger.onlinePlayer, countsToStats = false)
    send {
      append(player.displayName())
      appendSpace()
      append("is starting as the ")
      append("tagger", red, bold)
      append("!")
      yellow()
    }
  }

  override suspend fun end() {
    instance.resetTagger()
    players.forEach { player ->
      player.inventory.clear()
    }

    send {
      append("The game is over!")
      red()
      bold()
    }
  }

  override suspend fun on(event: EntityDamageByEntityEvent) {
    event.isCancelled = true
    val damager = event.damager as? Player ?: return
    val hitPlayer = event.entity as? Player ?: return

    if (!instance.isTagger(damager)) {
      return
    }

    newTagger(hitPlayer, damager)
    notifyNewTagger(hitPlayer, damager)
    damager.inventory.clear()
  }

  override suspend fun on(event: EntityDropItemEvent) {
    event.isCancelled = true
  }
}
