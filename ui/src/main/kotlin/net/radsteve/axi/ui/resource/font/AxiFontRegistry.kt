package net.radsteve.axi.ui.resource.font

import net.radsteve.axi.DelegatingRegistry
import net.radsteve.axi.Registry
import net.radsteve.axi.ui.resource.pack.AxiPack
import net.radstevee.packed.core.key.Key
import java.io.File

/** A registry of fonts, delegating to [AxiFonts]. */
public open class AxiFontRegistry : DelegatingRegistry<Key, AxiFont>(AxiFonts) {
  /** Delegating font registry. */
  public companion object AxiFonts : Registry<Key, AxiFont>(modifiable = true) {
    /** The default offsets. */
    public val DEFAULT_OFFSETS: List<Double> = offsets()

    /** Finds a font by the given [key]. */
    public fun findByKey(key: Key): AxiFont? {
      return collectEntries().find { font -> font.font.key == key }
    }

    private fun offsets(min: Double = -30.0, max: Double = 30.0, steps: Double = 1.0) = buildList {
      var value = min
      while (value <= max) {
        add(value)
        value += steps
      }
    }

    /** The sprite font. Gets initialised after all sprites have been collected. */
    public lateinit var sprites: AxiFont
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
      pack,
      namespace,
      name,
      ttf,
      baseSize,
      scaling,
      verticalShift,
    )

    register(font.fontKey, font)

    return font
  }

  protected fun registerOffsets(
    font: AxiFont,
    pack: AxiPack,
    offsets: List<Double> = DEFAULT_OFFSETS,
  ): Map<Double, AxiOffsetFont> {
    val fonts = buildMap {
      offsets.forEach { offset ->
        this[offset] = AxiOffsetFont(font, offset, pack)
      }
    }

    fonts.forEach { (_, font) -> register(font.fontKey, font) }

    return fonts
  }
}
