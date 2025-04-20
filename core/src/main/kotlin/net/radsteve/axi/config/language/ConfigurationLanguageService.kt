package net.radsteve.axi.config.language

import java.nio.file.Path

/** A service that handles loading of a configuration language. */
public interface ConfigurationLanguageService {
  /** Reads the given [file] as a configuration file. */
  public fun read(file: Path): ConfigurationFile

  /** The file extension this service supports. */
  public val fileExt: String
}
