package net.radsteve.axi.example

import net.radsteve.axi.ecs.Attachable
import net.radsteve.axi.ecs.get
import net.radsteve.axi.ecs.player
import net.radsteve.axi.ecs.system.System
import kotlin.reflect.KClass

public object ExampleSystem : System {
  override val archetypes: Sequence<KClass<out Any>> = sequenceOf(TestComponent::class)

  override suspend fun tick(tick: Int, attachable: Attachable) {
    attachable.player?.sendMessage(attachable.get<TestComponent>()!!.message)
  }
}
