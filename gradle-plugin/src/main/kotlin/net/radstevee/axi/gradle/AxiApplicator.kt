package net.radstevee.axi.gradle

import net.radstevee.axi.gradle.ext.AxiExtension
import net.radstevee.axi.gradle.task.DependenciesJson
import org.gradle.api.Project
import org.gradle.internal.extensions.stdlib.capitalized
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.maven
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation

public object AxiApplicator {
  public fun applyTo(project: Project) {
    project.extensions.create("axi", AxiExtension::class.java)

    project.configurations.create("axiRuntime")

    project.repositories.mavenCentral()
    project.repositories.gradlePluginPortal()
    project.repositories.maven(AxiRepos.RAD)
    project.repositories.maven(AxiRepos.PAPER)
    project.repositories.maven(AxiRepos.BRAWLS)
    project.repositories.maven(AxiRepos.INTELLIJ)

    project.afterEvaluate(::applyAfter)
    // applyAfter(project)
  }

  private fun applyAfter(project: Project) {
    val axi = project.the<AxiExtension>()
    AxiDependencies.applyTo(project, axi)
  }

  public fun applyTo(compilation: KotlinCompilation<*>) {
    val project = compilation.project

    val taskName = "dependenciesJson" + compilation.name.capitalized()
    val outputFile = compilation.output.resourcesDir.resolve("axi-dependencies.json")

    val depsTask = project.tasks.register(taskName, DependenciesJson::class.java, outputFile)
    project.tasks["build"].dependsOn(depsTask)
  }
}
