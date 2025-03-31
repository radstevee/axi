package net.radsteve.axi.command

import net.radsteve.axi.plugin.AxiPlugin
import net.radsteve.axi.plugin.AxiPluginHolder
import org.jetbrains.annotations.ApiStatus

/** Represents a wrapped cloud command. */
public interface Command {
  /** The name of this command. */
  public val name: String

  /** This aliases of this command. */
  public val aliases: Set<String>

  /** The permission required to use this command, defaults to `pluginName.command.commandName`. */
  @set:ApiStatus.Internal
  public var permission: String

  /** The children of this command. */
  public val children: Set<Command>

  /** The arguments of this command. */
  public val args: Set<CommandArgument<*>>

  /** Whether [execute] should be called asynchronously. */
  public val asyncHandler: Boolean

  /** Executes this command. */
  public suspend fun CommandExecutionContext.execute()
}

/** Builds and creates a command. */
public fun Command(
  name: String,
  plugin: AxiPlugin = AxiPluginHolder.plugin(),
  block: @CommandBuilderDsl CommandBuilder.() -> Unit = {},
): Command = CommandBuilder(name, plugin).apply(block).build()

/** Marks a command to be registered automatically and have a generated class by the KSP processor. */
public annotation class AutoRegistered
