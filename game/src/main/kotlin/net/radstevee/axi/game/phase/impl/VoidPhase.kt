package net.radstevee.axi.game.phase.impl

import net.radstevee.axi.game.instance.GameInstance
import net.radstevee.axi.game.phase.GamePhase
import net.radstevee.axi.utility.AxiInternal

/** A phase that does nothing and marks the controller as empty. */
@AxiInternal
public class VoidPhase<T : GameInstance<T>>(
  /** The game instance. */
  instance: GameInstance<T>
) : GamePhase<T>(instance)
