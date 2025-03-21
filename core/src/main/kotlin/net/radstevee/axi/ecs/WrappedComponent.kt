package net.radstevee.axi.ecs

import kotlin.reflect.KClass

/** Wraps a component's value with its class. */
public data class WrappedComponent<T : Any>(
  /** The type klass. */
  public val klass: KClass<T>,
  /** The component value. */
  public var value: T?,
)
