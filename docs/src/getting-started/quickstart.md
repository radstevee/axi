# Quickstart

This guide will teach you how to set up an axi gradle project.

## Adding the plugins

::: code-group
```kts [build.gradle.kts]
plugins {
  kotlin("jvm") version "2.1.20"
  id("net.radstevee.axi") version "AXI-VERSION"
  // Optional, if you want to use a gradle task to run
  // the paper server.
  id("xyz.jpenilla.run-task") version "2.3.1"
}
```
:::

Replace `AXI-VERSION` with the latest version of axi.

::: info
If you're using `run-task`, you may have to set the server
version of the `runServer` task:

```kt
tasks.runServer {
  minecraftVersion("1.21.4")
}
```
:::

## Adding modules

In this guide, we'll only be adding the `core` module of axi.
To do this, we can use the `axi` gradle extension:

::: code-group
```kts [build.gradle.kts]
plugins {
  kotlin("jvm") version "2.1.20"
  id("net.radstevee.axi") version "AXI-VERSION"
  // Optional, if you want to use a gradle task to run
  // the paper server.
  id("xyz.jpenilla.run-task") version "2.3.1"
}

dependencies {
  axi.modules("core") // [!code focus]
}
```
:::

## Using internals

If you wish to use Paper internals, you can use the `internals`
function in the `axi.paper` extension. You can either use
`internals()` to use the regular Paper dev bundle or you can
pass in the coordinates to your own dev bundle with the
`internals(String)` function. Note that you do not need to
supply a version.

## Using a fork

If you are using a fork of paper, you can use its API instead
using the `api` function in the `axi.paper` extension. It
takes in the coordinates to the API, without the version.

## Creating an axi plugin

Now, you can start creating your plugin:

```kotlin
package my.axi.plugin

class MyPlugin : AxiPlugin() {
  override suspend fun enable() {
    slF4JLogger.info("Welcome to Axi!")
  }
}
```

And of course don't forget to add your `plugin.yml`:

```yml
name: my-plugin
version: 0.1.0
api-version: 1.21.4
main: my.axi.plugin.MyPlugin
```

Now you're good to go!

## Dependencies

If you need a dependency in your plugin, you can use paper's
library loading feature by adding the dependency using the
`axi.runtime` function:

```kts
dependencies {
  axi.runtime("...") // [!code focus]
}
```

## Complete buildscript

::: code-group
```kts [build.gradle.kts]
plugins {
  kotlin("jvm") version "2.1.20"
  id("net.radstevee.axi") version "AXI-VERSION"
  // Optional, if you want to use a gradle task to run
  // the paper server.
  id("xyz.jpenilla.run-task") version "2.3.1"
}

dependencies {
  axi.modules("core")
}

tasks.runServer {
  minecraftVersion("1.21.4")
}
```
:::
