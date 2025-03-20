# Sprites

Axi offers an API to register and use sprites, basic font
textures of a resource pack. To do this, you will need to
create a `SpriteRegistry`.

## Creating your first sprite registry

To create a sprite registry, all you need to do is extend
the `SpriteRegistry` class and call it in our resource pack
initializer:

```kt
object Sprites : SpriteRegistry()

object ExamplePack : AxiPack("example") {
  // ...
  init {
    // ...
    Sprites
  }
}
```

Now, this isn't very exciting. We obviously want to register
our sprites as well!

## Registering sprites

Axi provides the utility function
`SpriteRegistry#registerSprite` to register sprites. These
return a `Sprite` instance, which implement `TextComponent`,
so you can just append these to other components as you
wish.

```kt
object Sprites : SpriteRegistry() {
  val TEST: Sprite = registerSprite(Key("axi", "sprites/cheese.png"), /* AxiPack */)
}
```

This is a very basic sprite. It is just our texture with no
fancy scaling or anything. We can use the defaulted
arguments `scaling` to set a scaling modifier for our sprite,
`verticalShift` to add extra ascent to this sprite, and we
can toggle the shadow for this sprite with the `shadow`
argument.
