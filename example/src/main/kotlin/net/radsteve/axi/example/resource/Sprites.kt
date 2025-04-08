package net.radsteve.axi.example.resource

import net.radsteve.axi.ui.resource.sprite.Sprite
import net.radsteve.axi.ui.resource.sprite.SpriteRegistry
import net.radstevee.packed.core.key.Key

public object Sprites : SpriteRegistry() {
  public val SmallHudBackground: Sprite = registerSprite(Key("axi", "sprites/hud/small_hud_background.png"), ExamplePack)
}
