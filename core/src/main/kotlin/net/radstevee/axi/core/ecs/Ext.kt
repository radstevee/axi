package net.radstevee.axi.core.ecs

import net.radstevee.axi.core.ecs.ECSDataTracker.data
import net.radstevee.axi.core.ecs.ECSDataTracker.get
import net.radstevee.axi.core.ecs.ECSDataTracker.getOrPut
import net.radstevee.axi.core.ecs.ECSDataTracker.set
import net.radstevee.axi.core.ecs.component.DebounceComponent
import net.radstevee.axi.core.ecs.component.EntityClickedComponent
import org.bukkit.entity.Player
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.time.Duration

/** This player's attachable. */
public val Player.attachable: Attachable get() = PlayerTracker[uniqueId]

/** Gets the component of [T] on this player. */
public inline fun <reified T : Any> Player.get(): T? = attachable.get()
public inline fun <reified T : Any> Player.getOrPut(value: T): T = attachable.getOrPut(value)

/** Sets the component of [T] to [value] on this player. */
public inline fun <reified T : Any> Player.set(value: T?): T? = attachable.set(value)

/** Gets a delegate to the component of [T] on this player. */
public inline fun <reified T : Any> Player.data(): ReadWriteProperty<Any?, T?> = attachable.data()

/** Sets an [EntityClickedComponent] for the given [block]. */
public fun Player.onClick(block: suspend EntityClickedComponent.ClickContext.() -> Unit): EntityClickedComponent {
    val component = EntityClickedComponent(block)
    set(component)
    return component
}

/** Sets an [EntityClickedComponent] for the given [block]. */
public fun Attachable.onClick(block: suspend EntityClickedComponent.ClickContext.() -> Unit): EntityClickedComponent {
    val component = EntityClickedComponent(block)
    set(component)
    return component
}

/** Adds a debounce entry to this attachable's debounce component for the given [klass] and the given [duration]. */
public fun Attachable.addDebounce(klass: KClass<out Any>, duration: Duration): DebounceComponent.DebounceEntry {
    val component = getOrPut(DebounceComponent())
    return component.add(klass, duration)
}

/** Checks a debounce entry for this attachable of the given [klass]. */
public fun Attachable.checkDebounce(klass: KClass<out Any>): Boolean {
    val component = getOrPut(DebounceComponent())
    return component.check(klass)
}

/** Adds a debounce entry to this player's debounce component for the given [klass] and the given [duration]. */
public fun Player.addDebounce(klass: KClass<out Any>, duration: Duration): DebounceComponent.DebounceEntry = attachable.addDebounce(klass, duration)

/** Checks a debounce entry for this player of the given [klass]. */
public fun Player.checkDebounce(klass: KClass<out Any>): Boolean = attachable.checkDebounce(klass)
