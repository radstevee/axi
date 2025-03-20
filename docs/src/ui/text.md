# Text API

Axi offers a text API around adventure with Kotlin DSLs.

## Text Builders

Axi offers the `buildText` function to build a text component
using a Kotlin DSL:

```kt
buildText {
  append("Hello, ")
  append("world") {
    green()
  }
  append("!")
  
  yellow()
}
```

This builds a text component with the following contents:

- `Hello, ` (yellow)
- `world` (green)
- `!` (yellow)

Text builders wrap around adventure's `ComponentBuilder` and
have lots of utility functions for making your life easier.

## Text width calculations

Axi provides the `ComponentLike#getWidth` extension to compute
the width of a rendered text component. When using the Minecraft
vanilla font, this assumes there are no overriding resource
packs applied. Usually, you would want to override the default
font with the Minecraft font to make sure it is properly
applied, or use a custom one.

## Colour registries

Colour registries are a unified way of defining branding
colours which will be applied to all text builders.

To get started, simply extend the `ColorRegistry` class and
call your registry's initializer in your plugin initializer:

```kt
object Colors : ColorRegistry() {
  val GREEN: TextColor = register(NamedTextColor.GREEN, 0x94f7c5)
  val YELLOW: TextColor = register(NamedTextColor.YELLOW, 0xf6d48f)
}

class ExampleAxiPlugin : AxiPlugin() {
  override suspend fun enable() {
    // ...
    Colors
  }
}
```

Now, you can use the `green()` and `yellow()` functions in
text builders, and they will be using your specified colours.

## Text convertibles

Axi provides an interface `TextConvertible` which directly
implements adventure's `TextComponent` and delegates
everything to the abstract `asText` function. [Sprites](/ui/sprites)
are a good example for this.
