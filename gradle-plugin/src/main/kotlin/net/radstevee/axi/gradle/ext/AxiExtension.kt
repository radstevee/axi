package net.radstevee.axi.gradle.ext

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.tasks.Nested
import org.gradle.kotlin.dsl.the

public abstract class AxiExtension {
  public val moduleDeps: MutableList<String> = mutableListOf()

  public fun modules(vararg modules: String) {
    moduleDeps.addAll(modules)
  }

  @get:Nested
  public abstract val versions: AxiVersionExtension

  public fun versions(action: Action<AxiVersionExtension>) {
    action.execute(versions)
  }

  @get:Nested
  public abstract val paper: AxiPaperExtension

  public fun paper(action: Action<AxiPaperExtension>) {
    action.execute(paper)
  }

  internal companion object {
    val Project.axi get() = the<AxiExtension>()
  }
}
