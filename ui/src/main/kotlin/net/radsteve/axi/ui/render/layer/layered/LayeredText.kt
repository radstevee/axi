package net.radsteve.axi.ui.render.layer.layered

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.radsteve.axi.ui.AxiUI
import net.radsteve.axi.ui.text.TextBuilder
import net.radsteve.axi.ui.text.buildText
import net.radsteve.axi.ui.text.width
import net.radsteve.axi.ui.theme.Theme
import kotlin.math.roundToInt

/** A builder for layered text. */
public class LayeredTextBuilder(
  /** The theme of this builder. */
  public val theme: Theme = AxiUI.theme,
) {
  /** The contained layers of text. */
  public val layers: MutableList<TextComponent> = mutableListOf()

  /** Appends [component] with the given [offset]. */
  public fun appendWithOffset(offset: Int, component: Component) {
    append {
      appendWithOffset(offset, component)
    }
  }

  /** Builds a text component from the given [block] and appends it with the given [offset]. */
  public inline fun appendWithOffset(offset: Int, theme: Theme = this.theme, block: TextBuilder.() -> Unit) {
    append {
      appendWithOffset(offset, theme, block)
    }
  }

  /** Builds a text component from the given [block] and appends it. */
  public inline fun append(theme: Theme = this.theme, block: TextBuilder.() -> Unit) {
    layers.add(buildText(theme, false, block))
  }

  /** Appends a text component layer. */
  public fun append(component: TextComponent): Boolean = layers.add(component)
}

/** Builds a layered text component. */
public fun buildLayeredText(
  theme: Theme = AxiUI.theme,
  block: LayeredTextBuilder.() -> Unit,
): TextComponent {
  val layeredBuilder = LayeredTextBuilder(theme).apply(block)
  val layers = layeredBuilder.layers

  return buildLayeredText(layers = layers)
}

/** Builds a layered text. */
public fun buildLayeredText(
  centred: Boolean = true,
  roundWidthCalculation: Boolean = false,
  layers: List<TextComponent>,
): TextComponent {
  if (layers.isEmpty()) {
    return buildText()
  }
  if (layers.size == 1) {
    return layers.first()
  }

  val widthCalculation: (Component) -> Int = if (roundWidthCalculation) {
    { component ->
      (component.width() / 2.0f).roundToInt()
    }
  } else {
    { component ->
      component.width() / 2
    }
  }

  return buildText {
    val text = buildText {
      layers.forEach { layer ->
        appendWithOffset(
          if (centred) {
            -widthCalculation(layer)
          } else {
            0
          } - width(),
          layer,
        )
      }
    }

    appendWithOffset(
      if (centred) {
        widthCalculation(text)
      } else {
        0
      },
      text,
    )
  }
}
