@file:Suppress("UNCHECKED_CAST")

package net.radsteve.axi.utility

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/** A lazy-initialized mutable property, initialized by the given [initializer]. */
private open class MutableLazy<T>(private val initializer: () -> T) : ReadWriteProperty<Any?, T> {
  // We want to allow nullable values
  private object Uninitialized

  private var value: Any? = Uninitialized

  fun value(): T {
    if (value != Uninitialized) {
      return value as T
    }

    value = initializer()
    return value as T
  }

  override operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
    return value()
  }

  override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    this.value = value
  }
}

private class ObservableMutableLazy<T>(initializer: () -> T, private val observer: (old: T, new: T) -> Unit) : MutableLazy<T>(initializer) {
  override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    val old = value()
    if (old == value) {
      return
    }
    observer(old, value)
    super.setValue(thisRef, property, value)
  }
}

/** Creates a new [MutableLazy] of the given [initializer]. */
public fun <T> mutableLazy(initializer: () -> T): ReadWriteProperty<Any?, T> {
  return MutableLazy(initializer)
}

/** Creates a new [MutableLazy] that will call the given [observer] each time the value changes. */
public fun <T> observableMutableLazy(initializer: () -> T, observer: (old: T, new: T) -> Unit): ReadWriteProperty<Any?, T> {
  return ObservableMutableLazy(initializer, observer)
}
