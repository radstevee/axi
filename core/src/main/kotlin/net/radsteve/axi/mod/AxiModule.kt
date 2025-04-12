package net.radsteve.axi.mod

import net.radsteve.axi.plugin.AxiPlugin
import org.koin.core.module.Module

/** Acts as the entrypoint for an axi module.
 *
 * Here, you can provide hooks for plugins
 * and their lifecycle phases and access its
 * module.
 *
 * Using an [AxiModule] is not required if
 * you do not need any hooks in your actual
 * module, you can just use it as a library
 * then.
 *
 * [AxiModule]s are loaded via SPI, requiring
 * you to add your implementation as a service
 * (**not** Bukkit services).
 * You can find a guide in the CONTRIBUTING.md
 * on how to do that.*/
public interface AxiModule {
  /** Sets up the koin module for this plugin. */
  public suspend fun Module.module(plugin: AxiPlugin) {}

  /** Called from [org.bukkit.plugin.java.JavaPlugin.onLoad]. */
  public suspend fun load(plugin: AxiPlugin) {}

  /** Called from [org.bukkit.plugin.java.JavaPlugin.onEnable]. */
  public suspend fun enable(plugin: AxiPlugin) {}

  /** Called from [org.bukkit.plugin.java.JavaPlugin.onDisable]. */
  public suspend fun disable(plugin: AxiPlugin) {}
}
