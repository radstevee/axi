package net.radstevee.axi.utility

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

/** Builds an item stack of the given [material] and [amount], and applies [block] onto it. */
public inline fun buildItemStack(material: Material, amount: Int = 1, block: ItemStack.() -> Unit = {}): ItemStack {
  val itemStack = ItemStack.of(material, amount)
  itemStack.block()
  return itemStack
}

/** Edits this item stack's item meta. */
public inline fun ItemStack.editItemMeta(crossinline block: ItemMeta.() -> Unit): ItemStack {
  return editSpecificItemMeta<ItemMeta>(block)
}

/** Edits a specific item meta of type [M]. */
public inline fun <reified M : ItemMeta> ItemStack.editSpecificItemMeta(crossinline block: M.() -> Unit): ItemStack = apply {
  editMeta(M::class.java) { meta -> meta.block() }
}
