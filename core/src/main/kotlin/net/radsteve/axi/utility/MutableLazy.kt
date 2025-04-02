@file:Suppress("UNCHECKED_CAST")

package net.radsteve.axi.utility

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/** A lazy-initialized mutable property, initialized by the given [initializer]. */
public open class MutableLazy<T>(private val initializer: () -> T) : ReadWriteProperty<Any?, T> {
  // We want to allow nullable values
  private object Uninitialized

  private var value: Any? = Uninitialized

  public fun value(): T {
    if (value != Uninitialized) {
      return value as T
    }

    value = initializer()
    return value as T
  }

  public override operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
    return value()
  }

  public override operator fun setValue(thisRef: Any?, property: KProperty<*>, new: T) {
    value = new
  }
}

private class ObservableMutableLazy<T>(private val initializer: () -> T, private val observer: (old: T, new: T) -> Unit) : MutableLazy<T>(initializer) {
  override fun setValue(thisRef: Any?, property: KProperty<*>, new: T) {
    observer(value(), new)
    super.setValue(thisRef, property, new)
  }
}

/** Creates a new [MutableLazy] of the given [initializer]. */
public fun <T> mutableLazy(initializer: () -> T): MutableLazy<T> {
  return MutableLazy(initializer)
}

/** Creates a new [MutableLazy] that will call the given [observer] each time the value changes. */
public fun <T> observableMutableLazy(initializer: () -> T, observer: (old: T, new: T) -> Unit): MutableLazy<T> {
  return ObservableMutableLazy(initializer, observer)
}
