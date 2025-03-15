# Applying KSP

You'll need to apply Axi's KSP processor for some things, like:

- Automatically registering commands

::: warning
KSP can only be applied to Gradle projects!
:::

## Applying the Gradle plugin

Apply the plugin to your buildscript:

::: code-group

```kts [build.gradle.kts]
plugins {
  id("com.google.devtools.ksp") version "2.1.10-1.0.31"
}
```

```groovy [build.gradle]
plugins {
  id 'com.google.devtools.ksp' version '2.1.10-1.0.31'
}
```

:::

## Add the processor

Add the processor to your dependencies:

::: code-group

```kts [build.gradle.kts]
dependencies {
  ksp("net.radstevee.axi:axi-ksp")
}
```

```groovy [build.gradle]
dependencies {
  ksp 'net.radstevee.axi:axi-ksp'
}
```

:::


::: warning
If you are using shadow, you may have to change
your shaded archive classifier:

::: code-group

```kts [build.gradle.kts]
tasks.shadowJar {
  archiveClassifier = ""
}
```

```groovy [build.gradle]
tasks.shadowJar {
  archiveClassifier = ''
}
```

:::
