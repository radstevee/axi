package net.radsteve.axi.ecs.system

import net.radsteve.axi.ecs.Attachable
import net.radsteve.axi.ecs.getOrPut
import net.radsteve.axi.ecs.internal.SystemsComponent
import net.radsteve.axi.plugin.AxiPlugin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.reflect.KClass

/** An ECS system. */
public interface System : KoinComponent {
  /** The archetypes this system filters entities for. */
  public val archetypes: Sequence<KClass<out Any>>
    get() = emptySequence()

  /** Adds this system to the tick loop. */
  public fun startTicking() {
    val plugin by inject<AxiPlugin>()
    plugin.getOrPut(::SystemsComponent).systems.add(this)
  }

  /** Removes this system from the tick loop. */
  public fun stopTicking() {
    val plugin by inject<AxiPlugin>()
    plugin.getOrPut(::SystemsComponent).systems.remove(this)
  }

  /** Ticks this system for an attachable matching the [archetypes]. */
  public suspend fun tick(tick: Int, attachable: Attachable) {}
}
