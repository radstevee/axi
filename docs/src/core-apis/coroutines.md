# Coroutine Integration

Axi provides great coroutine integration to Minecraft
using [MCCoroutine ↗](https://github.com/Shynixn/MCCoroutine).

## Extensions

Axi adds the following extensions:

- `AxiPlugin.coroutineScope`: The coroutine scope of the plugin
- `AxiPlugin.syncContext`: The synchronously executed coroutine
  context of the plugin, with an exception handler that prints
  stack traces for coroutine exceptions
- `AxiPlugin.asyncContext`: The asynchronously executed coroutine
  context of the plugin, with an exception handler that prints
  stack traces for coroutine exceptions
- `AxiPlugin.sync`: Launches a synchronously executed job
- `AxiPlugin.async`: Launches an asynchronously executed job
- `AxiPlugin.syncContext()`: Switches to the `AxiPlugin.syncContext`
- `AxiPlugin.asyncContext()`: Switches to the `AxiPlugin.asyncContext`

All of these exist on the top-level as well, for the main
Axi plugin (See `AxiPluginHolder`).

## Suspending Events

You can register event handlers with suspending handler functions using
`AxiPlugin.registerEventListeners`.
