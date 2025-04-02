package net.radsteve.axi.ui.text

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
public fun interface TextConvertible : TextComponent {
  /** Converts this to a component. */
  public fun asText(): TextComponent

  override fun append(component: Component): TextComponent {
    return asText().append(component)
  }

  override fun append(component: ComponentLike): TextComponent {
    return asText().append(component)
  }

  override fun append(builder: ComponentBuilder<*, *>): TextComponent {
    return asText().append(builder)
  }

  override fun asComponent(): TextComponent {
    return asText()
  }

  override fun asHoverEvent(): HoverEvent<Component> {
    return asText().asHoverEvent()
  }

  override fun asHoverEvent(op: UnaryOperator<Component>): HoverEvent<Component> {
    return asText().asHoverEvent(op)
  }

  override fun children(): List<Component> {
    return asText().children()
  }

  override fun children(children: MutableList<out ComponentLike>): TextComponent {
    return asText().children(children)
  }

  override fun clickEvent(event: ClickEvent?): TextComponent {
    return asText().clickEvent(event)
  }

  override fun clickEvent(): ClickEvent? {
    return asText().clickEvent()
  }

  override fun color(color: TextColor?): TextComponent {
    return asText().color(color)
  }

  override fun color(): TextColor? {
    return asText().color()
  }

  override fun colorIfAbsent(color: TextColor?): TextComponent {
    return asText().colorIfAbsent(color)
  }

  override fun compact(): Component {
    return asText().compact()
  }

  override fun componentBuilderApply(component: ComponentBuilder<*, *>) {
    asText().componentBuilderApply(component)
  }

  override fun contains(that: Component): Boolean {
    return asText().contains(that)
  }

  override fun contains(that: Component, equals: BiPredicate<in Component, in Component>): Boolean {
    return asText().contains(that, equals)
  }

  override fun content(): String {
    return asText().content()
  }

  override fun content(content: String): TextComponent {
    return asText().content(content)
  }

  override fun decoration(decoration: TextDecoration): TextDecoration.State {
    return asText().decoration(decoration)
  }

  override fun decoration(decoration: TextDecoration, state: TextDecoration.State): TextComponent {
    return asText().decoration(decoration, state)
  }

  override fun decoration(decoration: TextDecoration, value: Boolean): TextComponent {
    return asText().decoration(decoration, value)
  }

  override fun decorations(): MutableMap<TextDecoration, TextDecoration.State> {
    return asText().decorations()
  }

  override fun decorations(decorations: MutableSet<TextDecoration>, flag: Boolean): Component {
    return asText().decorations(decorations, flag)
  }

  override fun examinableName(): String {
    return asText().examinableName()
  }

  override fun examinableProperties(): Stream<out ExaminableProperty> {
    return asText().examinableProperties()
  }

  override fun <R : Any?> examine(examiner: Examiner<R>): R & Any {
    return asText().examine(examiner)
  }

  override fun font(): Key? {
    return asText().font()
  }

  override fun hasDecoration(decoration: TextDecoration): Boolean {
    return asText().hasDecoration(decoration)
  }

  override fun hasStyling(): Boolean {
    return asText().hasStyling()
  }

  override fun hoverEvent(event: HoverEventSource<*>?): TextComponent {
    return asText().hoverEvent(event)
  }

  override fun hoverEvent(): HoverEvent<*>? {
    return asText().hoverEvent()
  }

  override fun insertion(): String? {
    return asText().insertion()
  }

  override fun insertion(insertion: String?): TextComponent {
    return asText().insertion(insertion)
  }

  override fun iterable(type: ComponentIteratorType, flags: MutableSet<ComponentIteratorFlag>): Iterable<Component> {
    return asText().iterable(type, flags)
  }

  override fun iterable(type: ComponentIteratorType, vararg flags: ComponentIteratorFlag): Iterable<Component> {
    return asText().iterable(type, *flags)
  }

  override fun iterator(type: ComponentIteratorType, flags: MutableSet<ComponentIteratorFlag>): Iterator<Component> {
    return asText().iterator(type, flags)
  }

  override fun iterator(type: ComponentIteratorType, vararg flags: ComponentIteratorFlag): Iterator<Component> {
    return asText().iterator(type, *flags)
  }

  override fun mergeStyle(that: Component): TextComponent {
    return asText().mergeStyle(that)
  }

  override fun mergeStyle(that: Component, merges: MutableSet<Style.Merge>): TextComponent {
    return asText().mergeStyle(that, merges)
  }

  override fun mergeStyle(that: Component, vararg merges: Style.Merge): TextComponent {
    return asText().mergeStyle(that, *merges)
  }

  override fun replaceText(config: TextReplacementConfig): Component {
    return asText().replaceText(config)
  }

  override fun replaceText(configurer: Consumer<TextReplacementConfig.Builder>): Component {
    return asText().replaceText(configurer)
  }

  override fun spliterator(
    type: ComponentIteratorType,
    flags: MutableSet<ComponentIteratorFlag>,
  ): Spliterator<Component> {
    return asText().spliterator(type, flags)
  }

  override fun shadowColor(): ShadowColor? {
    return asText().shadowColor()
  }

  override fun shadowColor(argb: ARGBLike?): TextComponent {
    return asText().shadowColor(argb)
  }

  override fun shadowColorIfAbsent(argb: ARGBLike?): TextComponent {
    return asText().shadowColorIfAbsent(argb)
  }

  override fun decorate(decoration: TextDecoration): TextComponent {
    return asText().decorate(decoration)
  }

  override fun decorate(vararg decorations: TextDecoration): Component {
    return asText().decorate(*decorations)
  }

  override fun spliterator(type: ComponentIteratorType, vararg flags: ComponentIteratorFlag): Spliterator<Component> {
    return asText().spliterator(type, *flags)
  }

  override fun style(): Style {
    return asText().style()
  }

  override fun style(consumer: Consumer<Style.Builder>, strategy: Style.Merge.Strategy): Component {
    return asText().style(consumer, strategy)
  }

  override fun style(style: Style): TextComponent {
    return asText().style(style)
  }

  override fun style(style: Consumer<Style.Builder>): TextComponent {
    return asText().style(style)
  }

  override fun style(style: Style.Builder): TextComponent {
    return asText().style(style)
  }

  override fun toBuilder(): TextComponent.Builder {
    return asText().toBuilder()
  }
}
