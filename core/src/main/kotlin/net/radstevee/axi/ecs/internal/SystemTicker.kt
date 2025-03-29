package net.radstevee.axi.ecs.internal

import com.destroystokyo.paper.event.server.ServerTickEndEvent
import net.radstevee.axi.ecs.ECS
import net.radstevee.axi.ecs.get
import net.radstevee.axi.ecs.getOrPut
import net.radstevee.axi.plugin.AxiPlugin
import net.radstevee.axi.plugin.event.SuspendingListener
import org.bukkit.event.EventHandler
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal object SystemTicker : SuspendingListener, KoinComponent {
  private val plugin: AxiPlugin by inject()
  private val ecs: ECSImpl by inject()

  @EventHandler
  private suspend fun on(event: ServerTickEndEvent) {
    val systems = plugin.getOrPut(::SystemsComponent)
    val entities = ECS.entities()

    entities.forEach { entity ->
      systems.systems.forEach { system ->
        val applicable = system.archetypes.all { klass ->
          ecs.data[entity]?.any { component -> component.klass == klass } == true
        }

        if (!applicable) {
          return@forEach
        }

        system.tick(event.tickNumber, entity)
      }
    }
  }
}
