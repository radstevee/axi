package net.radstevee.axi.game.instance

import net.kyori.adventure.text.Component
import net.radstevee.axi.game.utility.FormattedException

/** An exception in game instances. */
public open class GameInstanceException(
  /** The context of the game instance. */
  public open val context: GameContext,
  /** The message that should be displayed. */
  message: Component,
) : FormattedException(message)
