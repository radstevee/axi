@file:OptIn(AxiInternal::class)
@file:Suppress("UNCHECKED_CAST")

package net.radsteve.axi.config.language.internal

import net.radsteve.axi.config.Configuration
import net.radsteve.axi.config.language.ConfigurationField
import net.radsteve.axi.config.language.ConfigurationObject
import net.radsteve.axi.utility.AxiInternal
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

internal open class ConfigurationValueDelegate<T : Any, O : ConfigurationObject<*>>(
  private val config: Configuration,
  private val objectKlass: KClass<O>,
) : ReadOnlyProperty<Configuration, T?> {
  private lateinit var field: ConfigurationField<O>

  private object Uninitialized

  private var cachedValue: Any? = Uninitialized

  private fun buildKey(propertyName: String): String {
    if (config !is Configuration.Nested) {
      return propertyName
    }

    val parts = mutableListOf<String>()
    parts.add(propertyName)

    var current: Configuration = config
    while (current is Configuration.Nested) {
      parts.add(current.name)
      current = current.parent
    }

    return parts.reversed().joinToString(".")
  }

  private fun createField(propertyName: String): ConfigurationField<O> {
    if (::field.isInitialized) {
      return field
    }

    val key = buildKey(propertyName)
    val createdField = object : ConfigurationField<O> {
      override val name: String = key.split(".").lastOrNull() ?: key
      override val objectKlass: KClass<O> = this@ConfigurationValueDelegate.objectKlass
      override val key: String = key
    }

    field = createdField
    return field
  }

  private fun value(propertyName: String): T? {
    if (cachedValue !is Uninitialized) {
      return cachedValue as T?
    }

    val field = createField(propertyName)
    val value = field.get(config.file)?.value as T?

    cachedValue = value

    return value
  }

  override fun getValue(thisRef: Configuration, property: KProperty<*>): T? {
    return value(property.name)
  }
}
