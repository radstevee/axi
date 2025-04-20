@file:Suppress("UNCHECKED_CAST")

package net.radsteve.axi.config.language.bundled.toml

import net.radsteve.axi.config.language.ConfigurationFile
import net.radsteve.axi.config.language.ConfigurationObject
import org.tomlj.TomlArray
import org.tomlj.TomlParseError
import org.tomlj.TomlParseResult
import org.tomlj.TomlTable
import kotlin.reflect.KClass

internal class TomlFile(private val toml: TomlParseResult) : ConfigurationFile {
  override fun <O : ConfigurationObject<*>> get(klass: KClass<O>, key: String): O? {
    return when (klass) {
      ConfigurationObject.Int::class -> int(key)
      ConfigurationObject.String::class -> string(key)
      ConfigurationObject.Float::class -> float(key)
      ConfigurationObject.Collection::class -> collection(key)
      ConfigurationObject.Section::class -> section(key)
      else -> null
    } as O?
  }

  private fun int(key: String): ConfigurationObject<Int>? {
    return toml.getLong(key)?.toInt()?.let { value -> ConfigurationObject.Int(value) }
  }

  private fun string(key: String): ConfigurationObject<String>? {
    return toml.getString(key)?.let { value -> ConfigurationObject.String(value) }
  }

  private fun float(key: String): ConfigurationObject<Float>? {
    return toml.getDouble(key)?.toFloat()?.let { value -> ConfigurationObject.Float(value) }
  }

  private fun configurationObject(value: Any): ConfigurationObject<Any>? {
    return when (value) {
      is Long -> ConfigurationObject.Int(value.toInt())
      is String -> ConfigurationObject.String(value)
      is Double -> ConfigurationObject.Float(value.toFloat())
      is TomlArray -> ConfigurationObject.Collection(value.toList().mapNotNull(::configurationObject))
      is TomlTable -> createResult(value)
      else -> null
    } as ConfigurationObject<Any>?
  }

  private fun collection(key: String): ConfigurationObject<Collection<ConfigurationObject<*>>>? {
    val array = toml.getArray(key) ?: return null
    val items = array.toList().mapNotNull(::configurationObject)

    return ConfigurationObject.Collection(items)
  }

  private fun createResult(table: TomlTable): TomlParseResult {
    return object : TomlParseResult, TomlTable by table {
      override fun errors(): List<TomlParseError> {
        return emptyList()
      }
    }
  }

  private fun section(key: String): ConfigurationObject<ConfigurationFile>? {
    val table = toml.getTable(key) ?: return null
    return ConfigurationObject.Section(TomlFile(createResult(table)))
  }

  override fun objects(): Collection<ConfigurationObject<out Any>> {
    return toml.toMap().mapNotNull { (_, value) -> configurationObject(value) }
  }
}
