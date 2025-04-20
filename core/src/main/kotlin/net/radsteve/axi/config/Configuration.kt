@file:OptIn(AxiInternal::class)

package net.radsteve.axi.config

import net.radsteve.axi.config.language.ConfigurationFile
import net.radsteve.axi.config.language.ConfigurationObject
import net.radsteve.axi.config.language.internal.ConfigurationLoader
import net.radsteve.axi.config.language.internal.ConfigurationValueDelegate
import net.radsteve.axi.plugin.AxiPluginHolder
import net.radsteve.axi.utility.AxiInternal
import java.nio.file.Path
import kotlin.properties.ReadOnlyProperty

/** Represents a configuration used by plugins. */
public abstract class Configuration(
  /** The file extension used to find the format. */
  public val fileExt: String,

  /** The file name, without the [fileExt]. */
  public val fileName: String,

  /** The actual path to the configuration file. */
  public val path: Path = AxiPluginHolder.plugin().dataPath.resolve("$fileName.$fileExt")
) {
  /** The parsed configuration file. */
  public val file: ConfigurationFile = ConfigurationLoader.languageServiceFor(fileExt).read(path)

  init {
    ConfigurationLoader.load(javaClass.kotlin)
  }

  /** Creates a string delegate. */
  public fun string(): ReadOnlyProperty<Configuration, String?> {
    return ConfigurationValueDelegate(this, ConfigurationObject.String::class)
  }

  /** Creates an int delegate. */
  public fun int(): ReadOnlyProperty<Configuration, Int?> {
    return ConfigurationValueDelegate(this, ConfigurationObject.Int::class)
  }

  /** A nested configuration section. */
  public abstract class Nested(
    public val name: String,
    public val parent: Configuration,
  ) : Configuration(
    parent.fileExt,
    parent.fileName,
    parent.path
  )

  /** A nested inner configuration section. */
  public open inner class Section(name: String) : Nested(name, this)
}
