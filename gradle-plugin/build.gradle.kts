plugins {
  id("com.gradleup.shadow") version "9.0.0-beta6"
  id("com.gradle.plugin-publish") version "1.2.1"

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
//  publications {
//    create<MavenPublication>("mavenJava") {
//      from(components["java"])
//    }
//  }

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
