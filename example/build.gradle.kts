plugins {
  id("net.radsteve.axi")
  id("xyz.jpenilla.run-paper") version "2.3.1"
  id("com.gradleup.shadow") version "9.0.0-beta6"
  kotlin("jvm")
}

group = "net.radsteve.axi.example"
version = rootProject.version

dependencies {
  // We're not using the axi gradle plugin here because
  // we need this to be local so I don't have to spam
  // my maven repository. You probably don't want to
  // do this if you're a regular API user and are not
  // 100% certain that you need axi shaded into your plugin.
  implementation(project(":axi-core"))
  implementation(project(":axi-ui"))
  implementation(project(":axi-game"))
}

kotlin {
  jvmToolchain(21)
  explicitApi()
}

axi {
  paper {
    internals()
  }
}

tasks {
  runServer {
    minecraftVersion("1.21.4")
    jvmArgs("-Dnet.kyori.adventure.text.warnWhenLegacyFormattingDetected=false")
  }

  shadowJar {
    mergeServiceFiles()

    dependencies {
      // Dependencies we know are contained in the Minecraft server that we do not need
      // nor want to shade. fastutil is a big one at 25mb compressed
      val excluded = setOf("com.google", "com.ibm", "org.apache", "it.unimi", "com.mojang", "org.jetbrains.annotations", "org.slf4j")

      exclude { dep ->
        excluded.any { excluded -> excluded in dep.name.replace(":", ".") }
      }
    }
  }

  delete("publish")
}
