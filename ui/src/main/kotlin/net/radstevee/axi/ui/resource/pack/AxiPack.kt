package net.radstevee.axi.ui.resource.pack

import net.radstevee.axi.ui.resource.pack.AxiPackRegistry.AxiPacks
import net.radstevee.axi.ui.resource.pack.AxiPackRegistry.AxiPacks.negativeSpaces
import net.radstevee.axi.ui.util.sha1
import net.radstevee.packed.core.pack.ResourcePack
import net.radstevee.packed.core.pack.ResourcePackBuilder
import java.io.File
import java.nio.file.Files

/** Represents a packed resource pack, managed by axi. */
public abstract class AxiPack(
  /** The name of this resource pack. */
  public val name: String,
) {
  /** A created output directory for the [pack]. */
  protected val outputDirectory: File = Files.createTempDirectory("axi-pack-$name").toFile()

  /** The underlying packed resource pack. */
  public abstract val pack: ResourcePack

  /** The contents of this resource pack. */
  public var bytes: ByteArray = byteArrayOf()
    private set

  /** The SHA-1 hash of this resource pack. */
  public var hash: String = ""
    private set

  /** The [FallbackResourceProvider] of this resource pack. */
  public open val fallbackProvider: FallbackResourceProvider = FallbackResourceProvider.Empty

  /** Applies axi resource pack elements. */
  protected fun ResourcePackBuilder.applyAxi() {
    install(AxiPackSavingHook(this@AxiPack))
    install(negativeSpaces)
    meta.outputDir = outputDirectory
  }

  /** Registers this resource pack. */
  public fun register() {
    if (AxiPacks[name] != null) {
      return
    }

    AxiPacks.register(name, this)
  }

  /** Saves this resource pack. */
  public fun save() {
    register()

    pack.save(deleteOld = true)
    val zip = File.createTempFile("axi-pack-$name-", ".zip")
    pack.createZip(zip)

    hash = zip.sha1()
    bytes = zip.readBytes()
  }

  override fun equals(other: Any?): Boolean {
    other as AxiPack

    return other.name == name
  }

  override fun hashCode(): Int {
    var result = name.hashCode()
    result = 31 * result + outputDirectory.hashCode()
    result = 31 * result + bytes.contentHashCode()
    result = 31 * result + hash.hashCode()
    result = 31 * result + fallbackProvider.hashCode()
    result = 31 * result + pack.hashCode()
    return result
  }
}
