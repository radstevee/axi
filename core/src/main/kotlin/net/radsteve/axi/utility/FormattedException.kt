package net.radsteve.axi.utility

import net.kyori.adventure.text.Component
import net.radsteve.axi.utility.internal.text

/** An exception formatted to a component. */
public open class FormattedException(
  /** The message. */
  message: Component,
) : RuntimeException(message.text())
