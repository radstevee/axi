import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.dokka.gradle.tasks.DokkaGeneratePublicationTask
import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
  kotlin("plugin.serialization")
  id("org.jetbrains.dokka")
  id("com.diffplug.spotless")

  `maven-publish`
  `java-library`
}

val libs = the<LibrariesForLibs>()

group = "net.radstevee.axi"
version = rootProject.property("version") as String

dependencies {
  implementation(libs.bundles.kotlinx)
}

repositories {
  mavenCentral()
  maven("https://maven.radsteve.net/public")
  maven("https://maven.mcbrawls.net/releases")
  maven("https://packages.jetbrains.team/maven/p/ij/intellij-dependencies")
}

kotlin {
  jvmToolchain(21)
}

tasks.withType<KotlinCompile> {
  explicitApiMode = ExplicitApiMode.Strict
  compilerOptions.freeCompilerArgs.addAll(
    "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
    "-opt-in=kotlinx.coroutines.DelicateCoroutinesApi",
    "-opt-in=kotlin.contracts.ExperimentalContracts",
    "-Xcontext-receivers",
  )
}

tasks.jar {
  manifest {
    attributes("Implementation-Version" to version)
  }
}

testing {
  suites {
    register("axi-test", JvmTestSuite::class) {
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
      name = "radPublic"
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

spotless {
  kotlin {
    targetExclude("build/generated/**/*")
    toggleOffOn()
    ktlint(libs.versions.ktlint.get())
      .setEditorConfigPath(rootProject.file(".editorconfig"))
  }
}

extensions.create("axi", AxiExtension::class)

afterEvaluate {
  val ext = the<AxiExtension>()

  dependencies {
    ext.deps.forEach { dep ->
      add("compileOnly", project(":axi-$dep"))
    }
  }
}
