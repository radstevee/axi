package net.radstevee.axi.core.ecs

import kotlin.reflect.KClass

/** Wraps a component's value with its class. */
internal data class WrappedComponent<T : Any>(
    val klass: KClass<T>,
    var value: T?
)
