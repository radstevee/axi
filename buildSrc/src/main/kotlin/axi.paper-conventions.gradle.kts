import io.papermc.paperweight.userdev.PaperweightUser
import io.papermc.paperweight.userdev.PaperweightUserDependenciesExtension
import org.gradle.accessors.dm.LibrariesForLibs

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
    apply<PaperweightUser>()

    dependencies {
        val paperweight = the<PaperweightUserDependenciesExtension>()
        paperweight.paperDevBundle(libs.versions.paper.get())
    }
}

afterEvaluate {
    val axi = the<AxiExtension>()
    val paper = axi.paper
    if (paper.internals.getOrElse(false)) {
        paper()
    } else {
        paperApi()
    }
}
