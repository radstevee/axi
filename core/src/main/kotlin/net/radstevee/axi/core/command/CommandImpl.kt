package net.radstevee.axi.core.command

import org.incendo.cloud.context.CommandContext
import org.incendo.cloud.paper.util.sender.Source

/** A basic implementation of a [Command]. */
public class CommandImpl(
  override val name: String,
  override val aliases: Set<String>,
  override val permission: String,
  override val children: Set<Command>,
  override val args: Set<CommandArgument<*>>,
  override val asyncHandler: Boolean,
  private val executor: suspend CommandContext<Source>.() -> Unit,
) : Command {
  override suspend fun CommandContext<Source>.execute() {
    executor()
  }
}
