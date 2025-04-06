package net.radsteve.axi.command.parser

import net.radsteve.axi.Registry
import org.incendo.cloud.parser.ParserDescriptor

/** A [StringMapEntryParser] implementation for registries. Calls [Any.toString] on the keys. */
public class RegistryEntryParser<C, K : Any, V : Any>(
  /** The registry. */
  public val registry: Registry<K, V>
) : StringMapEntryParser<C, V>({ registry.collect().mapKeys { (k) -> k.toString() } }) {
  public companion object {
    /** Creates a [RegistryEntryParser] from the given [registry]. */
    public inline fun <C : Any, K : Any, reified V : Any> registryEntryParser(registry: Registry<K, V>): ParserDescriptor<C, V> {
      return ParserDescriptor.of(RegistryEntryParser<C, K, V>(registry), V::class.java)
    }
  }
}
