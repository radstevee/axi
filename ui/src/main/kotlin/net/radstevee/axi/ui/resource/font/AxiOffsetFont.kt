package net.radstevee.axi.ui.resource.font

import net.radstevee.axi.ui.resource.pack.AxiPack
import net.radstevee.packed.core.font.Font
import net.radstevee.packed.core.font.FontProvider
import net.radstevee.packed.core.key.Key

/** A font that copies another font with a vertical offset. */
public class AxiOffsetFont(
  /** The other font. */
  private val other: AxiFont,
  /** The offset. */
  private val offset: Double,
  /** The resource pack. */
  pack: AxiPack
) : AxiFont by other {
  private val otherKey = other.font.key
  public val fontKey: Key = otherKey.copy(value = "${otherKey.value}_offset_$offset")

  private fun FontProvider.Bitmap.applyBitmapOffset(): FontProvider.Bitmap {
    return copy(ascent = ascent + offset)
  }

  private fun FontProvider.Truetype.applyTruetypeOffset(): FontProvider.Truetype {
    val newShift = shift.toMutableList().apply {
      this[1] += offset
    }
    return copy(shift = newShift)
  }

  private fun FontProvider.applyOffset(): FontProvider {
    return when (this) {
      is FontProvider.Bitmap -> applyBitmapOffset()
      is FontProvider.Truetype -> applyTruetypeOffset()
      else -> this
    }
  }

  override val font: Font = pack.pack.addFont {
    key = fontKey

    other.font.providers.forEach { provider ->
      addProvider(provider.applyOffset())
    }
  }
}
