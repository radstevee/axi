package net.radsteve.axi.config.language.internal

import net.radsteve.axi.config.Configuration
import net.radsteve.axi.config.language.ConfigurationLanguageService
import net.radsteve.axi.plugin.AxiPluginHolder
import java.util.ServiceLoader
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

internal object ConfigurationLoader {
  fun languageServiceFor(fileExt: String): ConfigurationLanguageService {
    val services = ServiceLoader.load(
      ConfigurationLanguageService::class.java,
      AxiPluginHolder.plugin().javaClass.classLoader
    )
    val service = services.find { service -> service.fileExt == fileExt }
    return requireNotNull(service) { "invalid file extension: $fileExt" }
  }

  fun load(klass: KClass<Configuration>) {
    // Initialise the config properties
    klass.members
      .filterIsInstance<KProperty<*>>()
      .filter { property -> property.getter.parameters.isEmpty() }
      .forEach { property -> property.getter.call() }
  }
}
