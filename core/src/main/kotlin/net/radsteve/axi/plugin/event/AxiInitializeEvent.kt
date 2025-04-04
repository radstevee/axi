package net.radsteve.axi.plugin.event

import net.radsteve.axi.mod.AxiModule
import net.radsteve.axi.plugin.AxiPlugin
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/** Gets called when an axi plugin initializes. */
public class AxiInitializeEvent(
  /** The plugin. */
  public val plugin: AxiPlugin,
  /** The modules that were loaded. */
  public val loadedModules: Set<AxiModule>,
) : Event() {
  override fun getHandlers(): HandlerList = HANDLER_LIST

  public companion object {
    @JvmStatic
    private val HANDLER_LIST: HandlerList = HandlerList()

    @JvmStatic
    internal fun getHandlerList(): HandlerList = HANDLER_LIST
  }
}
