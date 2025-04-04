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
      appendLine("@file:Suppress(\"SpellCheckingInspection\", \"unused\")")
      appendLine("package net.radsteve.axi.event")

      appendLine()

      appendLine("import org.bukkit.event.EventHandler")
      appendLine("import kotlin.coroutines.CoroutineContext")
      appendLine("import kotlin.coroutines.EmptyCoroutineContext")
      appendLine("import kotlinx.coroutines.withContext")

      appendLine()
      appendLine("/** Event handler implementation for [Handleable]s. */")
      appendLine("public class HandleableHandler(")
      appendLine("  /** Supplier for all handleables that should be called. */")
      appendLine("  private val handleableSupplier: suspend () -> Iterable<Handleable>,")
      appendLine(") : SuspendingListener {")
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

        appendLine("  @EventHandler")
        appendLine("  private suspend fun on(event: ${klass.qualifiedName}) {")
        appendLine("    handleableSupplier().forEach { handleable ->")
        appendLine("      withContext(handleable.coroutineContext) {")
        appendLine("        handleable.on(event)")
        appendLine("      }")
        appendLine("    }")
        appendLine("  }")

        if (idx != eventClasses.size - 1) {
          appendLine()
        }
      }
      appendLine("}")
    }

    val output = Path("core/src/main/kotlin/net/radsteve/axi/event/HandleableHandler.kt")
    output.writeText(code)
  }
}
