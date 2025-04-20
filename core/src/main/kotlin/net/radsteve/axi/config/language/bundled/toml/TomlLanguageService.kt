package net.radsteve.axi.config.language.bundled.toml

import net.radsteve.axi.config.language.ConfigurationFile
import net.radsteve.axi.config.language.ConfigurationLanguageService
import org.tomlj.Toml
import java.nio.file.Path

internal class TomlLanguageService : ConfigurationLanguageService {
  override fun read(file: Path): ConfigurationFile {
    return TomlFile(Toml.parse(file))
  }

  override val fileExt: String = "toml"
}
