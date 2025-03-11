package net.radstevee.axi.core

import kotlin.random.Random

/** A basic K-object registry. */
public abstract class Registry<K : Any, V>(
  /** Whether entries of this registry can be modified. */
  internal val modifiable: Boolean = false,
) {
  internal open val entries: MutableList<V> = mutableListOf()
  internal open val keys: MutableList<K> = mutableListOf()
  internal open val keyToEntryMap: MutableMap<K, V> = mutableMapOf()
  internal open val entryToKeyMap: MutableMap<V, K> = mutableMapOf()

  /**
   * The amount of registered entries in this registry.
   */
  public open val size: Int get() = entries.size

  /**
   * The default value of this registry.
   */
  public open val defaultValue: V? = null

  /**
   * Registers [entry] to the registry under [key].
   * @return the passed [entry].
   */
  public open fun register(key: K, entry: V): V {
    if (keys.contains(key)) {
      if (modifiable) {
        // remove old entry object
        val oldEntry = this[key]
        entries.remove(oldEntry)
        entryToKeyMap.remove(oldEntry)
      } else {
        throw UnsupportedOperationException("Key $key already registered")
      }
    }

    entries.add(entry)
    keys.add(key)

    keyToEntryMap[key] = entry
    entryToKeyMap[entry] = key

    return entry
  }

  /**
   * @return the value that is assigned [key], or `null` if it is not registered
   */
  public open operator fun get(key: K): V? = keyToEntryMap[key]

  /**
   * @return the key assigned to [entry], or `null` if it is not registered
   */
  public open fun getKey(entry: V): K? = entryToKeyMap[entry]

  /**
   * @return the value that is assigned to the index [index], or null if one is not present
   */
  public open operator fun get(index: Int): V? = entries.getOrNull(index)

  /**
   * @return the index of the entry
   */
  public open fun indexOf(entry: V): Int = entries.indexOf(entry)

  public open fun collectEntries(): List<V> = entries.toList()

  public open fun collectKeys(): List<K> = keys.toList()

  public open fun collect(): Map<K, V> = keyToEntryMap.toMap()

  /**
   * Performs [block] on every registered entry.
   */
  public open fun forEach(block: (V) -> Unit) {
    entries.forEach(block)
  }

  /**
   * Performs [block] on every registered entry.
   */
  public open fun forEachEntry(block: (K, V) -> Unit) {
    keyToEntryMap.forEach(block)
  }

  /**
   * Filters the entries list to the given [predicate].
   * @return a new list
   */
  public open fun firstOrNull(predicate: (V) -> Boolean): V? = entries.firstOrNull(predicate)

  /**
   * Returns a random entry of the registry.
   */
  public open fun random(random: Random = Random, filter: ((V) -> Boolean)? = null): V? = (
    if (filter != null) {
      entries.filter(filter)
    } else {
      entries
    }
    ).randomOrNull(random)
}

/** A registry that delegates itself to the given [delegate]. */
public open class DelegatingRegistry<K : Any, V>(private val delegate: Registry<K, V>) : Registry<K, V>(delegate.modifiable) {
  override val entries: MutableList<V>
    get() = delegate.entries
  override val keys: MutableList<K>
    get() = delegate.keys
  override val keyToEntryMap: MutableMap<K, V>
    get() = delegate.keyToEntryMap
  override val entryToKeyMap: MutableMap<V, K>
    get() = delegate.entryToKeyMap
}

/** Creates a new registry of type [V]. */
public fun <K : Any, V> Registry(): Registry<K, V> = object : Registry<K, V>() {}

/** Creates a new modifiable [Registry] of type [V]. */
@Suppress("FunctionName")
public fun <K : Any, V> ModifiableRegistry(): Registry<K, V> = object : Registry<K, V>(true) {}
