package net.radstevee.axi.ui.resource.sprite

import net.radstevee.axi.core.DelegatingRegistry
import net.radstevee.axi.core.Registry
import net.radstevee.axi.ui.resource.pack.AxiPack
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
    ): Sprite {
        return register(
            texture,
            Sprite(
                SpriteData(texture, scaling, verticalShift, shadow),
                pack
            )
        )
    }
}
