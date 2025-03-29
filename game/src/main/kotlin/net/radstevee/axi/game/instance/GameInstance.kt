package net.radstevee.axi.game.instance

import kotlinx.coroutines.CoroutineScope
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.audience.ForwardingAudience
import net.kyori.adventure.key.Keyed
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.Component.text
import net.radstevee.axi.coroutines.AxiCoroutines.coroutineScope
import net.radstevee.axi.ecs.Attachable
import net.radstevee.axi.ecs.getOrPut
import net.radstevee.axi.ecs.system.System
import net.radstevee.axi.game.phase.GameController
import net.radstevee.axi.game.phase.GameSchedule
import net.radstevee.axi.game.phase.GameSchedule.Companion.buildSchedule
import net.radstevee.axi.game.utility.Identified
import net.radstevee.axi.game.utility.LoggerHolder
import net.radstevee.axi.game.utility.PluginAware
import net.radstevee.axi.game.world.GameWorld
import net.radstevee.axi.game.world.GameWorldHolder
import net.radstevee.axi.game.world.GameWorldProvider
import net.radstevee.axi.tick.DisplayTickable
import net.radstevee.axi.tick.TickDuration.currentTick
import net.radstevee.axi.tick.Tickable
import net.radstevee.axi.utility.players
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.koin.core.component.KoinComponent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/** An instance of a game. */
public open class GameInstance<T : GameInstance<T>>(
  /** The context of this instance. */
  public open val context: GameContext,
) : AbstractCoroutineContextElement(ContextKey),
  ForwardingAudience,
  Tickable,
  DisplayTickable,
  CoroutineScope by coroutineScope,
  Attachable,
  System,
  KoinComponent,
  Keyed by context,
  Identified by context,
  GameWorldHolder<T>,
  GameWorldProvider<T> by GameWorldProvider.void(),
  Listener,
  LoggerHolder,
  PluginAware {
  /** The key to this coroutine context element. */
  public companion object ContextKey : CoroutineContext.Key<GameInstance<*>>

  override lateinit var world: GameWorld<T>
  override val logger: Logger = LoggerFactory.getLogger(id)

  /** Whether this instance should be ticking. */
  public var shouldBeTicking: Boolean = true

  /** Whether this instance has finished initialising. */
  public var initialized: Boolean = false

  /** When this instance has finished initialising. */
  public var tickInitialized: Int = context.startTick

  /** The game schedule of this instance. */
  public open val schedule: GameSchedule<T> = buildSchedule {}

  /** The game controller of this instance. */
  public open lateinit var controller: GameController<T>

  override fun audiences(): Iterable<Audience> {
    return setOf(context.audience)
  }

  override suspend fun displayTick(tick: Int, displayTick: Int) {
  }

  /** Gets the spawn location for the given [player]. */
  public open suspend fun spawnFor(player: Player): Location {
    return world.world.spawnLocation
  }

  /** Initialises a player for this game instance. */
  public open suspend fun initializePlayer(player: Player) {
    player.gameMode = GameMode.ADVENTURE
    player.teleport(spawnFor(player))
    player.closeInventory()
    displaySetup(player)
  }

  /** Initialises all players for this instance. */
  public open suspend fun initializePlayers() {
    players.forEach { player -> initializePlayer(player) }
  }

  /** Initialises this game instance. */
  public open suspend fun initialize() {
    logger.info("Initialising...")

    add()
    controller = GameController(this)
    world = gameWorld(this)
    initializePlayers()

    initialized = true
    tickInitialized = currentTick()

    logger.info("Initialised!")
  }

  /** Cleans up this game instance. */
  public open suspend fun cleanup() {
  }

  /** Stops this game instance. */
  public open suspend fun stop() {
    cleanup()
    world.unload()
  }

  /** Exits this game instance with the given [reason]. */
  public open fun exit(reason: String): Nothing {
    return exit(text(reason))
  }

  /** Exits this game instance with the given [reason]. */
  public open fun exit(reason: Component): Nothing {
    throw GameInstanceException(context, reason)
  }

  /** Adds this instance to the tracker. */
  public fun add() {
    plugin.getOrPut(::GameInstancesComponent).instances.add(this)
  }

  /** Removes this instance from the tracker. */
  public fun remove() {
    plugin.getOrPut(::GameInstancesComponent).instances.remove(this)
  }

  /** Sets up displays for the given [player]. */
  public open suspend fun displaySetup(player: Player) {
  }

  /** Whether this instance is finishing and should be removed. */
  public open suspend fun finishing(): Boolean {
    return controller.empty()
  }
}
