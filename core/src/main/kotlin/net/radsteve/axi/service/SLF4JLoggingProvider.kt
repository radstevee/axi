package net.radsteve.axi.service

import net.radsteve.axi.utility.unreachable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import sh.illumi.kraft.service.ServiceAccessor
import sh.illumi.kraft.x.logging.LogLevel
import sh.illumi.kraft.x.logging.provider.LoggingProvider

/** A [LoggingProvider] implementation for slf4j. */
public class SLF4JLoggingProvider(
  /** The logger. */
  private val logger: Logger,
) : LoggingProvider {
  public constructor(
    /** The name of the logger. */
    loggerName: String,
  ) : this(LoggerFactory.getLogger(loggerName))

  override fun log(level: LogLevel, accessor: ServiceAccessor, message: String) {
    require(level != LogLevel.All) { "cannot log to all loggers" }

    when (level) {
      LogLevel.Debug -> logger.debug(message)
      LogLevel.Error, LogLevel.Fatal -> logger.error(message)
      LogLevel.Trace -> logger.trace(message)
      LogLevel.Info -> logger.info(message)
      LogLevel.Warning -> logger.warn(message)
      LogLevel.All -> unreachable()
    }
  }
}
