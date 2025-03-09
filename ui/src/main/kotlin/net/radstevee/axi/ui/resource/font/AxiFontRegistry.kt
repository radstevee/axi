package net.radstevee.axi.ui.resource.font

import net.radstevee.axi.core.DelegatingRegistry
import net.radstevee.axi.core.Registry
import net.radstevee.axi.ui.resource.pack.AxiPack
import net.radstevee.axi.ui.resource.sprite.SpriteFont
import net.radstevee.packed.core.key.Key
import java.io.File

/** A registry of fonts, delegating to [AxiFonts]. */
public open class AxiFontRegistry : DelegatingRegistry<Key, AxiFont>(AxiFonts) {
    /** Delegating font registry. */
    public companion object AxiFonts : Registry<Key, AxiFont>(modifiable = true) {
        /** The default offsets */
        public val DEFAULT_OFFSETS: List<Double> = offsets()

        /** Finds a font by the given [key]. */
        public fun findByKey(key: Key): AxiFont? {
            return collectEntries().find { font -> font.font.key == key }
        }

        private fun offsets(min: Double = -30.0, max: Double = 30.0, steps: Double = 1.0) = buildList {
            var i = min
            while (i <= max) {
                add(i)
                i += steps
            }
        }

        /** The sprite font. Gets initialised after all sprites have been collected. */
        public lateinit var Sprites: AxiFont
    }

    /** Registers a [StoredTruetypeFont]. */
    protected fun registerStoredTtf(
        name: String,
        namespace: String,
        ttf: File,
        pack: AxiPack,
        baseSize: Int = 16,
        scaling: Float = 1f,
        verticalShift: Double = 0.0,
    ): StoredTruetypeFont {
        val font = StoredTruetypeFont(
            pack, namespace, name, ttf, baseSize, scaling, verticalShift
        )

        register(font.fontKey, font)

        return font
    }
}
