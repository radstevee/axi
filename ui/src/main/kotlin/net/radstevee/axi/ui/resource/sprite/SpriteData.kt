package net.radstevee.axi.ui.resource.sprite

import net.radstevee.packed.core.key.Key

/** Holds metadata about a [Sprite]. */
public data class SpriteData(
    /** The texture key. */
    public val texture: Key,
    /** The scaling of this sprite. */
    public val scaling: Float = 1f,
    /** The vertical shift of this sprite. */
    public val verticalShift: Double = 0.0,
    /** Whether this sprite should display a shadow. */
    public val shadow: Boolean = false,
)
