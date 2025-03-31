package net.radsteve.axi.ecs.internal

import com.destroystokyo.paper.event.server.ServerTickEndEvent
import net.radsteve.axi.ecs.ECS
import net.radsteve.axi.ecs.getOrPut
import net.radsteve.axi.event.SuspendingListener
import net.radsteve.axi.utility.PluginAware
import org.bukkit.event.EventHandler
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal object SystemTicker : SuspendingListener, KoinComponent, PluginAware {
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
