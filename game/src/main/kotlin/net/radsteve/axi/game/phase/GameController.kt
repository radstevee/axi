@file:OptIn(AxiInternal::class)

package net.radsteve.axi.game.phase

import net.radsteve.axi.event.callCancellable
import net.radsteve.axi.event.callEvent
import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.game.instance.event.GameInstancePhaseChangeEvent
import net.radsteve.axi.game.phase.impl.VoidPhase
import net.radsteve.axi.game.world.GameWorld
import net.radsteve.axi.utility.AxiInternal
import net.radsteve.axi.utility.players
import org.bukkit.Bukkit
import kotlin.time.Duration

/** A controller for game instance phases. */
public class GameController<T : GameInstance<T>>(
  /** The game instance. */
  public val instance: GameInstance<T>,
) {
  /** The current phase of the game instance. */
  public var currentPhase: GamePhase<T> = VoidPhase(instance)
    private set
  private var currentIdx: Int = -1
  private var totalTicksElapsed: Int = 0
  private val previousPhases: MutableList<GamePhase<T>> = mutableListOf()
  private val schedule: GameSchedule<T> = instance.schedule
  internal val oldWorlds: MutableSet<GameWorld> = mutableSetOf()

  /** Switches the current phase to the given [phase]. */
  public suspend fun switch(
    phase: GamePhase<T>,
    duration: Duration? = null,
  ) {
    val previousPhase = currentPhase
    if (callCancellable(GameInstancePhaseChangeEvent(previousPhase, phase, instance))) {
      return
    }
    previousPhases.add(previousPhase)

    phase.duration = duration
    phase.tick = phase.durationTicks ?: -1
    phase.tickInitialized = totalTicksElapsed

    currentPhase = phase
    currentIdx++

    previousPhase.end()

    phase.start()

    instance.players.forEach { player ->
      phase.displaySetup(player)
    }
  }

  /** Goes to the next state and returns whether it progressed. */
  public suspend fun next(): Boolean {
    val progressed = schedule.accept { (phaseSupplier, _, duration) ->
      @Suppress("UNCHECKED_CAST")
      switch(phaseSupplier(instance as T), duration)
    }

    if (progressed) {
      return true
    }

    if (currentPhase !is VoidPhase<*>) {
      switch(VoidPhase(instance))
    }

    return false
  }

  /** Ticks the game controller. */
  public suspend fun tick(tick: Int) {
    if (!instance.shouldBeTicking) {
      return
    }

    if (currentPhase is VoidPhase<*>) {
      if (!next()) {
        return
      }
    }

    if (currentPhase.tick == 0 || currentPhase.ending()) {
      next()
      return
    }

    currentPhase.tick(currentPhase.tickInitialized, tick - currentPhase.tickInitialized)
    currentPhase.tick--

    totalTicksElapsed++
  }

  /** Checks whether this game controller is empty and finished. */
  public fun empty(): Boolean {
    return currentPhase is VoidPhase<*> || schedule.empty()
  }

  /** Unloads the old worlds of this controller. */
  public fun unloadWorlds() {
    oldWorlds
      .plus(instance.world)
      .filter(GameWorld::isTemporary)
      .forEach { world -> Bukkit.unloadWorld(world.world, false) }
  }
}
