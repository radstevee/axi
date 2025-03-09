package net.radstevee.axi.core.ecs

import net.radstevee.axi.core.ecs.ECSDataTracker.data
import net.radstevee.axi.core.ecs.ECSDataTracker.get
import net.radstevee.axi.core.ecs.ECSDataTracker.set
import org.bukkit.entity.Player
import kotlin.properties.ReadWriteProperty

/** This player's attachable. */
public val Player.attachable: Attachable get() = PlayerTracker[uniqueId]

/** Gets the component of [T] on this player. */
public inline fun <reified T : Any> Player.get(): T? = attachable.get()
/** Sets the component of [T] to [value] on this player. */
public inline fun <reified T : Any> Player.set(value: T?): T? = attachable.set(value)
/** Gets a delegate to the component of [T] on this player. */
public inline fun <reified T : Any> Player.data(): ReadWriteProperty<Any?, T?> = attachable.data()
