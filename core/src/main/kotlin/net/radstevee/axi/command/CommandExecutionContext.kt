package net.radstevee.axi.command

import kotlinx.coroutines.CoroutineScope
import org.bukkit.entity.Player
import org.incendo.cloud.context.CommandContext
import org.incendo.cloud.paper.util.sender.Source
import kotlin.coroutines.CoroutineContext

/** The context of a command execution. */
public interface CommandExecutionContext : CoroutineScope {
  public override val coroutineContext: CoroutineContext

  /** Gets the player of this execution, or throws. */
  @get:Throws(IllegalStateException::class)
  public val player: Player

  /** The command source. */
  public val source: Source

  /** The underlying cloud [CommandContext]. */
  public val ctx: CommandContext<Source>
}
