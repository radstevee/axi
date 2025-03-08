plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

rootProject.name = "axi-parent"

setOf(
    "core",
    "coroutines",
    "bom",
).forEach { mod ->
    include("axi-$mod")
    project(":axi-$mod").projectDir = file(mod)
}
