# Quickstart

## Adding the repository

This guide assumes you already have set up a Kotlin project.

First, you will need to add the repository using your build tool:

::: code-group

```kts [build.gradle.kts]
repositories {
    maven("https://maven.radsteve.net/public")
}
```

```groovy [build.gradle]
repositories {
    maven {
        url 'https://maven.radsteve.net/public'
    }
}
```

```xml [pom.xml]
<repositories>
    <repository>
        <id>rad-public</id>
        <url>https://maven.radsteve.net/public</url>
    </repository>
</repositories>
```

:::

## Adding the dependency

Then, you are going to add the BOM and dependencies:

::: info
Replace `VERSION` with your desired version of Axi.
:::

::: code-group

```kts [build.gradle.kts]
dependencies {
  implementation(platform("net.radstevee.axi:axi-bom:VERSION"))
  implementation("net.radstevee.axi:axi-core")
}
```

```groovy [build.gradle]
dependencies {
  implementation platform('net.radstevee.axi:axi-bom:VERSION')
  implementation 'net.radstevee.axi:axi-core'
}
```

```xml [pom.xml]
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>net.radstevee.axi</groupId>
      <artifactId>axi-bom</artifactId>
      <version>VERSION</version>
      <scope>import</scope>
      <type>pom</type>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>net.radstevee.axi</groupId>
    <artifactId>axi-core</artifactId>
  </dependency>
</dependencies>
```

:::

## Applying Shadow

If you would like to shade Axi (bundle it into your jar),
do it like this:

::: code-group

```kts [build.gradle.kts]
plugins {
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

```groovy [build.gradle]
plugins {
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

```xml [pom.xml]
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-shade-plugin</artifactId>
      <version>3.6.0</version>
      <executions>
        <execution>
          <phase>package</phase>
          <goals>
            <goal>shade</goal>
          </goals>
          <configuration>
            <relocations>
              <relocation>
                <pattern>net.radstevee.axi</pattern>
                <shadedPattern>my.axi.plugin.relocated.axi</shadedPattern>
              </relocation>
              <relocation>
                <pattern>kotlin</pattern>
                <shadedPattern>my.axi.plugin.relocated.kotlin</shadedPattern>
              </relocation>
              <relocation>
                <pattern>kotlinx</pattern>
                <shadedPattern>my.axi.plugin.relocated.kotlinx</shadedPattern>
              </relocation>
            </relocations>
          </configuration>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
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

```xml [pom.xml]

<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>my.axi.plugin</groupId>
  <artifactId>my-axi-plugin</artifactId>
  <version>0.0.0</version>
  <packaging>jar</packaging>
  
  <properties>
    <java.version>21</java.version>
    <kotlin.version>2.1.10</kotlin.version>
  </properties>

  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>net.radstevee.axi</groupId>
        <artifactId>axi-bom</artifactId>
        <version>VERSION</version>
        <scope>import</scope>
        <type>pom</type>
      </dependency>
    </dependencies>
  </dependencyManagement>

  <dependencies>
    <dependency>
      <groupId>net.radstevee.axi</groupId>
      <artifactId>axi-core</artifactId>
    </dependency>
    <dependency>
      <groupId>io.papermc.paper</groupId>
      <artifactId>paper-api</artifactId>
      <version>1.21.4-R0.1-SNAPSHOT</version>
      <scope>provided</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.6.0</version>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
            <configuration>
              <relocations>
                <relocation>
                  <pattern>net.radstevee.axi</pattern>
                  <shadedPattern>my.axi.plugin.relocated.axi</shadedPattern>
                </relocation>
                <relocation>
                  <pattern>kotlin</pattern>
                  <shadedPattern>my.axi.plugin.relocated.kotlin</shadedPattern>
                </relocation>
                <relocation>
                  <pattern>kotlinx</pattern>
                  <shadedPattern>my.axi.plugin.relocated.kotlinx</shadedPattern>
                </relocation>
              </relocations>
            </configuration>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <artifactId>kotlin-maven-plugin</artifactId>
        <groupId>org.jetbrains.kotlin</groupId>
        <version>${kotlin.version}</version>
        <executions>
          <execution>
            <id>compile</id>
            <goals>
              <goal>compile</goal>
            </goals>
            <configuration>
              <sourceDirs>
                <sourceDir>${project.basedir}/src/main/kotlin</sourceDir>
              </sourceDirs>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
</project>
```

:::
