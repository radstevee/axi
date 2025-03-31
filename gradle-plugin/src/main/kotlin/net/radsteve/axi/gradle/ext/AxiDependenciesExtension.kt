package net.radsteve.axi.gradle.ext

import net.radsteve.axi.gradle.ext.AxiExtension.Companion.axi
import org.gradle.api.Project
import javax.inject.Inject

public abstract class AxiDependenciesExtension @Inject constructor(
  private val project: Project
) {
  /** Adds the given [dependencyNotation] as a runtime and compile-time library. */
  public fun runtime(dependencyNotation: Any) {
    val dep = project.dependencies.create(dependencyNotation)
    project.dependencies.add("implementation", dep)
    project.dependencies.add("axiRuntime", dep)
  }

  /** Adds the given axi [modules]. */
  public fun modules(vararg modules: String) {
    project.axi.modules(*modules)
  }
}
