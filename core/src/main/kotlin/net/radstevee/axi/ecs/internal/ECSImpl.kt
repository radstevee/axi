package net.radstevee.axi.ecs.internal

import net.radstevee.axi.ecs.Attachable
import net.radstevee.axi.ecs.ECS
import net.radstevee.axi.ecs.WrappedComponent
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
@PublishedApi
internal class ECSImpl : ECS {
  internal val data: MutableMap<Attachable, MutableSet<WrappedComponent<*>>> = mutableMapOf()

  override fun remove(attachable: Attachable) {
    data.remove(attachable)
  }

  override fun <T : Any> Attachable.get(klass: KClass<T>): T? {
    val components = data.getOrPut(this, ::mutableSetOf)
    val component = components
      .find { component -> component.klass == klass } as WrappedComponent<T>?

    return component?.value
  }

  override fun <T : Any> Attachable.set(value: T?, klass: KClass<T>): T? {
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

  override fun entities(): Set<Attachable> {
    return data.keys
  }
}
