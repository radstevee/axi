package net.radstevee.axi.core.command

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
  public open operator fun getValue(thisRef: Any?, property: KProperty<*>): T? {
    val ctx = CommandExecutionContext.ctx() ?: error("execution ctx is unset")
    return ctx.get<T>(id)
  }
}

/**
 * An instance of a command argument that cannot be null, by either providing
 * a) providing a default
 * b) using a required argument
 */
public class NonNullableCommandArgument<T : Any>(
  /** The ID of this argument. */
  public override val id: String,
  /** The argument parser descriptor. */
  public override val descriptor: ParserDescriptor<Source, T>,
  /** The default value, if this is an optional argument */
  public val default: T? = null,
) : CommandArgument<T>(id, descriptor) {
  override operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
    if (default == null) {
      return super.getValue(thisRef, property)!!
    } else {
      val ctx = CommandExecutionContext.ctx() ?: error("execution ctx is unset")
      return ctx.getOrDefault<T>(id, default)
    }
  }
}
