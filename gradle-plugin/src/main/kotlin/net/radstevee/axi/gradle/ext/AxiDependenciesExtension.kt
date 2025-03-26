package net.radstevee.axi.gradle.ext

import org.gradle.api.Project
import javax.inject.Inject

public abstract class AxiDependenciesExtension @Inject constructor(
  private val project: Project
) {
  public operator fun invoke(dependencyNotation: Any) {
    val dep = project.dependencies.create(dependencyNotation)
    project.dependencies.add("implementation", dep)
    project.dependencies.add("axiRuntime", dep)
  }
}
