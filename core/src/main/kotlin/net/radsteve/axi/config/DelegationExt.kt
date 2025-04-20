package net.radsteve.axi.config

import net.radsteve.axi.utility.map
import kotlin.properties.ReadOnlyProperty

/** Returns a new property with the given [default] as default. */
public infix fun <T : Any> ReadOnlyProperty<Configuration, T?>.or(default: T): ReadOnlyProperty<Configuration, T> {
  return map { value -> value ?: default }
}
