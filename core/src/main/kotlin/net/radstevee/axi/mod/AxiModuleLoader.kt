package net.radstevee.axi.mod

import net.radstevee.axi.plugin.AxiPlugin
import java.util.ServiceLoader

/** Loads axi modules. */
public object AxiModuleLoader {
  private fun collectServices(plugin: AxiPlugin): Set<AxiModule> = ServiceLoader.load(AxiModule::class.java, plugin.javaClass.classLoader).toSet()

  /** Loads all axi modules. */
  public suspend fun load(plugin: AxiPlugin) {
    collectServices(plugin).forEach { mod ->
      mod.load(plugin)
    }
  }

  /** Enables all axi modules. */
  public suspend fun enable(plugin: AxiPlugin) {
    collectServices(plugin).forEach { mod ->
      mod.enable(plugin)
    }
  }

  /** Disables all axi modules. */
  public suspend fun disable(plugin: AxiPlugin) {
    collectServices(plugin).forEach { mod ->
      mod.disable(plugin)
    }
  }
}
