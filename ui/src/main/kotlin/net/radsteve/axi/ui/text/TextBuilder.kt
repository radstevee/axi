package net.radsteve.axi.ui.text

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.key.Keyed
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.ComponentBuilderApplicable
import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.format.ShadowColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.format.TextDecoration.BOLD
import net.kyori.adventure.text.format.TextDecoration.ITALIC
import net.kyori.adventure.text.format.TextDecoration.UNDERLINED
import net.radsteve.axi.ui.AxiUI
import net.radsteve.axi.ui.render.layer.layered.LayeredTextBuilder
import net.radsteve.axi.ui.render.layer.layered.buildLayeredText
import net.radsteve.axi.ui.resource.font.AxiFont
import net.radsteve.axi.ui.resource.pack.AxiPackRegistry.AxiPacks.negativeSpaces
import net.radsteve.axi.ui.theme.Theme
import net.radsteve.axi.ui.util.adventure
import net.radstevee.packed.core.key.Key as PackedKey

/** A text component builder. */
public class TextBuilder(
  /** The theme of this text builder. */
  public val theme: Theme = Theme.Default,
) {
  @PublishedApi
  internal val componentBuilder: TextComponent.Builder = text()
  private var offset: Int? = null
  public val foreground: TextColor? = theme.foreground
  public val accent: TextColor? = theme.accent
  public val black: TextColor? = theme.palette?.black
  public val darkBlue: TextColor? = theme.palette?.darkBlue
  public val darkGreen: TextColor? = theme.palette?.darkGreen
  public val darkAqua: TextColor? = theme.palette?.darkAqua
  public val darkRed: TextColor? = theme.palette?.darkRed
  public val darkPurple: TextColor? = theme.palette?.darkPurple
  public val gold: TextColor? = theme.palette?.gold
  public val gray: TextColor? = theme.palette?.gray
  public val darkGray: TextColor? = theme.palette?.darkGray
  public val blue: TextColor? = theme.palette?.blue
  public val green: TextColor? = theme.palette?.green
  public val aqua: TextColor? = theme.palette?.aqua
  public val red: TextColor? = theme.palette?.red
  public val pink: TextColor? = theme.palette?.pink
  public val yellow: TextColor? = theme.palette?.yellow
  public val white: TextColor? = theme.palette?.white
  public val bold: TextDecoration = BOLD
  public val italic: TextDecoration = ITALIC
  public val underlined: TextDecoration = UNDERLINED

  init {
    color(theme.foreground)
  }

  /** Sets this component color to black. */
  public fun black() {
    color(theme.palette?.black)
  }

  /** Sets this component color to dark red. */
  public fun darkRed() {
    color(theme.palette?.darkRed)
  }

  /** Sets this component color to dark purple. */
  public fun darkPurple() {
    color(theme.palette?.darkPurple)
  }

  /** Sets this component color to gold. */
  public fun gold() {
    color(theme.palette?.gold)
  }

  /** Sets this component color to gray. */
  public fun gray() {
    color(theme.palette?.gray)
  }

  /** Sets this component color to dark gray. */
  public fun darkGray() {
    color(theme.palette?.darkGray)
  }

  /** Sets this component color to blue. */
  public fun blue() {
    color(theme.palette?.blue)
  }

  /** Sets this component color to green. */
  public fun green() {
    color(theme.palette?.green)
  }

  /** Sets this component color to aqua. */
  public fun aqua() {
    color(theme.palette?.aqua)
  }

  /** Sets this component color to red. */
  public fun red() {
    color(theme.palette?.red)
  }

  /** Sets this component color to pink. */
  public fun pink() {
    color(theme.palette?.pink)
  }

  /** Sets this component color to yellow. */
  public fun yellow() {
    color(theme.palette?.yellow)
  }

  /** Sets this component color to white. */
  public fun white() {
    color(theme.palette?.white)
  }

  /** Sets this component color to the [theme]'s secondary color. */
  public fun accentColor() {
    color(theme.accent)
  }

  /** Appends children to this component. */
  public fun append(vararg components: ComponentLike) {
    components.forEach(componentBuilder::append)
  }

  /** Appends text using the given [block]. */
  public inline fun append(theme: Theme = this.theme, block: TextBuilder.() -> Unit) {
    append(buildText(theme, false, block))
  }

  /** Appends text of the given [content] and applies the given [applicables]. */
  public fun append(content: String, vararg applicables: ComponentBuilderApplicable?) {
    append(content) {
      applicables.filterNotNull().forEach(componentBuilder::applicableApply)
    }
  }

  /** Appends text of the given [content] and applies the given [applicables]. */
  public fun append(content: Int, vararg applicables: ComponentBuilderApplicable?) {
    append(content.toString(), *applicables)
  }

  /** Appends text using the given [block] and appends the given [content]. */
  public inline fun append(content: Any, block: TextBuilder.() -> Unit) {
    append {
      append(text(content.toString()))
      block()
    }
  }

  /** Appends a newline to this component. */
  public fun appendNewline() {
    componentBuilder.appendNewline()
  }

  /** Appends the given [component] and appends a newline. */
  public fun appendLine(component: Component) {
    append(component)
    appendNewline()
  }

  /** Appends the given [text] and appends a newline. */
  public fun appendLine(text: String) {
    appendLine(text(text))
  }

  /** Builds a component from the given [block] and appends it and a newline. */
  public fun appendLine(theme: Theme = this.theme, block: TextBuilder.() -> Unit) {
    appendLine(buildText(theme, false, block))
  }

  /** Appends a space to this component. */
  public fun appendSpace() {
    componentBuilder.appendSpace()
  }

  /** Sets a click event on this component. */
  public fun clickEvent(event: ClickEvent) {
    componentBuilder.clickEvent(event)
  }

  /** Sets the click event to open the given [url]. */
  public fun openUrl(url: String) {
    clickEvent(ClickEvent.openUrl(url))
  }

  /** Sets the click event to run the given [command]. */
  public fun runCommand(command: String) {
    clickEvent(ClickEvent.runCommand(command))
  }

  /** Sets the click event to suggest the given [command]. */
  public fun suggestCommand(command: String) {
    clickEvent(ClickEvent.suggestCommand(command))
  }

  /** Sets this component color using a TextColor. */
  public fun color(color: TextColor?) {
    componentBuilder.color(color)
  }

  /** Sets this component color using a hex color. */
  public fun color(hex: Int) {
    componentBuilder.color(TextColor.color(hex))
  }

  /** Sets the decoration value for a specific decoration type. */
  public fun decoration(
    decoration: TextDecoration,
    value: Boolean,
  ) {
    componentBuilder.decoration(decoration, value)
  }

  /** Sets the font. */
  public fun font(key: Keyed) {
    componentBuilder.font(key.key())
  }

  /** Sets the font using a packed key. */
  public fun font(key: PackedKey) {
    font(key.adventure())
  }

  /** Sets the font using an [AxiFont]. */
  public fun font(font: AxiFont) {
    font(font.font.key)
  }

  /** Sets this component to be italic. */
  public fun italic() {
    componentBuilder.decorate(ITALIC)
  }

  /** Removes the italic decoration from this component. */
  public fun notItalic() {
    componentBuilder.decoration(ITALIC, false)
  }

  /** Sets this component to be bold. */
  public fun bold() {
    componentBuilder.decorate(BOLD)
  }

  /** Removes the bold decoration from this component. */
  public fun notBold() {
    componentBuilder.decoration(BOLD, false)
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

  /** Builds and returns this componentComponent. */
  public fun build(): TextComponent {
    return componentBuilder.build()
  }

  /** Appends a component with a specified offset using a block. */
  public inline fun appendWithOffset(offset: Int, theme: Theme = this.theme, block: TextBuilder.() -> Unit) {
    appendWithOffset(offset, buildText(theme, false, block))
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
    componentBuilder.append(component)
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
    componentBuilder.decorate(UNDERLINED)
  }

  /** Appends a layered text, built from the given [block] to this component. */
  public fun appendLayered(theme: Theme = this.theme, block: LayeredTextBuilder.() -> Unit) {
    append(buildLayeredText(theme, block))
  }
}

/** Builds a component using the specified [block]. */
public inline fun buildText(
  theme: Theme = AxiUI.theme(),
  applyFixes: Boolean = false,
  block: TextBuilder.() -> Unit = {},
): TextComponent {
  val builder = TextBuilder(theme)
  if (applyFixes) {
    theme.prefix?.let(builder.componentBuilder::append)
  }
  builder.block()
  if (applyFixes) {
    theme.suffix?.let(builder.componentBuilder::append)
  }
  builder.endOffset()

  return builder.build().compactText()
}

/** Builds a text from the given [block] and sends it. */
public inline fun Audience.send(theme: Theme = AxiUI.theme(), block: TextBuilder.() -> Unit): TextComponent {
  val text = buildText(theme, true, block)
  sendMessage(text)
  return text
}
