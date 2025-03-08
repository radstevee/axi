package net.radstevee.axi.core.command

import net.kyori.adventure.text.Component
import org.incendo.cloud.context.CommandContext
import org.incendo.cloud.paper.util.sender.Source

public fun CommandContext<Source>.sendMessage(component: Component) {
    sender().source().sendMessage(component)
}
