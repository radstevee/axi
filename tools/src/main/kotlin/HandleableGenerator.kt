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
    println("/** Something that can handle events. */")
    println("public interface Handleable {")
    eventClasses.forEachIndexed { idx, klass ->
      if (klass.typeParameters.isNotEmpty()) {
        return@forEachIndexed
      }

      // We do not want any tick events as we already have systems.
      if ("Tick" in klass.simpleName.toString()) {
        return@forEachIndexed
      }

      println("  /** Called when a [${klass.qualifiedName}] is called. */")
      println("  public suspend fun on(event: ${klass.qualifiedName}) {}")

      if (idx != eventClasses.size - 1) {
        println()
      }
    }
    println("}")
  }
}
