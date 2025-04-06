package net.radsteve.axi.game.instance

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.NamedTextColor.RED
import net.radsteve.axi.event.CurrentlyCalledEvent
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/** An exception handler that stops a game instance on an unhandled exception. */
public class GameInstanceExceptionHandler<T : GameInstance<T>>(
  /** The instance. */
  private val instance: GameInstance<T>,
) : AbstractCoroutineContextElement(Key),
  CoroutineExceptionHandler {
  override fun handleException(context: CoroutineContext, exception: Throwable) {
    val currentEvent = context[CurrentlyCalledEvent]
    if (currentEvent == null) {
      instance.logger.error("Unhandled exception in game instance ${instance.id}", exception)
    } else {
      instance.logger.error(
        "Unhandled exception in game instance ${instance.id} whilst executing" +
          "${currentEvent.eventKlass.simpleName}",
        exception,
      )
    }

    val isRecoverable = exception is IllegalStateException ||
      exception is IllegalArgumentException ||
      exception is NullPointerException ||
      exception is UnsupportedOperationException ||
      exception is IndexOutOfBoundsException ||
      exception is ConcurrentModificationException ||
      exception is NoSuchElementException

    if (isRecoverable) {
      return
    }

    instance.sendMessage(
      text()
        .append(text("The game instance you were in has stopped due to an internal error."))
        .appendSpace()
        .append(text("Please contact an Administrator."))
        .color(RED),
    )

    CoroutineScope(context).launch {
      try {
        GameInstanceController.stop(instance)
      } catch (exception: Exception) {
        // In case it failed stopping, we kill it. This doesn't handle
        // cleaning up of any resources like worlds but this should not happen.
        instance.logger.error("Failed stopping game instance ${instance.id}", exception)
        instance.switchLifecycle(GameLifecycle.Ended)
      }
    }
  }

  private companion object Key : CoroutineContext.Key<GameInstanceExceptionHandler<*>>
}
