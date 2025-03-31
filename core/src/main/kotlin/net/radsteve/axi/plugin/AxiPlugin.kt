package net.radsteve.axi.plugin

import kotlinx.coroutines.runBlocking
import net.radsteve.axi.plugin.AxiPluginHolder.gracefully
import net.radsteve.axi.command.CommandManager
import net.radsteve.axi.ecs.Attachable
import net.radsteve.axi.mod.AxiModuleLoader
import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.component.KoinComponent
import org.koin.core.module.Module

/** An instance of a plugin using axi. */
public abstract class AxiPlugin :
  JavaPlugin(),
  KoinComponent,
  Attachable {
  /** This plugin's command manager. */
  public open lateinit var commandManager: CommandManager

  /** The koin module of this plugin. */
  public open lateinit var module: Module

  /** Called from [onEnable]. */
  public open suspend fun enable() {}

  /** Called from [onLoad]. */
  public open suspend fun load() {}

  /** Called from [onDisable]. */
  public open suspend fun disable() {}

  /** Initialises this plugin's koin module. */
  public open suspend fun Module.module() {}

  /** Initialises axi functions such as commands. */
  public open suspend fun initAxi() {
    AxiInitializer(this)
  }

  final override fun onEnable() {
    runBlocking {
      gracefully("enable") {
        initAxi()
        AxiModuleLoader.enable(this@AxiPlugin)
        enable()
      }
    }
  }

  final override fun onLoad() {
    runBlocking {
      gracefully("load") {
        AxiModuleLoader.load(this@AxiPlugin)
        load()
      }
    }
  }

  final override fun onDisable() {
    runBlocking {
      gracefully("disable") {
        AxiModuleLoader.disable(this@AxiPlugin)
        disable()
      }
    }
  }
}
