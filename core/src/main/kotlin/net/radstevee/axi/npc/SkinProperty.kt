package net.radstevee.axi.npc

/** Properties for skin display. */
public enum class SkinProperty(private val mask: Int) {
  /** Whether the cape should be displayed. */
  Cape(0x01),

  /** Whether the jacket should be displayed. */
  Jacket(0x02),

  /** Whether the left sleeve should be displayed. */
  LeftSleeve(0x04),

  /** Whether the right sleeve should be displayed. */
  RightSleeve(0x08),

  /** Whether the left pants should be displayed. */
  LeftPantsLeg(0x10),

  /** Whether the right pants should be displayed. */
  RightPantsLeg(0x20),

  /** Whether the hat should be displayed. */
  Hat(0x40),
  ;

  public companion object {
    /** Packs the given [properties] to a byte. */
    public fun pack(properties: Set<SkinProperty>): Int {
      return properties.fold(0) { acc, elem -> acc or elem.mask }
    }
  }
}
