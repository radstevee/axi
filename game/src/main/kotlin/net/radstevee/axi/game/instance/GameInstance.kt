package net.radstevee.axi.game.instance

import kotlinx.coroutines.CoroutineScope
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.audience.ForwardingAudience
import net.kyori.adventure.key.Keyed
import net.radstevee.axi.coroutines.AxiCoroutines.coroutineScope
import net.radstevee.axi.ecs.Attachable
import net.radstevee.axi.ecs.get
import net.radstevee.axi.ecs.getOrPut
import net.radstevee.axi.ecs.system.System
import net.radstevee.axi.game.utility.IdentificationAware
import net.radstevee.axi.game.utility.LoggerHolder
import net.radstevee.axi.game.utility.PluginAware
import net.radstevee.axi.game.world.GameWorld
import net.radstevee.axi.game.world.GameWorldHolder
import net.radstevee.axi.game.world.GameWorldProvider
import net.radstevee.axi.tick.DisplayTickable
import net.radstevee.axi.tick.Tickable
import org.bukkit.event.Listener
import org.koin.core.component.KoinComponent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/** An instance of a game. */
public abstract class GameInstance<T : GameInstance<T>>(
  /** The context of this instance. */
  public open val context: GameContext,
) :
  ForwardingAudience,
  Tickable,
  DisplayTickable,
  CoroutineScope by coroutineScope,
  AbstractCoroutineContextElement(ContextKey),
  Attachable,
  IdentificationAware by context,
  GameWorldHolder<T>,
  GameWorldProvider<T> by GameWorldProvider.void(),
  Keyed by context,
  KoinComponent,
  Listener,
  System,
  LoggerHolder,
  PluginAware {
  /** The key to this coroutine context element. */
  public companion object ContextKey : CoroutineContext.Key<GameInstance<*>>

  override lateinit var world: GameWorld<T>
  override val logger: Logger = LoggerFactory.getLogger(id)

  /** Whether this instance should be ticking. */
  public var shouldBeTicking: Boolean = true

  override fun audiences(): Iterable<Audience> {
    return setOf(context.audience)
  }

  override fun displayTick(tick: Int, displayTick: Int) {
  }

  /** Initialises this game instance. */
  public open suspend fun initialize() {
    logger.info("Initialising")
  }

  /** Stops this game instance. */
  public open suspend fun stop() {
  }

  internal open suspend fun tickInternal(startTick: Int, tick: Int) {
    if (!shouldBeTicking) {
      return
    }

    tick(startTick, tick)
  }

  /** Adds this instance to the tracker. */
  public fun add() {
    plugin.getOrPut(::GameInstancesComponent).instances.add(this)
  }

  /** Removes this instance from the tracker. */
  public fun remove() {
    plugin.getOrPut(::GameInstancesComponent).instances.remove(this)
  }
}
