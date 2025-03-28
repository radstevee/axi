package net.radstevee.axi.game.utility.internal

import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer.plainText

internal fun ComponentLike.text(): String {
  return plainText().serialize(asComponent())
}
