package net.radsteve.axi.service

import kotlinx.coroutines.CoroutineScope
import net.radsteve.axi.coroutines.coroutineScope
import net.radsteve.axi.plugin.AxiPlugin
import sh.illumi.kraft.layer.Layer
import sh.illumi.kraft.service.registering
import sh.illumi.kraft.x.logging.LogLevel
import sh.illumi.kraft.x.logging.service.LoggingService

/** A service layer for the minecraft server. */
public class ServerLayer(
  /** The plugin. */
  private val plugin: AxiPlugin,
) : Layer() {
  override val coroutineScope: CoroutineScope = plugin.coroutineScope

  /** The plugin's logger. */
  public val logger: LoggingService by registering(LoggingService) {
    withProvider(SLF4JLoggingProvider(plugin.slF4JLogger)) {
      withLevel(LogLevel.All)
    }
  }
}
