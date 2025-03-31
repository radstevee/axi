package net.radsteve.axi.ui.resource.sprite

import net.radsteve.axi.DelegatingRegistry
import net.radsteve.axi.Registry
import net.radsteve.axi.ui.resource.pack.AxiPack
import net.radstevee.packed.core.key.Key

/** A registry of sprites, delegating to [AxiSprites]. */
public open class SpriteRegistry : DelegatingRegistry<Key, Sprite>(AxiSprites) {
  /** Delegating sprite registry. */
  public companion object AxiSprites : Registry<Key, Sprite>(modifiable = true)

  /** Registers a [Sprite]. */
  protected fun registerSprite(
    texture: Key,
    pack: AxiPack,
    scaling: Float = 1f,
    verticalShift: Double = 0.0,
    shadow: Boolean = false,
  ): Sprite = register(
    texture,
    Sprite(
      SpriteData(texture, scaling, verticalShift, shadow),
      pack,
    ),
  )
}
