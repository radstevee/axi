package net.radstevee.axi.utility

import net.kyori.adventure.key.Key
import org.bukkit.NamespacedKey

/** Gets this key as a bukkit [NamespacedKey]. */
public fun Key.bukkit(): NamespacedKey {
  return NamespacedKey(namespace(), value())
}
