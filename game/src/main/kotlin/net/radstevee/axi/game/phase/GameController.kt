@file:OptIn(AxiInternal::class)

package net.radstevee.axi.game.phase

import net.radstevee.axi.game.instance.GameInstance
import net.radstevee.axi.game.phase.impl.VoidPhase
import net.radstevee.axi.utility.AxiInternal
import net.radstevee.axi.utility.players
import kotlin.time.Duration

/** A controller for game instance phases. */
public class GameController<T : GameInstance<T>>(
  /** The game instance. */
  public val instance: GameInstance<T>,
) {
  private var currentPhase: GamePhase<T> = VoidPhase<T>(instance)
  private var currentIdx: Int = -1
  private var totalTicksElapsed: Int = 0
  private val previousPhases: MutableList<GamePhase<T>> = mutableListOf()
  private val schedule: GameSchedule<T> = instance.schedule

  public suspend fun switch(
    phase: GamePhase<T>,
    duration: Duration? = null,
  ) {
    val previousPhase = currentPhase
    previousPhases.add(previousPhase)

    phase.duration = duration
    phase.tick = phase.durationTicks!!
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
      switch(phaseSupplier(), duration)
    }

    if (progressed) {
      return true
    }

    if (currentPhase !is VoidPhase<*>) {
      switch(VoidPhase<T>(instance))
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
}
