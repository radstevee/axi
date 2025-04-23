package net.radsteve.axi.gradle.ext

import net.radsteve.axi.gradle.ext.AxiExtension.Companion.axi
import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.provider.Provider
import javax.inject.Inject

public abstract class AxiDependenciesExtension @Inject constructor(
  private val project: Project
) {
  /** Adds the given [dependencyNotation] as a runtime and compile-time library. */
  public fun runtime(dependencyNotation: Any) {
    val dep = project.dependencies.create(dependencyNotation)
    project.dependencies.add("axiRuntime", dep)
    project.dependencies.add("compileOnly", dep)
  }

  /** Adds the given [provider] as a runtime and compile-time library. */
  public fun runtimeProvider(provider: Provider<out ExternalModuleDependency>) {
    project.dependencies.addProvider("axiRuntime", provider)
    project.dependencies.addProvider("compileOnly", provider)
  }

  /** Adds the given [bundleProvider] as a runtime and compile-time library. */
  @JvmName("runtimeBundle")
  public fun runtimeProvider(bundleProvider: Provider<ExternalModuleDependencyBundle>) {
    project.dependencies.addProvider("axiRuntime", bundleProvider)
    project.dependencies.addProvider("compileOnly", bundleProvider)
  }

  /** Adds the given axi [modules]. */
  public fun modules(vararg modules: String) {
    project.axi.modules(*modules)
  }
}
