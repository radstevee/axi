# Quickstart

This guide will teach you how to set up axi for your own project.

## Adding the repository

This guide assumes you already have set up a Kotlin/PaperMC project.

<details>

<summary>Basic empty project</summary>

::: code-group

```kts [build.gradle.kts]
plugins {
  kotlin("jvm") version "2.1.10"
}

repositories {
  maven("https://repo.papermc.io/repository/maven-public")
}

dependencies {
  compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
}

kotlin {
  jvmToolchain(21)
}
```

```groovy [build.gradle]
plugins {
  id 'org.jetbrains.kotlin.jvm' version '2.1.10'
}

repositories {
  maven { url 'https://repo.papermc.io/repository/maven-public' }
}

dependencies {
  compileOnly 'io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT'
}

kotlin {
  jvmToolchain 21
}
```

:::

</details>

First, you will need to add the repository using your build tool:

::: code-group

```kts{3} [build.gradle.kts]
repositories {
  maven("https://repo.papermc.io/repository/maven-public")
  maven("https://maven.radsteve.net/public")
}
```

```groovy{3} [build.gradle]
repositories {
  maven { url 'https://repo.papermc.io/repository/maven-public' }
  maven { url 'https://maven.radsteve.net/public' }
}
```

:::

## Adding the dependency

Then, you are going to add the BOM and dependencies:

::: info
Replace `VERSION` with your desired version of Axi.
:::

::: code-group

```kts{2,3} [build.gradle.kts]
dependencies {
  implementation(platform("net.radstevee.axi:axi-bom:VERSION"))
  implementation("net.radstevee.axi:axi-core")

  compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
}
```

```groovy{2,3} [build.gradle]
dependencies {
  implementation platform('net.radstevee.axi:axi-bom:VERSION')
  implementation 'net.radstevee.axi:axi-core'

  compileOnly 'io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT'
}
```

:::

## Applying Shadow

If you would like to shade Axi (bundle it into your jar),
do it like this:

::: code-group

```kts{3,6-18} [build.gradle.kts]
plugins {
  kotlin("jvm") version "2.1.10"
  id("com.gradleup.shadow") version "9.0.0-beta6"
}

tasks {
  shadowJar {
    relocate("net.radstevee.axi", "my.axi.plugin.relocated.axi")
    relocate("kotlin", "my.axi.plugin.relocated.kotlin")
    relocate("kotlinx", "my.axi.plugin.relocated.kotlinx")
  }
 
  assemble {
    dependsOn(shadowJar)
  }
}
```

```groovy{3,6-18} [build.gradle]
plugins {
  id 'org.jetbrains.kotlin.jvm' version '2.1.10'
  id 'com.gradleup.shadow' version '9.0.0-beta6'
}

tasks {
  shadowJar {
    relocate 'net.radstevee.axi', 'my.axi.plugin.relocated.axi'
    relocate 'kotlin', 'my.axi.plugin.relocated.kotlin'
    relocate 'kotlinx', 'my.axi.plugin.relocated.kotlinx'
  }

  assemble {
    dependsOn shadowJar
  }
}
```

:::

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
version: 0.0.0
api-version: 1.21.4
main: my.axi.plugin.MyPlugin
```

Now you're good to go!

## Complete build setups

::: code-group

```kts [build.gradle.kts]
plugins {
  kotlin("jvm") version "2.1.10"
  id("com.gradleup.shadow") version "9.0.0-beta6"
}

repositories {
  maven("https://maven.radsteve.net/public")
  maven("https://repo.papermc.io/repository/maven-public")
}

dependencies {
  implementation(platform("net.radstevee.axi:axi-bom:VERSION"))
  implementation("net.radstevee.axi:axi-core")
  compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
}

tasks {
  shadowJar {
    relocate("net.radstevee.axi", "my.axi.plugin.relocated.axi")
    relocate("kotlin", "my.axi.plugin.relocated.kotlin")
    relocate("kotlinx", "my.axi.plugin.relocated.kotlinx")
  }

  assemble {
    dependsOn(shadowJar)
  }
}

kotlin {
  jvmToolchain(21)
}
```

```groovy [build.gradle]
plugins {
  id 'org.jetbrains.kotlin.jvm' version '2.1.10'
  id 'com.gradleup.shadow' version '9.0.0-beta6'
}

repositories {
  maven { url 'https://maven.radsteve.net/public' }
  maven { url 'https://repo.papermc.io/repository/maven-public' }
}

dependencies {
  implementation platform('net.radstevee.axi:axi-bom:VERSION')
  implementation 'net.radstevee.axi:axi-core'
  compileOnly 'io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT'
}

tasks {
  shadowJar {
    relocate 'net.radstevee.axi', 'my.axi.plugin.relocated.axi'
    relocate 'kotlin', 'my.axi.plugin.relocated.kotlin'
    relocate 'kotlinx', 'my.axi.plugin.relocated.kotlinx'
  }

  assemble {
    dependsOn shadowJar
  }
}

kotlin {
  jvmToolchain 21
}
```

:::
