package net.radstevee.axi.ecs.system

import net.radstevee.axi.ecs.Attachable
import net.radstevee.axi.ecs.getOrPut
import net.radstevee.axi.ecs.internal.SystemsComponent
import net.radstevee.axi.plugin.AxiPlugin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.reflect.KClass

/** An ECS system. */
public interface System : KoinComponent {
  /** The archetypes this system filters entities for. */
  public val archetypes: Sequence<KClass<out Any>>
    get() = emptySequence()

  /** Adds this system to the tick loop. */
  public fun start() {
    val plugin by inject<AxiPlugin>()
    plugin.getOrPut(::SystemsComponent).systems.add(this)
  }

  /** Removes this system from the tick loop. */
  public fun stop() {
    val plugin by inject<AxiPlugin>()
    plugin.getOrPut(::SystemsComponent).systems.remove(this)
  }

  /** Ticks this system for an attachable matching the [archetypes]. */
  public suspend fun tick(tick: Int, attachable: Attachable) {}
}
