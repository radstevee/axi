plugins {
  id("com.gradleup.shadow") version "9.0.0-beta6"
  id("com.gradle.plugin-publish") version "1.2.1"
  id("net.kyori.blossom") version "2.1.0"

  `kotlin-dsl`
  `embedded-kotlin`
  `java-gradle-plugin`
}

group = "net.radstevee.axi"
version = rootProject.property("version") as String

repositories {
  mavenCentral()
  gradlePluginPortal()
}

dependencies {
  compileOnly(libs.bundles.kgp)
  implementation(libs.plugin.paperweight)
  implementation(libs.plugin.ksp)
  implementation("org.yaml:snakeyaml:2.4")
}

kotlin {
  explicitApi()
}

tasks {
  shadowJar {
    archiveClassifier = ""
  }

  build {
    dependsOn(shadowJar)
  }

  jar {
    manifest {
      attributes("Implementation-Version" to version)
    }
  }
}

gradlePlugin {
  plugins {
    create("axi") {
      id = "net.radstevee.axi"
      implementationClass = "net.radstevee.axi.gradle.AxiSubplugin"
    }
  }
}

publishing {
  repositories {
    maven {
      name = "radPublic"
      url = uri("https://maven.radsteve.net/public")

      credentials {
        username = System.getenv("RAD_MAVEN_USER")
        password = System.getenv("RAD_MAVEN_TOKEN")
      }
    }
  }
}

sourceSets.main {
  blossom.kotlinSources {
    property("axiVersion", version.toString())
    property("minecraftVersion", libs.versions.paper.get().removeSuffix("-R0.1-SNAPSHOT"))
  }
}
