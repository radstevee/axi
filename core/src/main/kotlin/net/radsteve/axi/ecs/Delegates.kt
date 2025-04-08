package net.radsteve.axi.ecs

import net.radsteve.axi.utility.observableMutableLazy
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/** Gets a read-write property of the given type, useful for delegation. */
public inline fun <reified T : Any> Attachable.data(): ReadWriteProperty<Any?, T?> {
  return object : ReadWriteProperty<Any?, T?> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T? = get(T::class)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
      set(value, T::class)
    }
  }
}

/** Gets a read-write property of the given type, useful for delegation, which throws if the value is null. */
public inline fun <reified T : Any> Attachable.nonNullData(): ReadWriteProperty<Any?, T> {
  return object : ReadWriteProperty<Any?, T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
      return get(T::class) ?: error("data of type ${T::class.simpleName} is null")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
      set(value, T::class)
    }
  }
}

/** Gets a read-write property of the given type, useful for delegation, with a given [initial] value. */
public inline fun <reified T : Any> Attachable.data(initial: T?): ReadWriteProperty<Any?, T?> {
  set(initial)
  return data()
}

/** Gets a read-write property of the given type, useful for delegation, with a given [initial] value. */
public inline fun <reified T : Any> Attachable.nonNullData(initial: T): ReadWriteProperty<Any?, T> {
  set(initial)
  return nonNullData()
}

/** Gets a read-write property for a lazily initialised component data value, which calls [observer] when changed. */
public inline fun <reified T : Any> Attachable.observableLazyData(
  noinline initializer: () -> T?,
  noinline observer: (old: T?, new: T?) -> Unit
): ReadWriteProperty<Any?, T?> {
  return object : ReadWriteProperty<Any?, T?> {
    var initialised: Boolean = false

    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
      if (!initialised) {
        return initializer().also(::set)
      }

      return get()
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
      observer(get<T>(), value)
      set(value)
    }
  }
}

/** Gets a read-write non-null property for a lazily initialised component data value, which calls [observer] when changed. */
public inline fun <reified T : Any> Attachable.observableNonNullLazyData(
  noinline initializer: () -> T,
  noinline observer: (old: T, new: T) -> Unit
): ReadWriteProperty<Any?, T> {
  return object : ReadWriteProperty<Any?, T> {
    var initialised: Boolean = false

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
      if (!initialised) {
        return initializer().also(::set)
      }

      return get() ?: error("non-null data was null")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
      observer(get<T>() ?: error("old non-null state was null"), value)
      set(value)
    }
  }
}
