package net.radsteve.axi.gradle

import com.google.devtools.ksp.gradle.KspAATask
import net.radsteve.axi.gradle.ext.AxiDependenciesExtension
import net.radsteve.axi.gradle.ext.AxiExtension
import net.radsteve.axi.gradle.ext.AxiExtension.Companion.axi
import net.radsteve.axi.gradle.task.DependenciesJson
import net.radsteve.axi.gradle.task.ProcessPluginYaml
import org.gradle.api.Project
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.tasks.bundling.Jar
import org.gradle.internal.extensions.stdlib.capitalized
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.maven
import org.gradle.kotlin.dsl.withType
import org.gradle.language.jvm.tasks.ProcessResources
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation

public object AxiApplicator {
  public fun applyTo(project: Project): Unit = with(project) {
    extensions.create("axi", AxiExtension::class.java)
    dependencies.extensions.create("axi", AxiDependenciesExtension::class.java, project)

    configurations.create("axiRuntime")

    repositories.mavenCentral()
    repositories.gradlePluginPortal()
    repositories.maven(AxiRepos.RAD)
    repositories.maven(AxiRepos.PAPER)
    repositories.maven(AxiRepos.BRAWLS)
    repositories.maven(AxiRepos.ENGINEHUB)
    repositories.maven(AxiRepos.INTELLIJ)
    repositories.maven(AxiRepos.FABRIC)

    afterEvaluate(::applyAfter)
  }

  private fun applyAfter(project: Project) = with(project) {
    configurations["axiRuntime"]
      .extendsFrom(configurations["compileClasspath"])
      .extendsFrom(configurations["runtimeClasspath"])

    AxiDependencies.applyTo(project, axi)

    tasks.withType<KspAATask> {
      outputs.upToDateWhen { false }
    }
  }

  public fun applyTo(compilation: KotlinCompilation<*>) {
    val project = compilation.project
    val depsTaskName = "dependenciesJson" + compilation.name.capitalized()
    val processTaskName = "processPluginYaml" + compilation.name.capitalized()
    val outputFile = compilation.output.resourcesDir.resolve("axi-dependencies.json")
    val depsTask = project.tasks.register(depsTaskName, DependenciesJson::class.java, outputFile)
    val processTask = project.tasks.register(processTaskName, ProcessPluginYaml::class.java, compilation)

    project.tasks.withType(Jar::class.java) {
      dependsOn(processTask)
      dependsOn("processResources")
      dependsOn(depsTask)
    }

    project.tasks.withType(ProcessResources::class.java) {
      duplicatesStrategy = DuplicatesStrategy.INCLUDE

      exclude("plugin.yml")
      // we exclude the default plugin yml's
      from(compilation.defaultSourceSet.resources.sourceDirectories.singleFile) {
        exclude("paper-plugin.yml")
      }
      // to add our own
      from(compilation.output.resourcesDir) {
        include("paper-plugin.yml")
      }
      // bit cursed but we need to run the task again to override the files back
      doLast {
        processTask.get().run()
      }
    }
  }
}
