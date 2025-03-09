plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

rootProject.name = "axi-parent"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

setOf(
    "core",
    "bom",
    "ksp",
    "example",
).forEach { mod ->
    include(":axi-$mod")
    project(":axi-$mod").projectDir = file(mod)
}
