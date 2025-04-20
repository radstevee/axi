package net.radsteve.axi.config.language

import kotlin.reflect.KClass

/** A field in a configuration file or section. */
public interface ConfigurationField<O : ConfigurationObject<*>> {
  /** The name of the field. */
  public val name: String

  /** The klass of [O]. */
  public val objectKlass: KClass<O>

  /** The dotted path to this field. */
  public val key: String

  /** Gets this field's value for a given [file]. */
  public fun get(file: ConfigurationFile): O? {
    return file[objectKlass, key]
  }
}
