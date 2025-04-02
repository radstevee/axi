package net.radsteve.axi.game.instance

import net.radsteve.axi.ecs.getOrPut
import net.radsteve.axi.tick.Tickable
import net.radsteve.axi.utility.PluginAware

/** Controls handling of game instances. */
public object GameInstanceController : PluginAware {
  /** Collects all game instances. */
  public fun collect(): Set<GameInstance<*>> {
    return plugin.getOrPut(::GameInstancesComponent).instances
  }

  /** Creates a game instance of the given [context]. */
  public suspend fun <T : GameInstance<T>> create(context: GameContext<T>): GameInstance<T> {
    val instance = context.type.factory.createInstance(context)

    try {
      instance.switchLifecycle(GameLifecycle.Initializing)
    } catch (exception: Throwable) {
      instance.switchLifecycle(GameLifecycle.Ended)
      val exception = exception as? GameInstanceException ?: GameInstanceException.Companion.subException(context, exception)
      exception.printStackTrace()

      throw exception
    }

    instance.switchLifecycle(GameLifecycle.Running)

    return instance
  }

  /** Gracefully stops the given [instance]. */
  public suspend fun <T : GameInstance<T>> stop(instance: GameInstance<T>) {
    instance.switchLifecycle(GameLifecycle.Cleanup)
    instance.switchLifecycle(GameLifecycle.Stopping)
    instance.switchLifecycle(GameLifecycle.Ended)
  }
}
