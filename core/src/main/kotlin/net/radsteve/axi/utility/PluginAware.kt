package net.radsteve.axi.utility

import net.radsteve.axi.plugin.AxiPlugin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

/** Represents a koin component tied to a plugin. */
public interface PluginAware : KoinComponent {
  /** The plugin. */
  public val plugin: AxiPlugin get() = get()
}
