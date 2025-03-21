plugins {
  id("axi.kotlin-conventions")
  id("axi.paper-conventions")
  id("com.google.devtools.ksp") version "2.1.20-1.0.31"
  id("com.gradleup.shadow") version "9.0.0-beta6"
  id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "net.radstevee.axi.example"
version = "0.0.0"

repositories {
  mavenCentral()
  maven("https://maven.radsteve.net/public")
  maven("https://maven.mcbrawls.net/releases")
}

dependencies {
  ksp(projects.axiKsp)
  api(projects.axiCore)
  api(projects.axiUi)
  api(libs.bundles.packed)
}

tasks {
  shadowJar {
    archiveClassifier = ""

    dependencies {
      // Dependencies we know are contained in the Minecraft server that we do not need
      // nor want to shade. fastutil is a big one at 25mb compressed
      val excluded = setOf("com.google", "org.apache", "it.unimi", "com.mojang", "org.jetbrains.annotations", "org.slf4j")

      exclude { dep ->
        excluded.any { excluded -> excluded in dep.name.replace(":", ".") }
      }
    }
  }

  assemble {
    dependsOn(shadowJar)
  }

  runServer {
    minecraftVersion("1.21.4")
    jvmArgs("-Dnet.kyori.adventure.text.warnWhenLegacyFormattingDetected=false")
  }
}
