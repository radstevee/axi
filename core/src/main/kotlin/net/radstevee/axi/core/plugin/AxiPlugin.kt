package net.radstevee.axi.core.plugin

import kotlinx.coroutines.runBlocking
import net.radstevee.axi.core.command.CommandManager
import net.radstevee.axi.core.mod.AxiModuleLoader
import net.radstevee.axi.core.plugin.AxiPluginHolder.gracefully
import org.bukkit.plugin.java.JavaPlugin

/** An instance of a plugin using axi. */
public abstract class AxiPlugin : JavaPlugin() {
  /** This plugin's command manager. */
  public open lateinit var commandManager: CommandManager

  /** Called from [onEnable]. */
  public open suspend fun enable() {}

  /** Called from [onLoad]. */
  public open suspend fun load() {}

  /** Called from [onDisable]. */
  public open suspend fun disable() {}

  /** Initialises axi functions such as commands. */
  public open suspend fun initAxi() {
    AxiInitializer(this)
  }

  final override fun onEnable() {
    runBlocking {
      gracefully("enable") {
        AxiModuleLoader.enable(this@AxiPlugin)
        initAxi()
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
