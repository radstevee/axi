# Applying KSP

This guide will teach you how to set up KSP and Axi's KSP
processor, for automatically registering commands and
more to come.

## Applying the plugin

Apply the plugin to your buildscript:

::: code-group

```kts [build.gradle.kts]
plugins {
  id("com.google.devtools.ksp") version "2.1.20-1.0.31"
}
```

```groovy [build.gradle]
plugins {
  id 'com.google.devtools.ksp' version '2.1.20-1.0.31'
}
```

:::

## Add the processor

Add the processor to your dependencies:

::: code-group

```kts{2} [build.gradle.kts]
dependencies {
  ksp("net.radstevee.axi:axi-ksp")
}
```

```groovy{2} [build.gradle]
dependencies {
  ksp 'net.radstevee.axi:axi-ksp'
}
```

:::

::: warning
If you are using shadow, you may have to change
your shaded archive classifier:

::: code-group

```kts{3} [build.gradle.kts]
tasks {
  shadowJar {
    archiveClassifier = ""
  }
}
```

```groovy{3} [build.gradle]
tasks {
  shadowJar {
    archiveClassifier = ''
  }
}
```

:::
