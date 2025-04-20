package net.radsteve.axi.utility

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/** Applies [block] on every value. */
public fun <T, V, O> ReadOnlyProperty<T, V>.map(block: T.(V) -> O): ReadOnlyProperty<T, O> {
  return object : ReadOnlyProperty<T, O> {
    override fun getValue(thisRef: T, property: KProperty<*>): O {
      return thisRef.block(this@map.getValue(thisRef, property))
    }
  }
}
