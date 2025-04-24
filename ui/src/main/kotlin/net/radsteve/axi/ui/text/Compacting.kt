package net.radsteve.axi.ui.text

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.TextComponent

/** Compacts the children of this component. */
public fun ComponentLike.compactChildren(): List<Component> {
  val childrenList = mutableListOf<Component>()

  fun collectChildren(component: ComponentLike) {
    val componentChildren = component.asComponent().children()
    componentChildren.forEach { child ->
      childrenList.add(child)
      collectChildren(child)
    }
  }

  if (this is TextComponent && content().isNotBlank()) {
    childrenList.add(Component.text(content(), style()))
  }

  collectChildren(this)

  if (childrenList.isEmpty()) {
    return listOf(asComponent())
  }

  return childrenList
}
