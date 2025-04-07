package net.radsteve.axi.ecs.internal

import com.destroystokyo.paper.event.server.ServerTickEndEvent
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
    val systems = plugin.getOrPut(::SystemsComponent).systems.iterator()
    val entities = ecs.entities().iterator()

    try {
      while (entities.hasNext()) {
        val entity = entities.next()

        while (systems.hasNext()) {
          val system = systems.next()
          val applicable = system.archetypes.all { klass ->
            ecs.data[entity]?.any { component -> component.klass == klass } == true
          }

          if (applicable) {
            system.tick(event.tickNumber, entity)
          }
        }
      }
    } catch (exception: Exception) {
      plugin.slF4JLogger.error("failed to tick systems", exception)
    }
  }
}
