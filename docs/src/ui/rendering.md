# Rendering API

Axi provides a very extensible rendering API allowing you to
render elements on a player's screen, be it an action bar,
the chat or a boss bar.

## Writing your own Renderable

To make your own renderable element, you have to implement
the `RedrawableRenderable` interface.

## Writing a render function

First up, we have to implement the `render` function. The
`render` function is a suspending function that gets called
on every redraw by this renderable and returns the contents
that should be rendered on the player's screen.

In our case, this will just return the current tick of the
server:

```kt
object TickDisplay : RedrawableRenderable {
  override suspend fun render(): TextComponent = buildText {
    append(Bukkit.getCurrentTick())
    green()
  }
}
```

## Writing a tick function

This tick function will handle our redrawing logic. The
`tickRedraw` function takes in the current `tick` of the
server and returns a `RedrawResult`. This can either be
`Redraw`, which forces this redrawable to be redrawn,
`Dispose`, which removes this redrawable from the player's
render state or `None` which does nothing.

Let's redraw our tick display every other tick:

```kt
object TickDisplay : RedrawableRenderable {
  override suspend fun render(): TextComponent = buildText {
    append(Bukkit.getCurrentTick())
    green()
  }
  
  override suspend fun tickRedraw(tick: Int): RedrawResult {
    return if (tick % 2 == 0) {
      RedrawResult.Redraw
    } else {
      RedrawResult.None
    }
  }
}
```

Great! This will display the current server tick ten times a
second.

## Writing a renderer

Axi currently provides two built-in renderers:

- `Renderer.Actionbar`, which sends the stacked rendered
component to an audience's action bar
- `Renderer.Chat`, which "clears" an audience's chat by
sending 16 empty lines and the stacked rendered component to
an audience's chat.

For the sake of this guide, let's re-implement the `Actionbar`
renderer ourselves. `Renderer` is a functional interface that
takes in an audience, the current renderable, and the already
rendered stacked component.

```kt
val Actionbar = Renderer { audience, renderable, stacked ->
}
```

Now, let's actually send the stacked component using adventure's
API:

```kt
val Actionbar = Renderer { audience, renderable, stacked ->
  audience.sendActionBar(stacked)
}
```

Well, that was quite simple. Now let's actually use it in our
renderable!

## Using a renderer

To use a renderer in our redrawable, we have to override the
`renderer` field:

```kt
object TickDisplay : RedrawableRenderable {
  override suspend fun render(): TextComponent = buildText {
    append(Bukkit.getCurrentTick())
    green()
  }

  override suspend fun tickRedraw(tick: Int): RedrawResult {
    return if (tick % 2 == 0) {
      RedrawResult.Redraw
    } else {
      RedrawResult.None
    }
  }
  
  override val renderer: Renderer = Renderer.Actionbar
}
```

## Displaying our renderable

Now, let's actually display our renderable. To do this, we
simply add it to an `Attachable`'s `RenderStateComponent`:

```kt
player.renderState.currentlyRenderedRenderables.add(TickDisplay)
```

Axi also provides a utility for this:

```kt
player.addRenderable(TickDisplay)
```
