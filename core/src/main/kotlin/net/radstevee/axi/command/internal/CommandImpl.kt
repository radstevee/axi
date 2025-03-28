package net.radstevee.axi.command.internal

import net.radstevee.axi.command.Command
import net.radstevee.axi.command.CommandArgument
import net.radstevee.axi.command.CommandExecutionContext

/** A basic implementation of a [net.radstevee.axi.command.Command]. */
public class CommandImpl(
  override val name: String,
  override val aliases: Set<String>,
  override var permission: String,
  override val children: Set<Command>,
  override val args: Set<CommandArgument<*>>,
  override val asyncHandler: Boolean,
  private val executor: suspend CommandExecutionContext.() -> Unit,
) : Command {
  override suspend fun CommandExecutionContext.execute() {
    executor()
  }
}
