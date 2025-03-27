plugins {
  id("net.radstevee.axi")
  id("xyz.jpenilla.run-paper") version "2.3.1"
  kotlin("jvm")
}

group = "net.radstevee.axi.example"
version = "0.0.0"

dependencies {
  axi.modules("core", "ui")
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
