package net.radstevee.axi.ui.render.layer

import net.kyori.adventure.text.TextComponent

/** The contents of a render layer. */
public data class RenderLayerContents(
    /**
     * The text contents of this layer. If you do not wish to use
     * a text component here, add an empty text component with children.
     */
    public val contents: List<TextComponent>,
)
