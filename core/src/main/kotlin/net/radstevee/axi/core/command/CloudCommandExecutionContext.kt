package net.radstevee.axi.core.command

import kotlinx.coroutines.CoroutineScope
import org.bukkit.entity.Player
import org.incendo.cloud.context.CommandContext
import org.incendo.cloud.paper.util.sender.Source
import kotlin.coroutines.CoroutineContext

internal class CloudCommandExecutionContext(
  override val ctx: CommandContext<Source>,
  override var coroutineContext: CoroutineContext,
  scope: CoroutineScope,
) : CommandExecutionContext,
  CoroutineScope by scope {
  override val player: Player get() = ctx.player
  override val source: Source get() = ctx.sender()
}
