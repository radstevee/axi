package net.radsteve.axi.ui.text

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.minimessage.MiniMessage

private val MINI_INSTANCE: MiniMessage = MiniMessage.miniMessage()

/** Deserializes this minimessage string to a component. */
public val String.mm: Component get() = MINI_INSTANCE.deserialize(this)

/** Serializes this component to a string. */
public val ComponentLike.mm: String get() = MINI_INSTANCE.serialize(this as? Component ?: asComponent())
