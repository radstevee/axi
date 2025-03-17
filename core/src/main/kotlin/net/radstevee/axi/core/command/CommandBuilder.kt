package net.radstevee.axi.core.command

import net.radstevee.axi.core.plugin.AxiPlugin
import org.bukkit.entity.Player
import org.incendo.cloud.paper.util.sender.Source
import org.incendo.cloud.parser.ParserDescriptor

/** A command builder. */
@CommandBuilderDsl
public class CommandBuilder(
  /** The command name. */
  public val name: String,
  /** The plugin associated with this command. */
  private val plugin: AxiPlugin,
) {
  private var permission: String = "${plugin.name}.command.$name"
  private val children: MutableSet<Command> = mutableSetOf()
  private var executor: suspend CommandExecutionContext.() -> Unit = {}
  private val args: MutableSet<CommandArgument<*>> = mutableSetOf()
  private var async: Boolean = false
  private val aliases: MutableSet<String> = mutableSetOf()

  /** Sets this command to be handled asynchronously. */
  public fun async() {
    async = true
  }

  /** Sets the permission of this command. */
  public fun permission(perm: String) {
    permission = perm
  }

  /** Adds an optional argument to this command. */
  public fun <T : Any> optionalArg(id: String, parser: ParserDescriptor<Source, T>): CommandArgument<T> {
    val arg = CommandArgument<T>(id, parser)
    args.add(arg)
    return arg
  }

  /** Adds an optional argument with a default value to this command. */
  public fun <T : Any> defaultedArg(id: String, parser: ParserDescriptor<Source, T>, default: T): NonNullableCommandArgument<T> {
    val arg = NonNullableCommandArgument<T>(id, parser, default)
    args.add(arg)
    return arg
  }

  /** Adds a required argument to this command. */
  public fun <T : Any> arg(id: String, parser: ParserDescriptor<Source, T>): NonNullableCommandArgument<T> {
    val arg = NonNullableCommandArgument<T>(id, parser, null)
    args.add(arg)
    return arg
  }

  /** Sets the executor of this command. */
  public fun executor(block: suspend CommandExecutionContext.() -> Unit) {
    executor = block
  }

  /** Builds this command. */
  public fun build(): Command = CommandImpl(name, aliases, permission, children, args, async, executor)

  /** Sets an executor for players only */
  public fun playerExecutor(block: suspend CommandExecutionContext.(Player) -> Unit) {
    executor {
      block(player)
    }
  }

  /** Adds a sub command. */
  public fun sub(name: String, aliases: Set<String> = setOf(), block: (@CommandBuilderDsl CommandBuilder).() -> Unit = {}) {
    val builder = CommandBuilder(name, plugin)
    builder.permission("$permission.$name")

    children.add(builder.apply(block).build())
  }

  /** Adds the given [aliases]. */
  public fun aliases(vararg aliases: String) {
    this.aliases += aliases
  }
}

@DslMarker
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
public annotation class CommandBuilderDsl
