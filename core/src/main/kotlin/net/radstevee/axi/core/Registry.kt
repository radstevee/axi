package net.radstevee.axi.core

import kotlin.random.Random

/** A basic string-object registry. */
public abstract class Registry<V>(
    /** Whether entries of this registry can be modified. */
    protected val modifiable: Boolean = false
) {
    protected val entries: MutableList<V> = mutableListOf()
    protected val keys: MutableList<String> = mutableListOf()
    protected val keyToEntryMap: MutableMap<String, V> = mutableMapOf()
    protected val entryToKeyMap: MutableMap<V, String> = mutableMapOf()

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
    public open fun register(key: String, entry: V): V {
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
    public open operator fun get(key: String): V? {
        return keyToEntryMap[key]
    }

    /**
     * @return the key assigned to [entry], or `null` if it is not registered
     */
    public open fun getKey(entry: V): String? {
        return entryToKeyMap[entry]
    }

    /**
     * @return the value that is assigned to the index [index], or null if one is not present
     */
    public open operator fun get(index: Int): V? {
        return entries.getOrNull(index)
    }

    /**
     * @return the index of the entry
     */
    public open fun indexOf(entry: V): Int {
        return entries.indexOf(entry)
    }

    public open fun collectEntries(): List<V> {
        return entries.toList()
    }

    public open fun collectKeys(): List<String> {
        return keys.toList()
    }

    public open fun collect(): Map<String, V> {
        return keyToEntryMap.toMap()
    }

    /**
     * Performs [block] on every registered entry.
     */
    public open fun forEach(block: (V) -> Unit) {
        entries.forEach(block)
    }

    /**
     * Performs [block] on every registered entry.
     */
    public open fun forEachEntry(block: (String, V) -> Unit) {
        keyToEntryMap.forEach(block)
    }

    /**
     * Filters the entries list to the given [predicate].
     * @return a new list
     */
    public open fun firstOrNull(predicate: (V) -> Boolean): V? {
        return entries.firstOrNull(predicate)
    }

    /**
     * Returns a random entry of the registry.
     */
    public open fun random(random: Random = Random, filter: ((V) -> Boolean)? = null): V? {
        return (if (filter != null) {
            entries.filter(filter)
        } else {
            entries
        }).randomOrNull(random)
    }
}

/** Creates a new registry of type [V]. */
public fun <V> Registry(): Registry<V> {
    return object : Registry<V>() {}
}

/** Creates a new modifiable [Registry] of type [V]. */
@Suppress("FunctionName")
public fun <V> ModifiableRegistry(): Registry<V> {
    return object : Registry<V>(true) {}
}
