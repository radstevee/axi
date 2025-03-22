package net.radstevee.axi.ecs

import net.radstevee.axi.ecs.ECSDataTracker.Basic.get
import net.radstevee.axi.ecs.ECSDataTracker.Basic.getOrPut
import net.radstevee.axi.ecs.ECSDataTracker.Basic.set
import net.radstevee.axi.plugin.AxiPluginHolder
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/** Tracks and manages data contained in Axi's ECS. */
public interface ECSDataTracker : KoinComponent {
  /** Clears all components for the given [attachable]. */
  public fun remove(attachable: Attachable)

  /** Gets a component of the given [klass]. */
  public fun <T : Any> Attachable.get(klass: KClass<T>): T?

  /** Sets a component of the given [klass] to the given [value]. */
  public fun <T : Any> Attachable.set(value: T?, klass: KClass<T>): T?

  /** Gets a component of given [klass], or calls and puts the result of the given [valueSupplier] if it is absent. */
  public fun <T : Any> Attachable.getOrPut(klass: KClass<T>, valueSupplier: () -> T): T {
    return get(klass) ?: set(valueSupplier(), klass)!!
  }

  /** The basic ECS tracker implementation. */
  public companion object Basic : ECSDataTracker by AxiPluginHolder.plugin().get()
}

/** Gets a component of the given type. */
public inline fun <reified T : Any> Attachable.get(): T? {
  return get(T::class)
}

/** Sets a component to [value]. */
public inline fun <reified T : Any> Attachable.set(value: T?): T? {
  return set(value, T::class)
}

/** Gets a component of given type, or calls and puts the return value of [valueSupplier] if it is absent. */
public inline fun <reified T : Any> Attachable.getOrPut(noinline valueSupplier: () -> T): T {
  return getOrPut(T::class, valueSupplier)
}

/** Gets a read-write property of the given type, useful for delegation. */
public inline fun <reified T : Any> Attachable.data(): ReadWriteProperty<Any?, T?> {
  return object : ReadWriteProperty<Any?, T?> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T? = get(T::class)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
      set(value, T::class)
    }
  }
}
