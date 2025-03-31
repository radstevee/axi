package net.radsteve.axi.ui.text

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextColor.color
import net.radsteve.axi.DelegatingRegistry
import net.radsteve.axi.Registry

/** A registry of text colours, delegating to [AxiColors] */
public open class ColorRegistry : DelegatingRegistry<String, TextColor>(AxiColors) {
  /** Registers the given [color] for the given [named] color. */
  protected fun register(named: NamedTextColor, color: Int): TextColor {
    return register(named.toString(), color)
  }

  /** Registers the given [color] for the given [named] color. */
  protected fun register(named: NamedTextColor, color: TextColor): TextColor {
    return register(named.toString(), color)
  }

  /** Registers the given [color] under the given [id]. */
  protected fun register(id: String, color: Int): TextColor {
    return register(id, color(color))
  }

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

/** Gets a colour by the given [id]. */
public fun color(id: String): TextColor {
  val color = ColorRegistry[id] ?: NamedTextColor.NAMES.value(id)
  require(color != null) { "invalid color: $id - is it registered?" }

  return color
}
