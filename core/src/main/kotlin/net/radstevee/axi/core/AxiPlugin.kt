package net.radstevee.axi.core

import kotlinx.coroutines.runBlocking
import net.radstevee.axi.core.internal.AxiPluginHolder.gracefully
import org.bukkit.plugin.java.JavaPlugin

/** An instance of a plugin using axi. */
public abstract class AxiPlugin : JavaPlugin() {
    public open suspend fun enable() {}
    public open suspend fun load() {}
    public open suspend fun disable() {}

    final override fun onEnable() {
        runBlocking {
            gracefully {
                enable()
            }
        }
    }

    final override fun onLoad() {
        runBlocking {
            gracefully {
                load()
            }
        }
    }

    final override fun onDisable() {
        runBlocking {
            gracefully {
                disable()
            }
        }
    }
}
