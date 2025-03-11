package net.radstevee.axi.core.command

import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.incendo.cloud.context.CommandContext
import org.incendo.cloud.paper.util.sender.Source

/** Sends the command source a message. */
public fun CommandContext<Source>.sendMessage(component: Component) {
  sender().source().sendMessage(component)
}

/** Throws an [IllegalArgumentException] for the given [arg]. */
public fun CommandContext<Source>.illegalArg(arg: String, message: String): Nothing = throw IllegalArgumentException("Invalid argument $arg: $message")

/** Gets the player source, or throws an [IllegalStateException]. */
@get:Throws(IllegalStateException::class)
public val CommandContext<Source>.player: Player get() {
  val sender = sender().source()
  if (sender !is Player) {
    error("Only players can execute this command!")
  }

  return sender
}
