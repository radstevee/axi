package net.radstevee.axi.ui.resource.font

import net.kyori.adventure.key.Key
import net.kyori.adventure.key.Keyed
import net.radstevee.axi.ui.resource.pack.AxiPack
import net.radstevee.axi.ui.util.adventure
import net.radstevee.packed.core.font.Font

/** Represents a resource pack font. */
public interface AxiFont : Keyed {
  /** The packed font. */
  public val font: Font

  /** Gets the width of [text]. */
  public fun widthOf(text: String): Int

  /** Gets the height of [text]. */
  public fun heightOf(text: String): Int

  /** Extra logic for saving to a resource pack. */
  public fun save(pack: AxiPack) {}

  override fun key(): Key = font.key.adventure()
}
