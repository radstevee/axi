package net.radstevee.axi.game.instance

import net.radstevee.axi.ecs.Attachable
import net.radstevee.axi.ecs.get
import net.radstevee.axi.ecs.system.System
import kotlin.reflect.KClass

internal object GameInstanceTicker : System {
  override val archetypes: Sequence<KClass<out Any>> = sequenceOf(GameInstancesComponent::class)

  override suspend fun tick(tick: Int, attachable: Attachable) {
    val instances = attachable.get<GameInstancesComponent>()!!.instances

    instances.forEach { instance ->
      try {
        instance.tickInternal(instance.context.startTick, tick - instance.context.startTick)
      } catch (exception: GameInstanceException) {
        instance.stop()
        instance.remove()
        exception.printStackTrace()
      }
    }
  }
}
