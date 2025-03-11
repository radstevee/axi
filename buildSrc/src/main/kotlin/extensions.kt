import org.gradle.api.Action
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Nested

abstract class AxiExtension {
  internal val deps: MutableList<String> = mutableListOf()

  fun dependencies(vararg modules: String) {
    deps.addAll(modules)
  }

  @get:Nested
  abstract val paper: AxiPaperExtension

  fun paper(action: Action<AxiPaperExtension>) {
    action.execute(paper)
  }
}

interface AxiPaperExtension {
  val internals: Property<Boolean>

  fun internals() {
    internals.set(true)
  }
}
