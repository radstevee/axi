package net.radstevee.axi.example.resource

import net.radstevee.axi.ui.resource.sprite.Sprite
import net.radstevee.axi.ui.resource.sprite.SpriteRegistry
import net.radstevee.packed.core.key.Key

object Sprites : SpriteRegistry() {
  val Test: Sprite = registerSprite(Key("axi", "sprites/cheese.png"), ExamplePack)
}
