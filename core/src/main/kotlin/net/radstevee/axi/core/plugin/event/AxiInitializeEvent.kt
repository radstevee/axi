package net.radstevee.axi.core.plugin.event

import net.radstevee.axi.core.plugin.AxiPlugin
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/** Gets called when an axi plugin initializes. */
public class AxiInitializeEvent(
  /** The plugin. */
  public val plugin: AxiPlugin,
) : Event() {
  override fun getHandlers(): HandlerList = HANDLER_LIST

  public companion object {
    @JvmStatic
    private val HANDLER_LIST: HandlerList = HandlerList()

    @JvmStatic
    internal fun getHandlerList(): HandlerList {
      return HANDLER_LIST
    }
  }
}
