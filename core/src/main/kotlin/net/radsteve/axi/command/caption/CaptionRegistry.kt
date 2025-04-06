package net.radsteve.axi.command.caption

import net.radsteve.axi.Registry
import org.incendo.cloud.caption.Caption
import org.incendo.cloud.caption.CaptionProvider
import org.incendo.cloud.paper.util.sender.Source

/** A registry of command captions. */
public open class CaptionRegistry {
  /** The caption keys. */
  protected val keys: Registry<String, Caption> = net.radsteve.axi.Registry()

  /** The caption values. */
  protected val values: Registry<String, String> = net.radsteve.axi.Registry()

  /** Registers a caption and returns it. */
  public fun register(key: String, value: String): Caption {
    val caption = Caption.of(key)
    keys.register(key, caption)
    values.register(key, value)

    return caption
  }

  /** Gets a caption provider from this registry. */
  public fun provider(): CaptionProvider<Source> {
    val provider = CaptionProvider.constantProvider<Source>()
    val captions = keys.collectEntries().associateWith { caption -> values[caption.key()]!! }

    provider.putAllCaptions(captions)

    return provider.build()
  }

  /** Built-in axi captions. */
  public companion object AxiCaptions : CaptionRegistry() {
    /** An invalid key of a map. */
    public val InvalidMapKey: Caption = register("argument.parse.failure.map", "'<input>' is not a valid key!")
  }
}
