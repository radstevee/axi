package net.radstevee.axi.core.command

import net.radstevee.axi.core.plugin.AxiPlugin
import net.radstevee.axi.core.plugin.AxiPluginHolder
import org.incendo.cloud.context.CommandContext
import org.incendo.cloud.paper.util.sender.Source

/** Represents a wrapped cloud command. */
public interface Command {
    /** The name of this command. */
    public val name: String

    /** This aliases of this command. */
    public val aliases: Set<String>

    /** The permission required to use this command, defaults to `pluginName.command.commandName`. */
    public val permission: String

    /** The children of this command. */
    public val children: Set<Command>

    /** The arguments of this command. */
    public val args: Set<CommandArgument<*>>

    /** Whether [execute] should be called asynchronously. */
    public val asyncHandler: Boolean

    /** Executes this command. */
    public suspend fun CommandContext<Source>.execute()
}

/** Builds and creates a command. */
public fun Command(name: String, aliases: Set<String> = setOf(), plugin: AxiPlugin = AxiPluginHolder.plugin(), block: CommandBuilder.() -> Unit): Command {
    return CommandBuilder(name, aliases, plugin).apply(block).build()
}

/** Marks a command to be registered automatically and have a generated class by the KSP processor. */
public annotation class AutoRegistered
