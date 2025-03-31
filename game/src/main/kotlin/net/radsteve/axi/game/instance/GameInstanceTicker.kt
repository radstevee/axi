package net.radsteve.axi.game.instance

import net.radsteve.axi.ecs.Attachable
import net.radsteve.axi.ecs.get
import net.radsteve.axi.ecs.system.System
import kotlin.reflect.KClass

internal object GameInstanceTicker : System {
  override val archetypes: Sequence<KClass<out Any>> = sequenceOf(GameInstancesComponent::class)

  override suspend fun tick(tick: Int, attachable: Attachable) {
    val instances = attachable.get<GameInstancesComponent>()!!.instances

    instances.forEach { instance ->
      try {
        instance.controller.tick(tick - instance.context.startTick)
      } catch (exception: GameInstanceException) {
        instance.stop()
        instance.remove()
        exception.printStackTrace()
      }

      if (instance.finishing()) {
        instance.stop()
        instance.remove()
      }
    }
  }
}
