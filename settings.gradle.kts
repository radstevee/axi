enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

rootProject.name = "axi-parent"

dependencyResolutionManagement {
  repositories {
    mavenCentral()
    maven("https://packages.jetbrains.team/maven/p/ij/intellij-dependencies")
  }
}

setOf(
  "core",
  "bom",
  "ksp",
  "example",
  "ui",
).forEach { mod ->
  include(":axi-$mod")
  project(":axi-$mod").projectDir = file(mod)
}
