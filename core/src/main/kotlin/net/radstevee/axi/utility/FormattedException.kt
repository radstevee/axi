package net.radstevee.axi.utility

import net.kyori.adventure.text.Component
import net.radstevee.axi.utility.internal.text

/** An exception formatted to a component. */
public open class FormattedException(
  /** The message. */
  message: Component,
) : RuntimeException(message.text())
