package net.radsteve.axi.example

import net.radsteve.axi.config.Configuration
import net.radsteve.axi.config.or

public object ExampleConfig : Configuration("toml", "config") {
  public val string: String by string() or "hello world"

  public object NestedSection : Section("section") {
    public val num: Int by int() or -1
  }
}
