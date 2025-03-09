package net.radstevee.axi.core.command

import net.radstevee.axi.core.plugin.AxiPlugin
import org.bukkit.entity.Player
import org.incendo.cloud.context.CommandContext
import org.incendo.cloud.paper.util.sender.Source
import org.incendo.cloud.parser.ParserDescriptor

/** A command builder. */
public class CommandBuilder(
    /** The command name. */
    public val name: String,
    /** The aliases of this command. */
    public val aliases: Set<String>,
    /** The plugin associated with this command. */
    private val plugin: AxiPlugin,
) {
    private var permission: String = "${plugin.name}.command.$name"
    private val children: MutableSet<Command> = mutableSetOf()
    private var executor: suspend CommandContext<Source>.() -> Unit = {}
    private val args: MutableSet<CommandArgument<*>> = mutableSetOf()
    private var async: Boolean = false

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

    public fun <T : Any> defaultedArg(id: String, parser: ParserDescriptor<Source, T>, default: T): NonNullableCommandArgument<T> {
        val arg = NonNullableCommandArgument<T>(id, parser, default)
        args.add(arg)
        return arg
    }

    public fun <T : Any> arg(id: String, parser: ParserDescriptor<Source, T>): NonNullableCommandArgument<T> {
        val arg = NonNullableCommandArgument<T>(id, parser, null)
        args.add(arg)
        return arg
    }

    /** Sets the executor of this command. */
    public fun executor(block: suspend CommandContext<Source>.() -> Unit) {
        executor = block
    }

    /** Builds this command. */
    public fun build(): Command {
        return CommandImpl(name, aliases, permission, children, args, async, executor)
    }

    /** Sets an executor for players only */
    public fun playerExecutor(block: suspend CommandContext<Source>.(Player) -> Unit) {
        executor {
            block(player)
        }
    }

    /** Adds a sub command. */
    public fun sub(name: String, aliases: Set<String> = setOf(), block: CommandBuilder.() -> Unit) {
        val builder = CommandBuilder(name, aliases, plugin)
        builder.permission("$permission.$name")

        children.add(builder.apply(block).build())
    }
}
