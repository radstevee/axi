package net.radstevee.axi.game.instance

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.Component.text
import net.radstevee.axi.utility.FormattedException

/** An exception in game instances. */
public open class GameInstanceException(
  /** The context of the game instance. */
  public open val context: GameContext<*>,
  /** The message that should be displayed. */
  message: Component,
  /** The sub exception of this exception. */
  override val cause: Throwable? = null,
) : FormattedException(message) {
  public companion object {
    /** Creates a sub exception from the [other] exception. */
    public fun subException(context: GameContext<*>, other: Throwable): GameInstanceException {
      return GameInstanceException(
        context,
        text("${other.javaClass.simpleName}: ${other.message}"),
        other,
      ).apply {
        stackTrace = other.stackTrace
      }
    }
  }
}
