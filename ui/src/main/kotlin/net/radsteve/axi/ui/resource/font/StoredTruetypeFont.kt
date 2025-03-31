package net.radsteve.axi.ui.resource.font

import net.radsteve.axi.ui.resource.pack.AxiPack
import net.radstevee.packed.core.font.Font
import net.radstevee.packed.core.key.Key
import java.awt.font.FontRenderContext
import java.awt.geom.AffineTransform
import java.awt.geom.Rectangle2D
import java.io.File
import kotlin.math.roundToInt
import java.awt.Font as AwtFont

/** Represents a TTF that is stored in a file. */
public class StoredTruetypeFont(
  /** The resource pack which this font should be registered to. */
  public val pack: AxiPack,
  /** The namespace of this font. */
  public val namespace: String,
  /** The name of this font. */
  public val fontName: String,
  /** A reference to the TTF file */
  public val ttf: File,
  /** The size of this font. */
  public val baseSize: Int = 16,
  /** The scaling of this font. */
  public val scaling: Float = 1f,
  /** The vertical shift of this font. */
  public val verticalShift: Double = 0.0,
) : AxiFont {
  private companion object {
    val FRC: FontRenderContext = FontRenderContext(AffineTransform(), false, true)
  }

  /** The rendered AWT font of this TTF. */
  public val awtFont: AwtFont = AwtFont.createFont(AwtFont.TRUETYPE_FONT, ttf).deriveFont(baseSize * scaling)

  /** The key of this font. */
  public val fontKey: Key = if (verticalShift != 0.0) {
    Key(namespace, "${fontName}_offset_$verticalShift")
  } else {
    Key(namespace, fontName)
  }

  override val font: Font = pack.pack.addFont {
    key = fontKey

    ttf {
      key = Key(namespace, "$fontName.ttf")
      shift = listOf(0.0, verticalShift)
      size = (baseSize * scaling).toDouble()
      oversample = size + scaling
    }
  }

  /** Gets the bounds of a text string. */
  public fun boundsOf(text: String): Rectangle2D {
    return awtFont.getStringBounds(text, FRC)
  }

  override fun widthOf(text: String): Int = boundsOf(text).width.roundToInt()
  override fun heightOf(text: String): Int = boundsOf(text).height.roundToInt()

  override fun save(pack: AxiPack) {
    val targetFile = pack.pack.outputDir.resolve("assets/$namespace/font/${ttf.name}")
    runCatching { ttf.copyTo(targetFile, overwrite = true) }
  }
}
