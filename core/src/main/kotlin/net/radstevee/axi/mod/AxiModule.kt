package net.radstevee.axi.mod

import net.radstevee.axi.plugin.AxiPlugin
import org.koin.core.module.Module

/** A module for axi. */
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
