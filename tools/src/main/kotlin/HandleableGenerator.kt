import io.github.classgraph.ClassGraph
import org.bukkit.event.Event
import kotlin.io.path.Path
import kotlin.io.path.writeText
import kotlin.reflect.full.hasAnnotation

public fun main() {
  ClassGraph().enableAllInfo().scan().use { result ->
    val eventClasses = result.getSubclasses(Event::class.java).loadClasses().map(Class<*>::kotlin)

    val code = buildString {
      appendLine("// THIS FILE IS AUTO-GENERATED! DO NOT MODIFY!")
      appendLine("// spotless:off")
      appendLine("@file:Suppress(\"SpellCheckingInspection\")")
      appendLine("package net.radsteve.axi.event")
      appendLine()

      appendLine("import kotlinx.coroutines.CoroutineScope")
      appendLine("import net.radsteve.axi.coroutines.AxiCoroutines")
      appendLine("import kotlin.coroutines.CoroutineContext")

      appendLine()
      appendLine("/** Something that can handle events. */")
      appendLine("public interface Handleable {")
      appendLine("  /** The coroutine context for these events. */")
      appendLine("  public val coroutineContext: CoroutineContext get() = AxiCoroutines.syncContext")
      appendLine()
      appendLine("  /** The coroutine scope these events run on. */")
      appendLine("  public val coroutineScope: CoroutineScope get() = CoroutineScope(coroutineContext)")
      appendLine()
      eventClasses.forEachIndexed { idx, klass ->
        if (klass.typeParameters.isNotEmpty()) {
          return@forEachIndexed
        }

        // We do not want any tick events as we already have systems.
        if ("Tick" in klass.simpleName.toString()) {
          return@forEachIndexed
        }

        // We don't wanna spam our logs
        if (klass.hasAnnotation<java.lang.Deprecated>()) {
          return@forEachIndexed
        }

        if (klass.isAbstract) {
          return@forEachIndexed
        }

        appendLine("  /** Called when a [${klass.qualifiedName}] is called. */")
        appendLine("  public suspend fun on(event: ${klass.qualifiedName}) {}")

        if (idx != eventClasses.size - 1) {
          appendLine()
        }
      }
      appendLine("}")
    }

    val output = Path("core/src/main/kotlin/net/radsteve/axi/event/Handleable.kt")
    output.writeText(code)
  }
}
