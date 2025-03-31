package net.radsteve.axi.ecs

import kotlin.reflect.KClass

/** Attachable that wraps around an entity. */
public class WrappedAttachable<T : Any>(
  /** The wrapped value. */
  public val wrapped: T,
  /** The klass of the wrapped value. */
  public val klass: KClass<T>,
) : Attachable
