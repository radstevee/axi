apply(plugin = "org.jetbrains.kotlin.jvm")

plugins {
  id("net.radstevee.axi")
  id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "net.radstevee.axi.example"
version = "0.0.0"

axi {
  modules("ui")
}

tasks {
  runServer {
    minecraftVersion("1.21.4")
    jvmArgs("-Dnet.kyori.adventure.text.warnWhenLegacyFormattingDetected=false")
  }

  delete("publish")
}
