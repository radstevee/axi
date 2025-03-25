package net.radstevee.axi.command

import kotlinx.coroutines.CoroutineScope
import org.bukkit.entity.Player
import org.incendo.cloud.context.CommandContext
import org.incendo.cloud.paper.util.sender.Source
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

internal class CloudCommandExecutionContext(
  override val ctx: CommandContext<Source>,
  override var coroutineContext: CoroutineContext,
  scope: CoroutineScope,
) : AbstractCoroutineContextElement(CloudCommandExecutionContext),
  CommandExecutionContext,
  CoroutineScope by scope {
  override val player: Player by lazy { ctx.player }
  override val source: Source by lazy { ctx.sender() }

  companion object : CoroutineContext.Key<CloudCommandExecutionContext>
}
