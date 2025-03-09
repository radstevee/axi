package net.radstevee.axi.ui.resource.sprite

import net.kyori.adventure.text.TextComponent
import net.radstevee.axi.ui.resource.pack.AxiPack
import net.radstevee.axi.ui.text.TextConvertible
import net.radstevee.axi.ui.text.buildText
import net.radstevee.axi.ui.util.imageHeight
import net.radstevee.axi.ui.util.imageWidth
import net.radstevee.packed.core.key.Key
import java.io.File
import kotlin.math.floor
import kotlin.properties.Delegates

/** A registered sprite, tied to a character in the sprite font. */
public class Sprite(
    /** Data about this sprite. */
    public val data: SpriteData,
    /** The resource pack this sprite should be installed to. */
    public val pack: AxiPack,
) : TextConvertible {
    /** The character tied to this sprite. */
    public var character: Char by Delegates.notNull<Char>()
        private set

    /** The font tied to this sprite. */
    public var font: Key by Delegates.notNull<Key>()
        private set

    /** The texture file. */
    private val file: File by lazy {
        val texture = pack.pack.assetResolutionStrategy.getTexture(data.texture) ?: error("failed locating sprite file: ${data.texture}")
        if (texture.exists()) {
            texture
        } else {
            pack.pack.assetResolutionStrategy.getTexture(
                pack.fallbackProvider.sprite(pack) ?: error("could not find a fallback sprite")
            ) ?: error("unimplemented sprite could not be found")
        }
    }

    /** The texture width. */
    public val textureWidth: Int by lazy(file::imageWidth)

    /** The texture height. */
    public val textureHeight: Int by lazy(file::imageHeight)

    /** The scaled, rendered width of this sprite. */
    public val width: Int by lazy { (height / textureHeight) * textureWidth }

    /** The scaled, rendered height of this sprite. */
    public val height: Int by lazy { floor(textureHeight * data.scaling).toInt() }

    /** Assigns this sprite to the given font [key]. */
    public fun assignFont(key: Key) {
        font = key
    }

    /** Assigns this sprite to the given character. */
    public fun assignCharacter(existingSprites: Int): Char {
        val unicode = 0xE000 + (existingSprites + 1)
        val new = unicode.toChar()

        character = new

        return new
    }

    override fun asText(): TextComponent = buildText {
        font(font)
        append(character)

        if (!data.shadow) {
            removeShadow()
        }
    }
}
