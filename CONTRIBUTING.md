# Contributing to axi

## Creating a new module

First up, create a new subproject:

- Create the directory (We'll name it `my-module` here)
- Add a `build.gradle.kts` with the following content:

```kotlin
plugins {
  axi.kotlin
  axi.paper
}
```

- If you need to access internals (commonly referred to as NMS), add:

```kotlin
axi {
  paper {
    internals()
  }
}
```

- Add the module to the `settings.gradle.kts`:

```kotlin
setOf(
  "core",
  // ...
  "my-module",
).forEach { mod ->
  include(":axi-$mod")
  project(":axi-$mod").projectDir = file(mod)
}
```

- Create a class implementing `AxiModule`
- Add a service provider for your implementation class:

`my-module/src/main/resources/META-INF/services/net.radsteve.axi.mod.AxiModule`:
```
net.radsteve.axi.mymodule.MyModule
```

## Contribution Guidelines

- Always reformat your code with the `:spotless` task
- Always document all public API
- Always test your changes
- Always make sure that submitted code conforms with GPLv3
- Do not submit AI-generated code

## Documentation

Try to use inline KDoc comments for shorter documentation, like such:

```kotlin
/** Ticks and renders this for the given [audience]. */
public fun renderTick(tick: Int, audience: Audience)
```

If it is necessary, you can use full documentation comments:

```kotlin
/**
 * Gets the external address of the server.
 * This method does a network request to `https://checkip.amazonaws.com`.
 *
 * You can specify them manually with the `axi.external_addr` and
 * `axi.external_port` JVM properties.
 */
public fun externalServerAddress(): InetSocketAddress
```

## Bumping the version

To bump the current version of axi, change the `version` property
in the root and the `gradle-plugin`'s `gradle.properties`.
