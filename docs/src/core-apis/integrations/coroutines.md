# Coroutine Integration

Axi provides great coroutine integration to Minecraft
using [MCCoroutine ↗](https://github.com/Shynixn/MCCoroutine).

::: warning
Do not shade your own version of `kotlinx.coroutines`. This
may break Axi as it relies on IntelliJ's internal fork of
`kotlinx.coroutines` and leverages some of its internal
coroutine API.
:::

## Extensions

Axi adds the following extensions:

- `AxiPlugin.coroutineScope`: The coroutine scope of the
  plugin
- `AxiPlugin.syncContext`: The synchronously executed
  coroutine
  context of the plugin, with an exception handler that
  prints
  stack traces for coroutine exceptions
- `AxiPlugin.asyncContext`: The asynchronously executed
  coroutine
  context of the plugin, with an exception handler that
  prints
  stack traces for coroutine exceptions
- `AxiPlugin.sync`: Launches a synchronously executed job
- `AxiPlugin.async`: Launches an asynchronously executed job
- `AxiPlugin.syncContext()`: Switches to the
  `AxiPlugin.syncContext`
- `AxiPlugin.asyncContext()`: Switches to the
  `AxiPlugin.asyncContext`

All of these exist for the main plugin as well with the 
`AxiCoroutines` object.

## Suspending Events

You can register event handlers with suspending handler
functions using
`AxiPlugin.registerEventListeners`.

There is also another utility provided by Axi:
`SuspendingListener`, an interface that implements `Listener` 
and is a synchronous `CoroutineScope`. This is useful if you 
want to launch jobs in your events.
