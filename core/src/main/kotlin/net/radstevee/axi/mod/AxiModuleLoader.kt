package net.radstevee.axi.mod

import net.radstevee.axi.plugin.AxiPlugin
import org.koin.core.module.Module
import java.util.ServiceLoader

/** Loads axi modules. */
public object AxiModuleLoader {
  private fun collectServices(plugin: AxiPlugin): Set<AxiModule> = ServiceLoader.load(AxiModule::class.java, plugin.javaClass.classLoader).toSet()

  /** Sets up the koin module for all axi modules. */
  public suspend fun Module.module(plugin: AxiPlugin) {
    collectServices(plugin).forEach { mod ->
      with(mod) {
        module(plugin)
      }
    }
  }

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
