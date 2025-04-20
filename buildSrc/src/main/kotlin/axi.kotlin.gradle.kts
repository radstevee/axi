import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.dokka.gradle.tasks.DokkaGeneratePublicationTask
import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
  kotlin("plugin.serialization")
  id("org.jetbrains.dokka")
  id("org.jlleitschuh.gradle.ktlint")
  id("axi.publishing.repositories")

  `maven-publish`
  `java-library`
}

val libs = the<LibrariesForLibs>()

group = "net.radsteve.axi"
version = rootProject.property("version") as String

dependencies {
  implementation(libs.bundles.kotlinx)

  ktlintRuleset(libs.ktlint.extras)
}

repositories {
  mavenCentral()
  maven("https://maven.radsteve.net/public")
  maven("https://maven.mcbrawls.net/releases")
  maven("https://maven.enginehub.org/repo")
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
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

ktlint {
  version = libs.versions.ktlint.asProvider()

  filter {
    exclude("**/generated/**")
    include("**/kotlin/**")
  }

  additionalEditorconfig.set(
    mapOf(
      "insert_final_newline" to "true",
      "end_of_line" to "lf",
      "indent_size" to "2",
      "indent_style" to "space",
      "max_line_length" to "off",
      "ktlint_function_signature_body_expression_wrapping" to "default",
      "ktlint_code_style" to "intellij_idea",
      "ktlint_experimental" to "enabled",
      "ktlint_standard_multiline-expression-wrapping" to "disabled",
      "ktlint_standard_property-wrapping" to "disabled",
      "ktlint_standard_condition-wrapping" to "disabled",
      "ktlint_standard_function-expression-body" to "disabled",
      "ktlint_standard_if-else-bracing" to "enabled",
    )
  )
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
