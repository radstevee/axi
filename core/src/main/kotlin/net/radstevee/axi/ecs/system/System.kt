package net.radstevee.axi.ecs.system

import net.radstevee.axi.ecs.Attachable
import net.radstevee.axi.ecs.getOrPut
import net.radstevee.axi.ecs.internal.SystemsComponent
import net.radstevee.axi.plugin.AxiPlugin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.reflect.KClass

public interface System : KoinComponent {
  public val archetypes: Sequence<KClass<out Any>>
    get() = emptySequence()

  public fun start() {
    val plugin by inject<AxiPlugin>()
    plugin.getOrPut(::SystemsComponent).systems.add(this)
  }

  public fun stop() {
    val plugin by inject<AxiPlugin>()
    plugin.getOrPut(::SystemsComponent).systems.remove(this)
  }

  public suspend fun tick(tick: Int, attachable: Attachable) {}
}
