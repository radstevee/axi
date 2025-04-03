package net.radsteve.axi.utility

import com.sk89q.worldedit.extent.clipboard.Clipboard
import com.sk89q.worldedit.extent.clipboard.io.BuiltInClipboardFormat
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader
import net.radsteve.axi.plugin.AxiPluginHolder
import java.io.InputStream
import kotlin.reflect.KClass

/**
 * Cache for resources. The key of this map
 * is a pair of the resource path and the
 * resource type passed in to [resource].
 *
 * This also acts as a schematic cache.
 */
@PublishedApi
internal val cache: MutableMap<Pair<String, KClass<out Any>>, Any> = mutableMapOf()

/**
 * Reads a resource from the given [path] as type [T].
 *
 * Read resources are cached by type.
 *
 * [T] can be one of the following:
 *
 * * [String]
 * * [ByteArray]
 * * [com.sk89q.worldedit.extent.clipboard.Clipboard]
 */
public inline fun <reified T : Any> resource(path: String, classLoader: ClassLoader = AxiPluginHolder.plugin().javaClass.classLoader): T {
  val cached = cache[path to T::class] as T?
  if (cached != null) {
    return cached
  }

  val stream = requireNotNull(classLoader.getResourceAsStream("/$path")) { "resource $path does not exist" }

  return stream.use { stream ->
    when (T::class) {
      String::class -> stream.readBytes().decodeToString()
      ByteArray::class -> stream.readBytes()
      Clipboard::class -> readSchematic(stream)
      else -> error("invalid resource type")
    } as T
  }.also { value ->
    cache[path to T::class] = value
  }
}

/** Reads a schematic from the given [stream] as the given [format]. */
public fun readSchematic(stream: InputStream, format: BuiltInClipboardFormat = BuiltInClipboardFormat.SPONGE_V3_SCHEMATIC): Clipboard {
  val reader = format.getReader(stream)
  return reader.use(ClipboardReader::read)
}
