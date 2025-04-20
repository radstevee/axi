package net.radsteve.axi.config.language

import kotlin.reflect.KClass

/** A configuration file that contains configuration objects. */
public interface ConfigurationFile {
  /** Gets a configuration object of the given [klass] at the given dotted [key]. */
  public operator fun <O : ConfigurationObject<*>> get(klass: KClass<O>, key: String): O?

  /** Gets all [ConfigurationObject]s in this file. */
  public fun objects(): Collection<ConfigurationObject<out Any>>
}
