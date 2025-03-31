package net.radsteve.axi.gradle.task

import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.com.google.gson.Gson
import java.io.File
import java.net.URI
import javax.inject.Inject

public abstract class DependenciesJson @Inject constructor(
    private val output: File,
    private val project: Project,
) : DefaultTask() {
  private data class DepsFile(
    val repos: Set<String>,
    val deps: Set<String>,
  )

  @TaskAction
  public fun run() {
    val deps = project.configurations["axiRuntime"]
      .dependencies
      .map { dep ->
        "${dep.group}:${dep.name}:${dep.version}"
      }
    val repos = project.repositories
      .filterIsInstance<MavenArtifactRepository>()
      .map(MavenArtifactRepository::getUrl)
      .map(URI::toString)

    output.parentFile.mkdirs()
    output.createNewFile()

    val depsFile = DepsFile(repos.toSet(), deps.toSet())
    val json = Gson().toJson(depsFile)

    output.writeText(json)
  }
}
