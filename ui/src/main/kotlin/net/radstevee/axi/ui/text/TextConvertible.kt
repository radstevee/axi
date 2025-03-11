package net.radstevee.axi.ui.text

import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.ComponentBuilder
import net.kyori.adventure.text.ComponentIteratorFlag
import net.kyori.adventure.text.ComponentIteratorType
import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.TextReplacementConfig
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import net.kyori.adventure.text.event.HoverEventSource
import net.kyori.adventure.text.format.ShadowColor
import net.kyori.adventure.text.format.Style
import net.kyori.adventure.text.format.StyleBuilderApplicable
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.util.ARGBLike
import net.kyori.examination.ExaminableProperty
import net.kyori.examination.Examiner
import java.util.Spliterator
import java.util.function.BiPredicate
import java.util.function.Consumer
import java.util.function.UnaryOperator
import java.util.stream.Stream

/** Represents something that can be converted to a component. */
public interface TextConvertible : TextComponent {
  /** Converts this to a component. */
  public fun asText(): TextComponent

  override fun append(component: Component): TextComponent = asText().append(component)
  override fun append(component: ComponentLike): TextComponent = asText().append(component)
  override fun append(builder: ComponentBuilder<*, *>): TextComponent = asText().append(builder)
  override fun appendNewline(): Component = asText().appendNewline()
  override fun appendSpace(): Component = asText().appendSpace()
  override fun applyFallbackStyle(vararg style: StyleBuilderApplicable): Component = asText().applyFallbackStyle(*style)

  override fun applyFallbackStyle(style: Style): Component = asText().applyFallbackStyle(style)
  override fun asComponent(): TextComponent = asText()
  override fun asHoverEvent(): HoverEvent<Component> = asText().asHoverEvent()
  override fun asHoverEvent(op: UnaryOperator<Component>): HoverEvent<Component> = asText().asHoverEvent(op)
  override fun children(): List<Component> = asText().children()
  override fun children(children: MutableList<out ComponentLike>): TextComponent = asText().children(children)
  override fun clickEvent(event: ClickEvent?): TextComponent = asText().clickEvent(event)
  override fun clickEvent(): ClickEvent? = asText().clickEvent()
  override fun color(color: TextColor?): TextComponent = asText().color(color)
  override fun color(): TextColor? = asText().color()
  override fun colorIfAbsent(color: TextColor?): TextComponent = asText().colorIfAbsent(color)
  override fun compact(): Component = asText().compact()
  override fun componentBuilderApply(component: ComponentBuilder<*, *>): Unit = asText().componentBuilderApply(component)

  override fun contains(that: Component): Boolean = asText().contains(that)
  override fun contains(that: Component, equals: BiPredicate<in Component, in Component>): Boolean = asText().contains(that, equals)

  override fun content(): String = asText().content()
  override fun content(content: String): TextComponent = asText().content(content)
  override fun decoration(decoration: TextDecoration): TextDecoration.State = asText().decoration(decoration)
  override fun decoration(decoration: TextDecoration, state: TextDecoration.State): TextComponent = asText().decoration(decoration, state)

  override fun decoration(decoration: TextDecoration, value: Boolean): TextComponent = asText().decoration(decoration, value)

  override fun decorationIfAbsent(decoration: TextDecoration, value: TextDecoration.State): Component = asText().decorationIfAbsent(decoration, value)

  override fun decorations(): MutableMap<TextDecoration, TextDecoration.State> = asText().decorations()
  override fun decorations(map: Map<TextDecoration, TextDecoration.State>): Component = asText().decorations(map)
  override fun decorations(decorations: MutableSet<TextDecoration>, flag: Boolean): Component = asText().decorations(decorations, flag)

  override fun examinableName(): String = asText().examinableName()
  override fun examinableProperties(): Stream<out ExaminableProperty> = asText().examinableProperties()
  override fun <R : Any?> examine(examiner: Examiner<R>): R & Any = asText().examine(examiner)
  override fun font(): Key? = asText().font()
  override fun font(key: Key?): Component = asText().font(key)
  override fun hasDecoration(decoration: TextDecoration): Boolean = asText().hasDecoration(decoration)
  override fun hasStyling(): Boolean = asText().hasStyling()
  override fun hoverEvent(event: HoverEventSource<*>?): TextComponent = asText().hoverEvent(event)
  override fun hoverEvent(): HoverEvent<*>? = asText().hoverEvent()
  override fun insertion(): String? = asText().insertion()
  override fun insertion(insertion: String?): TextComponent = asText().insertion(insertion)
  override fun iterable(type: ComponentIteratorType, flags: MutableSet<ComponentIteratorFlag>): Iterable<Component> = asText().iterable(type, flags)

  override fun iterable(type: ComponentIteratorType, vararg flags: ComponentIteratorFlag): Iterable<Component> = asText().iterable(type, *flags)

  override fun iterator(type: ComponentIteratorType, flags: MutableSet<ComponentIteratorFlag>): Iterator<Component> = asText().iterator(type, flags)

  override fun iterator(type: ComponentIteratorType, vararg flags: ComponentIteratorFlag): Iterator<Component> = asText().iterator(type, *flags)

  override fun mergeStyle(that: Component): TextComponent = asText().mergeStyle(that)
  override fun mergeStyle(that: Component, merges: MutableSet<Style.Merge>): TextComponent = asText().mergeStyle(that, merges)

  override fun mergeStyle(that: Component, vararg merges: Style.Merge): TextComponent = asText().mergeStyle(that, *merges)

  override fun replaceText(config: TextReplacementConfig): Component = asText().replaceText(config)
  override fun replaceText(configurer: Consumer<TextReplacementConfig.Builder>): Component = asText().replaceText(configurer)

  override fun spliterator(
    type: ComponentIteratorType,
    flags: MutableSet<ComponentIteratorFlag>,
  ): Spliterator<Component> = asText().spliterator(type, flags)

  override fun shadowColor(): ShadowColor? = asText().shadowColor()
  override fun shadowColor(argb: ARGBLike?): TextComponent = asText().shadowColor(argb)
  override fun shadowColorIfAbsent(argb: ARGBLike?): TextComponent = asText().shadowColorIfAbsent(argb)
  override fun decorate(decoration: TextDecoration): TextComponent = asText().decorate(decoration)
  override fun decorate(vararg decorations: TextDecoration): Component = asText().decorate(*decorations)
  override fun spliterator(type: ComponentIteratorType, vararg flags: ComponentIteratorFlag): Spliterator<Component> = asText().spliterator(type, *flags)

  override fun style(): Style = asText().style()
  override fun style(consumer: Consumer<Style.Builder>, strategy: Style.Merge.Strategy): Component = asText().style(consumer, strategy)

  override fun style(style: Style): TextComponent = asText().style(style)
  override fun style(style: Consumer<Style.Builder>): TextComponent = asText().style(style)
  override fun style(style: Style.Builder): TextComponent = asText().style(style)
  override fun toBuilder(): TextComponent.Builder = asText().toBuilder()
}
