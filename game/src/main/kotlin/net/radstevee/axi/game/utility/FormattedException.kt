package net.radstevee.axi.game.utility

import net.kyori.adventure.text.Component
import net.radstevee.axi.game.utility.internal.text

/** An exception formatted to a component. */
public open class FormattedException(
  /** The message. */
  message: Component,
) : RuntimeException(message.text())
