package net.radstevee.axi.ui.resource.pack

import net.radstevee.axi.ui.resource.font.AxiFontRegistry
import net.radstevee.axi.ui.resource.host.ResourcePackInjector
import net.radstevee.axi.ui.resource.sprite.SpriteFont
import net.radstevee.axi.ui.resource.sprite.SpriteRegistry
import net.radstevee.packed.core.hook.PackedHook
import net.radstevee.packed.core.pack.ResourcePack

/** Saves axi resource pack elements. */
internal class AxiPackSavingHook(
  /** The resource pack for this hook. */
  private val axiPack: AxiPack,
) : PackedHook {
  override fun beforeSave(pack: ResourcePack) {
    SpriteRegistry
    AxiFontRegistry

    AxiFontRegistry.sprites = SpriteFont(
      axiPack,
      SpriteRegistry.collectEntries()
        .filter { sprite -> sprite.pack.name == axiPack.name },
    )
  }

  override fun afterSave(pack: ResourcePack) {
    SpriteRegistry.forEach { sprite ->
      // Initialise lazy properties so they don't read files
      // at runtime, causing potential performance impacts.
      sprite.width
    }

    ResourcePackInjector
  }
}
