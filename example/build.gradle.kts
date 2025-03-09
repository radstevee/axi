plugins {
    id("axi.kotlin-conventions")
    id("axi.paper-conventions")
    id("com.google.devtools.ksp") version "2.1.10-1.0.31"
    id("com.gradleup.shadow") version "9.0.0-beta6"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "net.radstevee.axi.example"
version = "0.0.0"

dependencies {
    ksp(project(":axi-ksp"))
    implementation(project(":axi-core"))
}

tasks {
    shadowJar {
        archiveClassifier = ""
    }

    assemble {
        dependsOn(shadowJar)
    }

    runServer {
        minecraftVersion("1.21.4")
    }
}
