package net.radstevee.axi.core.ecs

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/** Tracks ECS data. */
@Suppress("UNCHECKED_CAST")
public object ECSDataTracker {
    @PublishedApi
    internal val data: MutableMap<Attachable, MutableSet<WrappedComponent<*>>> = mutableMapOf()

    public fun clear(attachable: Attachable) {
        data[attachable]?.removeIf { component -> component.value !is Persistent }
    }

    public fun <T : Any> Attachable.get(klass: KClass<T>): T? {
        val components = data.getOrPut(this, ::mutableSetOf)
        val component = components
            .find { component -> component.klass == klass } as WrappedComponent<T>?

        return component?.value
    }

    public inline fun <reified T : Any> Attachable.get(): T? = get(T::class)

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

    public inline fun <reified T : Any> Attachable.set(value: T?): T? = set(value, T::class)

    public inline fun <reified T : Any> Attachable.data(): ReadWriteProperty<Any?, T?> = object : ReadWriteProperty<Any?, T?> {
        override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
            return get(T::class)
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
            set(value, T::class)
        }
    }
}
