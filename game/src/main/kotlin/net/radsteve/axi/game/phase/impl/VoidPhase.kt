package net.radsteve.axi.game.phase.impl

import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.game.phase.GamePhase
import net.radsteve.axi.utility.AxiInternal

/** A phase that does nothing and marks the controller as empty. */
@AxiInternal
public class VoidPhase<T : GameInstance<T>>(
    /** The game instance. */
  instance: GameInstance<T>,
) : GamePhase<T>(instance)
