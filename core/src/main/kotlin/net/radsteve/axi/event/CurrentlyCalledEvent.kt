package net.radsteve.axi.event

import org.bukkit.event.Event
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.KClass

/** A coroutine context element that denotes the klass of the currently called event. */
public class CurrentlyCalledEvent(
  /** The klass of the event. */
  public val eventKlass: KClass<out Event>,
) : AbstractCoroutineContextElement(Key) {
  public companion object Key : CoroutineContext.Key<CurrentlyCalledEvent>
}
