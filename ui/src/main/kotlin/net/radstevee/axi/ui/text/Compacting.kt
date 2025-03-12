package net.radstevee.axi.ui.text

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

public fun TextComponent.compactText(): TextComponent {
  return compact() as TextComponent

  val isEmpty = content().isBlank()
  val firstTextChild = children().filterIsInstance<TextComponent>().firstOrNull()
  val firstChildHasContent = firstTextChild?.content()?.isNotBlank() == true
  val firstChildIsUnstyled = firstTextChild?.hasStyling() == false
  val newChildren = children().filter { child -> child != firstTextChild }

  if (isEmpty && firstChildHasContent && firstChildIsUnstyled) {
    return content(firstTextChild.content())
      .children(newChildren)
  }

  return this
}
