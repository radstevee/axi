package net.radstevee.axi.gradle.ext

import org.gradle.api.Action
import org.gradle.api.tasks.Nested

public abstract class AxiExtension {
  internal val moduleDeps: MutableList<String> = mutableListOf("core")

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
}
