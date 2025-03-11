package net.radstevee.axi.ui.text

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.radstevee.axi.core.DelegatingRegistry
import net.radstevee.axi.core.Registry

/** A registry of text colours, delegating to [AxiColors] */
public class ColorRegistry : DelegatingRegistry<String, TextColor>(AxiColors) {
  /** Delegating text color registry. */
  public companion object AxiColors : Registry<String, TextColor>(modifiable = true) {
    init {
      // By default, we use vanilla colors.
      NamedTextColor.NAMES.keyToValue().forEach { (id, color) ->
        register(id.lowercase(), color)
      }
    }
  }
}
