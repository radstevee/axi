package net.radsteve.axi.game.instance

import kotlinx.coroutines.CoroutineScope
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.audience.ForwardingAudience
import net.kyori.adventure.key.Keyed
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.Component.text
import net.radsteve.axi.coroutines.AxiCoroutines.coroutineScope
import net.radsteve.axi.ecs.Attachable
import net.radsteve.axi.ecs.getOrPut
import net.radsteve.axi.ecs.system.System
import net.radsteve.axi.event.Handleable
import net.radsteve.axi.event.callEvent
import net.radsteve.axi.game.instance.event.GameInstanceInitializeEvent
import net.radsteve.axi.game.instance.event.GameInstanceLifecycleEvent
import net.radsteve.axi.game.instance.event.GameInstanceStoppedEvent
import net.radsteve.axi.game.phase.GameController
import net.radsteve.axi.game.phase.GameSchedule
import net.radsteve.axi.game.phase.GameSchedule.Companion.buildSchedule
import net.radsteve.axi.game.world.GameWorld
import net.radsteve.axi.game.world.GameWorldHolder
import net.radsteve.axi.game.world.GameWorldProvider
import net.radsteve.axi.tick.DisplayTickable
import net.radsteve.axi.tick.TickDuration.currentTick
import net.radsteve.axi.tick.Tickable
import net.radsteve.axi.utility.Identified
import net.radsteve.axi.utility.LoggerHolder
import net.radsteve.axi.utility.PluginAware
import net.radsteve.axi.utility.observableMutableLazy
import net.radsteve.axi.utility.players
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.entity.Player
import org.koin.core.component.KoinComponent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/** An instance of a game. */
public open class GameInstance<T : GameInstance<T>>(
  /** The context of this instance. */
  public open val context: GameContext<T>,
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
  LoggerHolder,
  PluginAware,
  Handleable {
  /** The key to this coroutine context element. */
  public companion object ContextKey : CoroutineContext.Key<GameInstance<*>>

  /** The initial world of this game instance. */
  public lateinit var initialWorld: GameWorld<T>

  /** The world of this game instance. This is first set to [initialWorld] but is changed by phases. */
  override var world: GameWorld<T> by observableMutableLazy(
    initializer = { initialWorld },
    observer = { old, new -> controller.oldWorlds.add(old) },
  )

  override val logger: Logger = LoggerFactory.getLogger(id)

  /** Whether this instance should be ticking. */
  public var shouldBeTicking: Boolean = true

  /** Whether this instance has finished initialising. */
  public var initialized: Boolean = false

  /** When this instance has finished initialising. */
  public var tickInitialized: Int = context.startTick

  /** The game schedule of this instance. */
  public open val schedule: GameSchedule<T> = buildSchedule()

  /** The game controller of this instance. */
  public lateinit var controller: GameController<T>

  /** The lifecycle phase of this instance. */
  public lateinit var lifecyclePhase: GameLifecycle
    private set

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
    initialWorld = gameWorld(this)
    initializePlayers()

    initialized = true
    tickInitialized = currentTick()

    logger.info("Initialised!")
  }

  /** Cleans up this game instance. */
  public open suspend fun cleanup() {
    controller.unloadWorlds()
  }

  /** Stops this game instance. */
  public open suspend fun stop() {
    players.forEach { player ->
      // Teleport the player to the main world's spawn location if it exists.
      Bukkit.getWorld("world")?.spawnLocation?.let(player::teleport)
    }
  }

  /** Exits this game instance with the given [reason]. */
  public open fun exit(reason: String): Nothing {
    return exit(text(reason))
  }

  /** Exits this game instance with the given [reason]. */
  public open fun exit(reason: Component): Nothing {
    throw GameInstanceException(context, reason)
  }

  /** Adds this instance to the tracker and calls the [net.radsteve.axi.game.instance.event.GameInstanceInitializeEvent]. */
  public suspend fun add() {
    callEvent(GameInstanceInitializeEvent(this))

    plugin.getOrPut(::GameInstancesComponent).instances.add(this)
  }

  /** Removes this instance from the tracker and calls the [net.radsteve.axi.game.instance.event.GameInstanceStoppedEvent]. */
  public suspend fun remove() {
    callEvent(GameInstanceStoppedEvent(this))

    plugin.getOrPut(::GameInstancesComponent).instances.remove(this)
  }

  /** Sets up displays for the given [player]. */
  public open suspend fun displaySetup(player: Player) {
  }

  /** Whether this instance is finishing and should be removed. */
  public open suspend fun finishing(): Boolean {
    return controller.empty()
  }

  /** Called when the lifecycle of this instance progresses. */
  public open suspend fun lifecycleProgress(old: GameLifecycle, new: GameLifecycle) {
    callEvent(GameInstanceLifecycleEvent(old, new, this))

    when (new) {
      GameLifecycle.Initializing -> initialize()
      GameLifecycle.Stopping -> stop()
      GameLifecycle.Ended -> remove()
      GameLifecycle.Running -> initialized = true
      GameLifecycle.Cleanup -> cleanup()
    }
  }

  /** Switches the lifecycle phase to the given [phase] and calls its handlers. */
  public suspend fun switchLifecycle(phase: GameLifecycle) {
    val old = lifecyclePhase
    lifecyclePhase = phase
    lifecycleProgress(old, phase)
  }

  override fun equals(other: Any?): Boolean {
    other as GameInstance<*>
    return other.context.uuid == context.uuid
  }

  override fun hashCode(): Int {
    var result = shouldBeTicking.hashCode()
    result = 31 * result + initialized.hashCode()
    result = 31 * result + tickInitialized
    result = 31 * result + context.hashCode()
    result = 31 * result + world.hashCode()
    result = 31 * result + logger.hashCode()
    result = 31 * result + schedule.hashCode()
    result = 31 * result + controller.hashCode()
    result = 31 * result + lifecyclePhase.hashCode()
    return result
  }
}
