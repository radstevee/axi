package net.radstevee.axi.ui.text

import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.TranslatableComponent
import net.kyori.adventure.text.format.TextDecoration.BOLD
import net.radstevee.axi.ui.resource.font.AxiFontRegistry
import net.radstevee.axi.ui.resource.pack.AxiPackRegistry.AxiPacks.NegativeSpaces
import net.radstevee.axi.ui.util.adventure
import net.radstevee.axi.ui.util.packed
import kotlin.math.roundToInt

/** Calculates the width of a component. */
public fun ComponentLike.width(): Int {
    var width = 0.0

    visit { _, style, char ->
        val charWidth = when (val fontKey = style.font()) {
            null -> {
                (MinecraftFontWidths[char] ?: 1) - 1
            }

            NegativeSpaces.fontKey.adventure() -> {
                NegativeSpaces.advances.getOrDefault(char, 0).toInt()
            }

            else -> {
                val font = AxiFontRegistry.findByKey(fontKey.packed()) ?: error("non-width measurable font: $fontKey")
                font.widthOf(char.toString())
            }
        }

        width += charWidth

        if (char == ' ') {
            return@visit
        }

        if (style.font() == NegativeSpaces.fontKey.adventure() || style.hasDecoration(BOLD)) {
            width++
        }
    }

    return when (this) {
        // If this is a translatable, add the width of all arguments.
        is TranslatableComponent -> {
            val translationArgWidths = arguments().filterIsInstance<ComponentLike>().sumOf(ComponentLike::width)

            (width + translationArgWidths).roundToInt()
        }

        else -> width.roundToInt()
    }
}
