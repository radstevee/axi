package net.radsteve.axi.game.instance

import net.radsteve.axi.ecs.getOrPut
import net.radsteve.axi.event.Handleable
import net.radsteve.axi.game.instance.event.GameInstanceInitializeEvent
import net.radsteve.axi.game.instance.event.GameInstancePhaseChangeEvent
import net.radsteve.axi.game.instance.event.GameInstanceStoppedEvent
import net.radsteve.axi.utility.PluginAware
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import java.util.UUID

/** Controls handling of game instances. */
public object GameInstanceController : PluginAware, Listener {
  internal val cachedHandleables: MutableSet<Handleable> = mutableSetOf()

  @EventHandler
  private fun on(event: GameInstanceInitializeEvent<*>) {
    cachedHandleables.add(event.instance)
    cachedHandleables.add(event.instance.controller.currentPhase)
  }

  @EventHandler
  private fun on(event: GameInstanceStoppedEvent<*>) {
    cachedHandleables.remove(event.instance)
    cachedHandleables.remove(event.instance.controller.currentPhase)
  }

  @EventHandler
  private fun on(event: GameInstancePhaseChangeEvent<*>) {
    cachedHandleables.remove(event.old)
    cachedHandleables.add(event.new)
  }

  /** Collects all game instances. */
  public fun collect(): Set<GameInstance<*>> {
    return plugin.getOrPut(::GameInstancesComponent).instances
  }

  /** Creates a game instance of the given [context]. */
  public suspend fun <T : GameInstance<T>> create(context: GameContext<T>): T {
    val instance = context.type.factory.createInstance(context)

    try {
      instance.switchLifecycle(GameLifecycle.Initializing)
    } catch (exception: Throwable) {
      instance.switchLifecycle(GameLifecycle.Ended)
      val gameException = exception as? GameInstanceException ?: GameInstanceException.Companion.subException(context, exception)
      gameException.printStackTrace()

      throw gameException
    }

    instance.switchLifecycle(GameLifecycle.Running)

    @Suppress("UNCHECKED_CAST")
    return instance as T
  }

  /** Searches for an instance with the given [uuid] and gracefully stops it. */
  public suspend fun stop(uuid: UUID) {
    val instance = collect().find { instance -> instance.uuid == uuid } ?: return
    stop(instance)
  }

  /** Gracefully stops the given [instance]. */
  public suspend fun <T : GameInstance<T>> stop(instance: GameInstance<T>) {
    instance.switchLifecycle(GameLifecycle.Cleanup)
    instance.switchLifecycle(GameLifecycle.Stopping)
    instance.switchLifecycle(GameLifecycle.Ended)
  }
}
