package net.radsteve.axi.ui.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.security.MessageDigest
import javax.imageio.ImageIO

/** Gets the SHA-1 hash of this file. */
public fun File.sha1(): String {
  return readBytes()
    .inputStream()
    .use { stream ->
      MessageDigest.getInstance("SHA-1").digest(stream.readBytes())
    }
    .joinToString("") { byte -> "%02x".format(byte) }
}

private val LOGGER: Logger = LoggerFactory.getLogger("FileHelpers")

/** Gets the width of this image. */
public fun File.imageWidth(): Int {
  return runCatching { ImageIO.read(this).width }.getOrElse { throwable ->
    LOGGER.error("Failed reading image width of file $this", throwable)
    0
  }
}

/** Gets the height of this image. */
public fun File.imageHeight(): Int {
  return runCatching { ImageIO.read(this).height }.getOrElse { throwable ->
    LOGGER.error("Failed reading image height of file $this", throwable)
    0
  }
}
