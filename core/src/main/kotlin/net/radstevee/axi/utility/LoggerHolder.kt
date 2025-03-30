package net.radstevee.axi.utility

import org.apache.logging.log4j.LogManager
import org.slf4j.Logger
import java.util.logging.Logger as JULLogger
import org.apache.logging.log4j.Logger as Log4JLogger

/** Something that holds a logger. */
public interface LoggerHolder {
  /** The logger. */
  public val logger: Logger

  /** The Log4J logger. */
  public val log4jLogger: Log4JLogger get() = LogManager.getLogger(logger.name)

  /** The JUL logger. */
  public val julLogger: JULLogger get() = JULLogger.getLogger(logger.name)
}
