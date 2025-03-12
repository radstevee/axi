package net.radstevee.axi.ui.render.layer.layered

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.radstevee.axi.ui.text.TextBuilder
import net.radstevee.axi.ui.text.buildText
import net.radstevee.axi.ui.text.width
import kotlin.math.roundToInt

/** A builder for layered text. */
public class LayeredTextBuilder {
  /** The contained layers of text. */
  public val layers: MutableList<TextComponent> = mutableListOf()

  /** Appends [component] with the given [offset]. */
  public fun appendWithOffset(offset: Int, component: Component): Boolean = append {
    appendWithOffset(offset, component)
  }

  /** Builds a text component from the given [block] and appends it with the given [offset]. */
  public inline fun appendWithOffset(offset: Int, block: TextBuilder.() -> Unit): Boolean = append {
    appendWithOffset(offset, block)
  }

  /** Builds a text component from the given [block] and appends it. */
  public inline fun append(block: TextBuilder.() -> Unit): Boolean = layers.add(buildText(block))

  /** Appends a text component layer. */
  public fun append(component: TextComponent): Boolean = layers.add(component)
}

/** Builds a layered text component. */
public fun buildLayeredText(
  block: LayeredTextBuilder.() -> Unit,
): TextComponent {
  val layeredBuilder = LayeredTextBuilder().apply(block)
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
          layer
        )
      }
    }

    appendWithOffset(
      if (centred) {
        widthCalculation(text)
      } else {
        0
      },
      text
    )
  }
}
