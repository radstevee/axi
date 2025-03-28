plugins {
  id("net.radstevee.axi")
  id("xyz.jpenilla.run-paper") version "2.3.1"
  id("com.gradleup.shadow") version "9.0.0-beta6"
  kotlin("jvm")
}

group = "net.radstevee.axi.example"
version = rootProject.version

dependencies {
  // We're not using the axi plugin here because
  // we need this to be local so I don't have to spam
  // my maven repository
  implementation(project(":axi-core"))
  implementation(project(":axi-ui"))
}

kotlin {
  jvmToolchain(21)
  explicitApi()
}

tasks {
  runServer {
    minecraftVersion("1.21.4")
    jvmArgs("-Dnet.kyori.adventure.text.warnWhenLegacyFormattingDetected=false")
  }

  delete("publish")
}
