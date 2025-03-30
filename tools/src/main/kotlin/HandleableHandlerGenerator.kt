import io.github.classgraph.ClassGraph
import org.bukkit.event.Event

public fun main() {
  ClassGraph().enableAllInfo().scan().use { result ->
    val eventClasses = result.getSubclasses(Event::class.java).loadClasses().map(Class<*>::kotlin)

    println("// THIS FILE IS AUTO-GENERATED! DO NOT MODIFY!")
    println("// spotless:off")
    println("@file:Suppress(\"DEPRECATION\", \"removal\", \"SpellCheckingInspection\")")
    println("package net.radstevee.axi.event")
    println()
    println("import org.bukkit.event.EventHandler")
    println()
    println("/** Event handler for [Handleable]s. */")
    println("public class HandleableHandler(")
    println("  /** Supplier for all handleables that should be called. */")
    println("  private val handleableSupplier: suspend () -> Iterable<Handleable>")
    println(") : SuspendingListener {")
    eventClasses.forEachIndexed { idx, klass ->
      if (klass.typeParameters.isNotEmpty()) {
        return@forEachIndexed
      }
      // We do not want any tick events as we already have systems.
      if ("Tick" in klass.simpleName.toString()) {
        return@forEachIndexed
      }

      println("  @EventHandler")
      println("  private suspend fun on(event: ${klass.qualifiedName}) {")
      println("    handleableSupplier().forEach { handleable ->")
      println("      handleable.on(event)")
      println("    }")
      println("  }")

      if (idx != eventClasses.size - 1) {
        println()
      }
    }
    println("}")
  }
}
