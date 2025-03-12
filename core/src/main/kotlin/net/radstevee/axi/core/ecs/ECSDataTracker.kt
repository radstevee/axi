package net.radstevee.axi.core.ecs

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/** Tracks ECS data. */
@Suppress("UNCHECKED_CAST")
public object ECSDataTracker {
  @PublishedApi
  internal val data: MutableMap<Attachable, MutableSet<WrappedComponent<*>>> = mutableMapOf()

  /** Clears non-persistent data from the given [attachable]. */
  public fun clear(attachable: Attachable) {
    // data[attachable]?.removeIf { component -> component.value !is Persistent }
    data.remove(attachable)
  }

  /** Gets a component of the given [klass]. */
  public fun <T : Any> Attachable.get(klass: KClass<T>): T? {
    val components = data.getOrPut(this, ::mutableSetOf)
    val component = components
      .find { component -> component.klass == klass } as WrappedComponent<T>?

    return component?.value
  }

  /** Gets a component of the given type. */
  public inline fun <reified T : Any> Attachable.get(): T? = get(T::class)

  /** Sets a component to [value]. */
  public fun <T : Any> Attachable.set(value: T?, klass: KClass<T>): T? {
    val components = data.getOrPut(this, ::mutableSetOf)
    val component = components
      .find { component -> component.klass == klass } as WrappedComponent<T>?

    if (component == null) {
      val new = WrappedComponent(klass, value)
      data[this]?.add(new)
    }

    component?.value = value

    return value
  }

  /** Sets a component to [value]. */
  public inline fun <reified T : Any> Attachable.set(value: T?): T? = set(value, T::class)

  /** Gets a component of given [klass], or puts a [value] if it is absent. */
  public fun <T : Any> Attachable.getOrPut(value: T, klass: KClass<T>): T = get(klass) ?: set(value, klass)!!

  /** Gets a component of given type, or puts a [value] if it is absent. */
  public inline fun <reified T : Any> Attachable.getOrPut(value: T): T = getOrPut(value, T::class)

  /** Gets a read-write property of the given type, useful for delegation. */
  public inline fun <reified T : Any> Attachable.data(): ReadWriteProperty<Any?, T?> = object : ReadWriteProperty<Any?, T?> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T? = get(T::class)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
      set(value, T::class)
    }
  }

  /** Gets all components for this attachable. */
  public fun Attachable.components(): Set<WrappedComponent<*>> = data.getOrPut(this, ::mutableSetOf)

  /** Gets all attachables currently stored. */
  public fun attachables(): Set<Attachable> = data.keys
}
