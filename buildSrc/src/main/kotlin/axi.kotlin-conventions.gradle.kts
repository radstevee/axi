import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.invoke
import org.jetbrains.dokka.gradle.tasks.DokkaGeneratePublicationTask

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jetbrains.dokka")

    `maven-publish`
    `java-library`
}

val libs = the<LibrariesForLibs>()

group = "net.radstevee.axi"
version = rootProject.property("version") as String

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<KotlinCompile>().configureEach {
    explicitApiMode = ExplicitApiMode.Strict
}

testing {
    suites {
        register("jvm-test", JvmTestSuite::class) {
            useKotlinTest(libs.versions.kotlin.get())

            dependencies {
                implementation(libs.kotlinx.coroutines.test)
            }
        }
    }
}

val dokkaJar = tasks.register<Jar>("dokkaHtmlJar") {
    dependsOn(tasks.dokkaGeneratePublicationHtml)
    from(tasks.dokkaGeneratePublicationHtml.flatMap(DokkaGeneratePublicationTask::outputDirectory))
    archiveClassifier.set("javadoc")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            artifact(tasks.getByName("kotlinSourcesJar")) {
                classifier = "sources"
            }

            artifact(dokkaJar) {
                classifier = "javadoc"
            }
        }
    }

    repositories {
        maven {
            name = "rad-public"
            url = uri("https://maven.radsteve.net/public")

            credentials {
                username = System.getenv("RAD_MAVEN_USER")
                password = System.getenv("RAD_MAVEN_TOKEN")
            }
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
