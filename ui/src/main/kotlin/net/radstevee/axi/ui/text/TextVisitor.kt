package net.radstevee.axi.ui.text

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.format.Style

/** A component visitor. */
public class TextVisitor(
    /** The component to visit. */
    component: ComponentLike,
    /** The character visitor. */
    private val visitor: CharacterVisitor,
) {
    /** Visitor for each individual character of a component. */
    public fun interface CharacterVisitor {
        /** Visit a character. */
        public fun accept(idx: Int, style: Style, char: Char)
    }

    private val compacted = component.compactChildren()

    private fun visit(component: Component) {
        if (component is TextComponent) {
            component.content().forEachIndexed { idx, char ->
                visitor.accept(idx, component.style(), char)
            }
        }
    }

    /** Visits the given component. */
    public fun visit() {
        compacted.filterIsInstance<TextComponent>().map(TextComponent::compact).forEach(::visit)
    }
}

/** Visits a component. */
public fun ComponentLike.visit(visitor: TextVisitor.CharacterVisitor) {
    TextVisitor(this, visitor).visit()
}
