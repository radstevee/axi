package net.radstevee.axi.gradle

import net.radstevee.axi.gradle.ext.AxiDependenciesExtension
import net.radstevee.axi.gradle.ext.AxiExtension
import net.radstevee.axi.gradle.task.DependenciesJson
import net.radstevee.axi.gradle.task.ProcessPluginYaml
import org.gradle.api.Project
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.tasks.bundling.Jar
import org.gradle.internal.extensions.stdlib.capitalized
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.maven
import org.gradle.kotlin.dsl.the
import org.gradle.language.jvm.tasks.ProcessResources
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation

public object AxiApplicator {
  public fun applyTo(project: Project): Unit = with(project) {
    extensions.create("axi", AxiExtension::class.java)
    dependencies.extensions.create("axiDependency", AxiDependenciesExtension::class.java, project)

    configurations.create("axiRuntime")

    repositories.mavenCentral()
    repositories.gradlePluginPortal()
    repositories.maven(AxiRepos.RAD)
    repositories.maven(AxiRepos.PAPER)
    repositories.maven(AxiRepos.BRAWLS)
    repositories.maven(AxiRepos.INTELLIJ)

    afterEvaluate(::applyAfter)
  }

  private fun applyAfter(project: Project) = with(project) {
    configurations["axiRuntime"]
      .extendsFrom(configurations["compileClasspath"])
      .extendsFrom(configurations["runtimeClasspath"])

    val axi = the<AxiExtension>()
    AxiDependencies.applyTo(project, axi)
  }

  public fun applyTo(compilation: KotlinCompilation<*>) {
    val project = compilation.project
    val taskName = "dependenciesJson" + compilation.name.capitalized()
    val outputFile = compilation.output.resourcesDir.resolve("axi-dependencies.json")
    val depsTask = project.tasks.register(taskName, DependenciesJson::class.java, outputFile)
    val processTask = project.tasks.register("processPluginYaml", ProcessPluginYaml::class.java, compilation)

    project.tasks.withType(Jar::class.java) {
      dependsOn("processResources")
      dependsOn(depsTask)
    }

    project.tasks.withType(ProcessResources::class.java) {
      dependsOn(processTask)

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
