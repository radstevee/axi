package net.radsteve.axi.utility

import org.apache.logging.log4j.LogManager
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.logging.Logger as JULLogger
import org.apache.logging.log4j.Logger as Log4JLogger

/** Something that holds a logger. */
public interface LoggerHolder {
  /** The logger. */
  public val logger: Logger get() = LoggerFactory.getLogger(javaClass)

  /** The Log4J logger. */
  public val log4jLogger: Log4JLogger get() = LogManager.getLogger(logger.name)

  /** The JUL logger. */
  public val julLogger: JULLogger get() = JULLogger.getLogger(logger.name)
}
