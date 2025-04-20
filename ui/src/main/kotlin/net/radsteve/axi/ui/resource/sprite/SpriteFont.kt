package net.radsteve.axi.ui.resource.sprite

import net.radsteve.axi.ui.resource.font.AxiFont
import net.radsteve.axi.ui.resource.pack.AxiPack
import net.radstevee.packed.core.font.Font
import net.radstevee.packed.core.key.Key

/** A font that only contains sprites. */
public class SpriteFont(
  /** The resource pack. */
  pack: AxiPack,
  /** The sprites. */
  private val sprites: List<Sprite>,
) : AxiFont {
  override val font: Font = pack.pack.addFont {
    key = Key("axi", "sprites")

    fallback { _ ->
      pack.fallbackProvider.sprite(pack)
    }

    sprites.forEachIndexed { idx, sprite ->
      sprite.assignFont(key)

      bitmap {
        key = sprite.data.texture
        height = (sprite.textureHeight * sprite.data.scaling).toDouble()
        chars = listOf(sprite.assignCharacter(idx).toString())
        ascent = (height - 1) + sprite.data.verticalShift
      }
    }
  }

  override fun widthOf(text: String): Int = text.sumOf { char ->
    val sprite = sprites.find { sprite -> sprite.character == char }
    sprite?.width ?: 0
  }

  override fun heightOf(text: String): Int = text.sumOf { char ->
    val sprite = sprites.find { sprite -> sprite.character == char }
    sprite?.height ?: 0
  }
}
