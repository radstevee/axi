package net.radstevee.axi.ui.text

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.key.Key.key
import net.kyori.adventure.key.Keyed
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEventSource
import net.kyori.adventure.text.format.ShadowColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.format.TextDecoration.BOLD
import net.kyori.adventure.text.format.TextDecoration.ITALIC
import net.radstevee.axi.ui.resource.font.AxiFont
import net.radstevee.axi.ui.resource.pack.AxiPackRegistry.AxiPacks.negativeSpaces
import net.radstevee.axi.ui.text.color as getColor
import net.radstevee.packed.core.key.Key as PackedKey

/** A text component builder. */
public class TextBuilder {
  private val componentBuilder: TextComponent.Builder = Component.text()
  private var offset: Int? = null

  /** Sets this component color to the given color [id]. */
  public fun color(id: String, ifAbsent: Boolean) {
    if (ifAbsent) {
      componentBuilder.colorIfAbsent(getColor(id))
    } else {
      componentBuilder.color(getColor(id))
    }
  }

  /** Sets this component color to black. */
  public fun black(ifAbsent: Boolean = false) {
    color("black", ifAbsent)
  }

  /** Sets this component color to dark red. */
  public fun darkRed(ifAbsent: Boolean = false) {
    color("dark_red", ifAbsent)
  }

  /** Sets this component color to dark purple. */
  public fun darkPurple(ifAbsent: Boolean = false) {
    color("dark_purple", ifAbsent)
  }

  /** Sets this component color to gold. */
  public fun gold(ifAbsent: Boolean = false) {
    color("gold", ifAbsent)
  }

  /** Sets this component color to gray. */
  public fun gray(ifAbsent: Boolean = false) {
    color("gray", ifAbsent)
  }

  /** Sets this component color to dark gray. */
  public fun darkGray(ifAbsent: Boolean = false) {
    color("dark_gray", ifAbsent)
  }

  /** Sets this component color to blue. */
  public fun blue(ifAbsent: Boolean = false) {
    color("blue", ifAbsent)
  }

  /** Sets this component color to green. */
  public fun green(ifAbsent: Boolean = false) {
    color("green", ifAbsent)
  }

  /** Sets this component color to aqua. */
  public fun aqua(ifAbsent: Boolean = false) {
    color("aqua", ifAbsent)
  }

  /** Sets this component color to red. */
  public fun red(ifAbsent: Boolean = false) {
    color("red", ifAbsent)
  }

  /** Sets this component color to light purple. */
  public fun lightPurple(ifAbsent: Boolean = false) {
    color("light_purple", ifAbsent)
  }

  /** Sets this component color to yellow. */
  public fun yellow(ifAbsent: Boolean = false) {
    color("yellow", ifAbsent)
  }

  /** Sets this component color to white. */
  public fun white(ifAbsent: Boolean = false) {
    color("white", ifAbsent)
  }

  /** Appends a string to this component. */
  public fun append(text: String?) {
    append(Component.text(text ?: ""))
  }

  /** Appends children to this component. */
  public fun append(vararg components: ComponentLike) {
    components.forEach(componentBuilder::append)
  }

  /** Appends an int to this component. */
  public fun append(int: Int) {
    append(int.toString())
  }

  /** Appends a character to this component. */
  public fun append(char: Char) {
    append(char.toString())
  }

  /** Appends text using the given [block]. */
  public inline fun append(block: TextBuilder.() -> Unit) {
    append(buildText(block))
  }

  /** Appends text using the given [block] and appends the given [content]. */
  public inline fun append(content: Any, block: TextBuilder.() -> Unit) {
    append(
      buildText {
        append(content.toString())
        block()
      },
    )
  }

  /** Appends a newline to this component. */
  public fun appendNewline() {
    componentBuilder.appendNewline()
  }

  /** Appends a space to this component. */
  public fun appendSpace() {
    componentBuilder.appendSpace()
  }

  /** Sets a click event on this component. */
  public fun clickEvent(event: ClickEvent) {
    componentBuilder.clickEvent(event)
  }

  /** Sets this component color using a TextColor. */
  public fun color(color: TextColor) {
    componentBuilder.color(color)
  }

  /** Sets this component color using a hex color. */
  public fun color(hex: Int) {
    componentBuilder.color(TextColor.color(hex))
  }

  /** Sets this component color using a hex color string. */
  public fun color(hex: String) {
    componentBuilder.color(TextColor.fromHexString(hex))
  }

  /** Sets this component color if no color is set yet. */
  public fun colorIfAbsent(color: TextColor) {
    componentBuilder.colorIfAbsent(color)
  }

  /** Sets this component color if no color is set yet using a hexadecimal color string. */
  public fun colorIfAbsent(hex: String) {
    componentBuilder.colorIfAbsent(TextColor.fromHexString(hex))
  }

  /** Adds a decoration to this component. */
  public fun decorate(decoration: TextDecoration) {
    componentBuilder.decorate(decoration)
  }

  /** Adds multiple decorations to this component. */
  public fun decorate(vararg decorations: TextDecoration) {
    decorations.forEach(componentBuilder::decorate)
  }

  /** Sets the decoration value for a specific decoration type. */
  public fun decoration(
    decoration: TextDecoration,
    value: Boolean,
  ) {
    componentBuilder.decoration(decoration, value)
  }

  /** Sets the decoration value if it's absent for a specific decoration type. */
  public fun decorationIfAbsent(
    decoration: TextDecoration,
    value: TextDecoration.State,
  ) {
    componentBuilder.decorationIfAbsent(decoration, value)
  }

  /** Sets multiple decorations at once. */
  public fun decorations(map: Map<TextDecoration, TextDecoration.State>) {
    componentBuilder.decorations(map)
  }

  /** Sets the font. */
  public fun font(key: Keyed) {
    componentBuilder.font(key.key())
  }

  /** Sets the font using a string key. */
  public fun font(key: String) {
    val keys = key.split(":")
    font(key(keys.first(), keys.last()))
  }

  /** Sets the font using a packed key. */
  public fun font(key: PackedKey) {
    font(key.toString())
  }

  /** Sets the font using an [AxiFont]. */
  public fun font(font: AxiFont) {
    font(font.font.key)
  }

  /** Sets a hover event for this component. */
  public fun hoverEvent(event: HoverEventSource<*>) {
    componentBuilder.hoverEvent(event)
  }

  /** Sets this component to be italic. */
  public fun italic() {
    decorate(ITALIC)
  }

  /** Removes the italic decoration from this component. */
  public fun notItalic() {
    decoration(ITALIC, false)
  }

  /** Sets this component to be bold. */
  public fun bold() {
    decorate(BOLD)
  }

  /** Removes the bold decoration from this component. */
  public fun notBold() {
    decoration(BOLD, false)
  }

  /** Appends a space with the specified width. */
  public fun appendSpace(space: Int) {
    append {
      append(negativeSpaces.getChar(space).toString())
      font(negativeSpaces.fontKey)
    }
  }

  /** Appends a component with a specified offset. */
  public fun appendWithOffset(offset: Int, text: ComponentLike) {
    if (offset == 0) {
      append(text)
      return
    }

    appendSpace(offset)
    append(text)
    appendSpace(-offset)
  }

  /** Converts the builder into a Component. */
  public fun asComponent(): Component {
    return componentBuilder.asComponent()
  }

  /** Builds and returns this componentComponent. */
  public fun build(): TextComponent {
    return componentBuilder.build()
  }

  /** Returns the list of child components. */
  public fun children(): List<Component> {
    return componentBuilder.children()
  }

  /** Appends a component with a specified offset using a block. */
  public inline fun appendWithOffset(offset: Int, block: TextBuilder.() -> Unit) {
    appendWithOffset(offset, buildText(block))
  }

  /** Returns the width of this component. */
  public fun width(): Int {
    return componentBuilder.width()
  }

  /** Removes the shadow effect from this component. */
  public fun removeShadow() {
    shadowColor(ShadowColor.none())
  }

  /** Sets the shadow color using a hexadecimal value. */
  public fun shadowColor(color: Int) {
    shadowColor(ShadowColor.shadowColor(color))
  }

  /** Sets the shadow color using a ShadowColor. */
  public fun shadowColor(shadowColor: ShadowColor) {
    componentBuilder.shadowColor(shadowColor)
  }

  /** Appends a component to this component. */
  public fun append(component: Component) {
    append(*arrayOf(component))
  }

  /** Sets an offset for this component. */
  public fun withOffset(offset: Int) {
    if (offset == 0) {
      return
    }

    this.offset = offset
    appendSpace(offset)
  }

  /** Ends the offset and appends the corresponding space. */
  public fun endOffset() {
    offset?.let { offset -> appendSpace(-offset) }
  }

  /** Adds an underline decoration to this component. */
  public fun underlined() {
    decorate(TextDecoration.UNDERLINED)
  }
}

/** Builds a component using the specified [block]. */
public inline fun buildText(block: TextBuilder.() -> Unit = {}): TextComponent {
  val builder = TextBuilder()
  builder.block()
  builder.endOffset()

  return builder.build().compactText()
}

/** Builds a text from the given [block] and sends it. */
public inline fun Audience.send(block: TextBuilder.() -> Unit): TextComponent {
  val text = buildText(block)
  sendMessage(text)
  return text
}
