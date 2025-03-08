import io.papermc.paperweight.userdev.PaperweightUserDependenciesExtension
import org.gradle.kotlin.dsl.the
import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    java
}

val libs = the<LibrariesForLibs>()

repositories {
    maven("https://repo.papermc.io/repository/maven-public")
}

fun Project.paperApi() {
    dependencies {
        add("compileOnly", libs.paper.api)
    }
}

fun Project.paper() {
    apply(plugin = "io.papermc.paperweight.userdev")

    dependencies {
        val paperweight = the<PaperweightUserDependenciesExtension>()
        paperweight.paperDevBundle(libs.versions.paper.get())
    }
}

interface AxiPaperExtension {
    val internals: Property<Boolean>

    fun internals() {
        internals = true
    }
}

extensions.create("axiPaper", AxiPaperExtension::class)

afterEvaluate {
    val ext = the<AxiPaperExtension>()
    if (ext.internals.getOrElse(false)) {
        paper()
    } else {
        paperApi()
    }
}
