@file:OptIn(InternalCoroutinesApi::class)

package net.radsteve.axi.command

import kotlinx.coroutines.InternalCoroutinesApi
import net.radsteve.axi.command.internal.CloudCommandExecutionContext
import org.incendo.cloud.paper.util.sender.Source
import org.incendo.cloud.parser.ParserDescriptor
import kotlin.reflect.KProperty

/** An instance of an optional command argument. */
public open class CommandArgument<T : Any>(
  /** The ID of this argument. */
  public open val id: String,
  /** The argument parser descriptor. */
  public open val descriptor: ParserDescriptor<Source, T>,
) {
  protected var value: T? = null

  public open operator fun getValue(thisRef: Any?, property: KProperty<*>): T? {
    if (value != null) {
      return value!!
    }

    val ctx = CloudCommandExecutionContext.Holder.get() ?: error("thread local unset")
    return ctx.ctx.get<T>(id).also { argValue -> value = argValue }
  }
}

/** An instance of a command argument that cannot be null, by either providing
 *
 * a) providing a default
 * b) using a required argument*/
public class NonNullableCommandArgument<T : Any>(
  /** The ID of this argument. */
  public override val id: String,
  /** The argument parser descriptor. */
  public override val descriptor: ParserDescriptor<Source, T>,
  /** The default value, if this is an optional argument */
  public val default: T? = null,
) : CommandArgument<T>(id, descriptor) {
  public override operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
    if (value != null) {
      return value!!
    }

    if (default == null) {
      return super.getValue(thisRef, property)!!.also { argValue -> value = argValue }
    }

    val ctx = CloudCommandExecutionContext.Holder.get() ?: error("thread local unset")
    return ctx.ctx.getOrDefault<T>(id, default).also { argValue -> value = argValue }
  }
}
