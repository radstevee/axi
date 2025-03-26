package net.radstevee.axi.example

import net.radstevee.axi.ecs.Attachable
import net.radstevee.axi.ecs.get
import net.radstevee.axi.ecs.player
import net.radstevee.axi.ecs.system.System
import kotlin.reflect.KClass

object ExampleSystem : System {
  override val archetypes: Sequence<KClass<out Any>> = sequenceOf(TestComponent::class)

  override suspend fun tick(tick: Int, attachable: Attachable) {
    attachable.player?.sendMessage(attachable.get<TestComponent>()!!.message)
  }
}
