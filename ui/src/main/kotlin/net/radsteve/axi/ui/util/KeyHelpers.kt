package net.radsteve.axi.ui.util

import org.bukkit.NamespacedKey
import net.kyori.adventure.key.Key as AdventureKey
import net.radstevee.packed.core.key.Key as PackedKey

/** Converts a packed key to an adventure key. */
public fun PackedKey.bukkit(): NamespacedKey {
  return NamespacedKey(namespace, value)
}

/** Converts an adventure key to a packed key. */
public fun AdventureKey.packed(): PackedKey {
  return PackedKey(namespace(), value())
}

/** Converts a packed key to an adventure key. */
public fun PackedKey.adventure(): AdventureKey {
  return AdventureKey.key(namespace, value)
}
