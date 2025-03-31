package net.radsteve.axi.ui.text

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

private val MINI_INSTANCE: MiniMessage = MiniMessage.miniMessage()

/** Serializes this minimessage string to a component. */
public val String.mm: Component get() = MINI_INSTANCE.deserialize(this)
