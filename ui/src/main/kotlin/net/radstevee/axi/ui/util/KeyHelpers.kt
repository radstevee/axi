package net.radstevee.axi.ui.util

import org.bukkit.NamespacedKey
import net.kyori.adventure.key.Key as AdventureKey
import net.radstevee.packed.core.key.Key as PackedKey

/** Converts a packed key to an adventure key. */
public fun PackedKey.bukkit(): NamespacedKey = NamespacedKey(namespace, value)

/** Converts an adventure key to a packed key. */
public fun AdventureKey.packed(): PackedKey = PackedKey(namespace(), value())

/** Converts a packed key to an adventure key. */
public fun PackedKey.adventure(): AdventureKey = AdventureKey.key(namespace, value)
