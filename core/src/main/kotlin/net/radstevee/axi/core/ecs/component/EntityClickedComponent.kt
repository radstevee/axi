package net.radstevee.axi.core.ecs.component

import net.radstevee.axi.core.ecs.addDebounce
import net.radstevee.axi.core.ecs.checkDebounce
import net.radstevee.axi.core.ecs.get
import net.radstevee.axi.core.tick.TickDuration.ticks
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerInteractEntityEvent

/** Executes [handler] if [filter] returns true when a player clicks an entity. */
public data class EntityClickedComponent(
  /** The click handler. */
  public var handler: suspend ClickContext.() -> Unit,
  /** An entity filter. */
  public var filter: suspend ClickContext.() -> Boolean = { true },
) {
  /** The context of a click handler. */
  public data class ClickContext(
    /** The player who clicked an entity. */
    public val player: Player,
    /** The clicked entity. */
    public val entity: Entity,
    /** Whether the [player] left-clicked the entity. */
    public val isLeftClick: Boolean,
    /** Whether the [player] right-clicked the entity. */
    public val isRightClick: Boolean,
  )

  /** Click logic for this component. */
  internal companion object Handler : Listener {
    private suspend fun handle(player: Player, entity: Entity, isLeftClick: Boolean, isRightClick: Boolean) {
      if (!player.checkDebounce(EntityClickedComponent::class)) {
        return
      }

      val component = player.get<EntityClickedComponent>() ?: return
      val ctx = ClickContext(player, entity, isLeftClick, isRightClick)

      player.addDebounce(EntityClickedComponent::class, 1.ticks)

      if (component.filter(ctx)) {
        component.handler(ctx)
      }
    }

    @EventHandler
    private suspend fun on(event: PlayerInteractEntityEvent) {
      handle(event.player, event.rightClicked, false, true)
    }

    @EventHandler
    private suspend fun on(event: EntityDamageByEntityEvent) {
      handle(event.damager as? Player ?: return, event.entity, true, false)
    }
  }

  /** Sets [block] as the [filter]. */
  public fun filtering(block: suspend ClickContext.() -> Boolean) {
    filter = block
  }
}
