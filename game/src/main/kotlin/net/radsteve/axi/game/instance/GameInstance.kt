package net.radsteve.axi.game.instance

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.audience.ForwardingAudience
import net.kyori.adventure.key.Keyed
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.Component.text
import net.radsteve.axi.coroutines.AxiCoroutines.syncContext
import net.radsteve.axi.displayname.axiTeleport
import net.radsteve.axi.ecs.Attachable
import net.radsteve.axi.ecs.getOrPut
import net.radsteve.axi.ecs.nonNullData
import net.radsteve.axi.ecs.observableNonNullLazyData
import net.radsteve.axi.ecs.set
import net.radsteve.axi.event.Handleable
import net.radsteve.axi.event.callEvent
import net.radsteve.axi.game.instance.event.GameInstanceInitializeEvent
import net.radsteve.axi.game.instance.event.GameInstanceLifecycleEvent
import net.radsteve.axi.game.instance.event.GameInstanceStoppedEvent
import net.radsteve.axi.game.phase.GameController
import net.radsteve.axi.game.phase.GameSchedule
import net.radsteve.axi.game.phase.GameSchedule.Companion.buildSchedule
import net.radsteve.axi.game.world.GameWorld
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
import kotlin.coroutines.CoroutineContext

/** An instance of a game. */
public open class GameInstance<T : GameInstance<T>>(
  /** The context of this instance. */
  public val context: GameContext<T>,
) : ForwardingAudience,
  Tickable,
  DisplayTickable,
  CoroutineScope,
  Attachable,
  KoinComponent,
  Keyed by context,
  Identified by context,
  GameWorldProvider by GameWorldProvider.void(),
  LoggerHolder,
  PluginAware,
  Handleable {
  /** The initial world of this game instance. */
  public lateinit var initialWorld: GameWorld

  /** The world of this game instance. This is first set to [initialWorld] but is changed by phases. */
  public var world: GameWorld by observableNonNullLazyData(
    initializer = { initialWorld },
    observer = { old, _ -> controller.oldWorlds.add(old) },
  )

  /** The logger of this game instance. */
  override var logger: Logger by nonNullData()

  /** Whether this instance should be ticking. */
  public var shouldBeTicking: Boolean = true

  /** Whether this instance has finished initialising. */
  public var initialized: Boolean = false

  /** When this instance has finished initialising. */
  public var tickInitialized: Int = context.startTick

  /** The game schedule of this instance. */
  public open val schedule: GameSchedule<T> by nonNullData(buildSchedule())

  /** The game controller of this instance. */
  public var controller: GameController<T> by nonNullData()

  /** The lifecycle phase of this instance. */
  public var lifecyclePhase: GameLifecycle by nonNullData(GameLifecycle.Idling)
    private set

  override fun audiences(): Iterable<Audience> {
    return setOf(context.audience)
  }

  override suspend fun displayTick(tick: Int, displayTick: Int) {
  }

  override suspend fun tick(startTick: Int, tick: Int) {
  }

  /** Gets the spawn location for the given [player]. */
  public open suspend fun spawnFor(player: Player): Location {
    return world.world.spawnLocation
  }

  /** Initialises a player for this game instance. */
  public open suspend fun initializePlayer(player: Player) {
    player.gameMode = GameMode.ADVENTURE
    player.axiTeleport(spawnFor(player))
    player.closeInventory()
    displaySetup(player)
  }

  /** Initialises all players for this instance. */
  public open suspend fun initializePlayers() {
    players.forEach { player -> initializePlayer(player) }
  }

  /** Initialises this game instance. */
  public open suspend fun initialize() {
    logger = LoggerFactory.getLogger(id)
    logger.info("Initialising...")

    // Reset the schedule component back to the schedule
    set(schedule)
    controller = GameController(this)
    add()
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
      Bukkit.getWorld("world")?.spawnLocation?.let(player::axiTeleport)
    }
  }

  /** Exits this game instance with the given [reason]. */
  public open fun exit(reason: String): Nothing {
    exit(text(reason))
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
  protected open suspend fun progressLifecycleState(old: GameLifecycle, new: GameLifecycle) {
    callEvent(GameInstanceLifecycleEvent(old, new, this))

    when (new) {
      GameLifecycle.Initializing -> initialize()
      GameLifecycle.Stopping -> stop()
      GameLifecycle.Ended -> remove()
      GameLifecycle.Running -> initialized = true
      GameLifecycle.Cleanup -> cleanup()
      GameLifecycle.Idling -> {}
    }
  }

  /** Switches the lifecycle phase to the given [phase] and calls its handlers. */
  public suspend fun switchLifecycle(phase: GameLifecycle) {
    val old = lifecyclePhase
    lifecyclePhase = phase
    progressLifecycleState(old, phase)
  }

  override fun equals(other: Any?): Boolean {
    other as GameInstance<*>
    return other.context.uuid == context.uuid
  }

  override fun hashCode(): Int {
    return 31 * context.hashCode()
  }

  override val coroutineContext: CoroutineContext by lazy {
    // Use the sync context without its already existing exception handlers.
    syncContext.fold(GameInstanceExceptionHandler(this) as CoroutineContext) { acc, elem ->
      if (elem.key == CoroutineExceptionHandler) {
        acc
      } else {
        acc + elem
      }
    }
  }
  override val coroutineScope: CoroutineScope by lazy { CoroutineScope(coroutineContext) }
}
