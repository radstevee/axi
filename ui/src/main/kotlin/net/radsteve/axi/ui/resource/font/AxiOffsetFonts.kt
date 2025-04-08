package net.radsteve.axi.ui.resource.font

/** Maps offsets to their fonts. */
public class AxiOffsetFonts(
  /** The offsets. */
  public val offsets: Map<Double, AxiOffsetFont>,
) {
  /** Gets a font from the given [offset]. */
  public operator fun get(offset: Double): AxiOffsetFont {
    return requireNotNull(offsets[offset]) { "offset $offset does not exist" }
  }

  /** Gets a font from the given [offset]. */
  public operator fun get(offset: Int): AxiOffsetFont {
    return get(offset.toDouble())
  }
}
