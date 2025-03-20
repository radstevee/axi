# Fonts

Fonts are an essential part of server-side UI. You can read
more about fonts [here](https://minecraft.wiki/w/Font).

This page assumes you already have some experience using
fonts.

## Creating a font registry

First up, you will need to extend the `AxiFontRegistry`
class to register all your fonts:

```kt
object Fonts : AxiFontRegistry()
```

## Registering fonts

Now, we can actually start registering our own fonts:

## Font implementations

### Stored Truetype

A stored truetype font is a TTF file that sits somewhere,
usually on the Minecraft server.

You can register it using
`AxiFontRegistry#registerStoredTtf`:

```kt{2}
object Fonts : AxiFontRegistry() {
  val Beaver: StoredTruetypeFont = registerStoredTtf("beaver", "namespace", File("../assets/fonts/beaver.ttf"), /* AxiPack */)
}
```

This registers a basic TTF font with the name `beaver` under
the namespace `namespace`,
from the `../assets/fonts/beaver.ttf` file. This means you
can now set a component's font
to an `AxiFont`'s key as it implements the `Keyed`
interface.

### Offset

A copy of another `AxiFont` that offsets the other font.

You can register it using `AxiFontRegistry#registerOffsets`:

```kt{2}
object Fonts : AxiFontRegistry() {
  val BeaverOffsets: Map<Double, AxiOffsetFont> = registerOffsets(Beaver, /* AxiPack */)
}
```

## Saving fonts

To save your fonts into your resource pack, you will have to
call your
font registry's initializer in your resource pack's
initializer like such:

```kt
object Fonts : AxiFontRegistry()

object ExamplePack : AxiPack("example") {
  // ...
  
  init {
    Fonts
  }
}
```
