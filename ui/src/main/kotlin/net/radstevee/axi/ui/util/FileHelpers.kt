package net.radstevee.axi.ui.util

import java.io.File
import java.security.MessageDigest
import javax.imageio.ImageIO

/** Gets the SHA-1 hash of this file. */
public fun File.sha1(): String = readBytes()
    .inputStream()
    .use { stream ->
        MessageDigest.getInstance("SHA-1").digest(stream.readBytes())
    }
    .joinToString("") { byte -> "%02x".format(byte) }

/** Gets the width of this image. */
public fun File.imageWidth(): Int = runCatching { ImageIO.read(this).width }.getOrElse { throwable ->
    println("Failed reading image width of file $this")
    throw throwable
}

/** Gets the height of this image. */
public fun File.imageHeight(): Int = runCatching { ImageIO.read(this).height }.getOrElse { throwable ->
    println("Failed reading image height of file $this")
    throw throwable
}
