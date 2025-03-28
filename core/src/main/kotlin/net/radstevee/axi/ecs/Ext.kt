@file:JvmName("ECSExtensions")
@file:JvmMultifileClass

package net.radstevee.axi.ecs

import net.radstevee.axi.ecs.component.DebounceComponent
import net.radstevee.axi.ecs.component.EntityClickedComponent
import net.radstevee.axi.ecs.component.identity
import net.radstevee.axi.ecs.internal.PlayerTracker
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.time.Duration

/** This player's attachable. */
public val Player.attachable: Attachable get() = PlayerTracker[uniqueId]

/** Gets the player of this attachable, if they are online. */
public val Attachable.player: Player? get() = identity?.let(Bukkit::getPlayer)

/** Gets the component of [T] on this player. */
public inline fun <reified T : Any> Player.get(): T? = attachable.get()

/** Gets the component of [T] on this player, or calls and puts the return value of [valueSupplier]. */
public inline fun <reified T : Any> Player.getOrPut(noinline valueSupplier: () -> T): T = attachable.getOrPut(valueSupplier)

/** Sets the component of [T] to [value] on this player. */
public inline fun <reified T : Any> Player.set(value: T?): T? = attachable.set(value)

/** Gets a delegate to the component of [T] on this player. */
public inline fun <reified T : Any> Player.data(): ReadWriteProperty<Any?, T?> = attachable.data()

/** Sets an [EntityClickedComponent] for the given [block]. */
public fun Player.onClickEntity(block: suspend (EntityClickedComponent.ClickContext) -> Unit): EntityClickedComponent {
  val component = EntityClickedComponent(block)
  set(component)
  return component
}

/** Sets an [EntityClickedComponent] for the given [block]. */
public fun Attachable.onClickEntity(block: suspend (EntityClickedComponent.ClickContext) -> Unit): EntityClickedComponent {
  val component = EntityClickedComponent(block)
  set(component)
  return component
}

/** Adds a debounce entry to this attachable's debounce component for the given [klass] and the given [duration]. */
public fun Attachable.addDebounce(klass: KClass<out Any>, duration: Duration): DebounceComponent.DebounceEntry {
  val component = getOrPut(::DebounceComponent)
  return component.add(klass, duration)
}

/** Checks a debounce entry for this attachable of the given [klass]. */
public fun Attachable.checkDebounce(klass: KClass<out Any>): Boolean {
  val component = getOrPut(::DebounceComponent)
  return component.check(klass)
}

/**
 * Suspends until the debounce entry for the given [klass] has expired
 * and returns whether it had to wait, if the entry did not exist,
 * it will return false.
 */
public suspend fun Attachable.waitUntilDebounced(klass: KClass<out Any>): Boolean {
  val component = getOrPut(::DebounceComponent)
  return component.wait(klass)
}

/** Adds a debounce entry to this player's debounce component for the given [klass] and the given [duration]. */
public fun Player.addDebounce(klass: KClass<out Any>, duration: Duration): DebounceComponent.DebounceEntry {
  return attachable.addDebounce(klass, duration)
}

/** Checks a debounce entry for this player of the given [klass]. */
public fun Player.checkDebounce(klass: KClass<out Any>): Boolean {
  return attachable.checkDebounce(klass)
}

/**
 * Suspends until the debounce entry for the given [klass] has expired
 * and returns whether it had to wait, if the entry did not exist,
 * it will return false.
 */
public suspend fun Player.waitUntilDebounced(klass: KClass<out Any>): Boolean {
  return attachable.waitUntilDebounced(klass)
}
