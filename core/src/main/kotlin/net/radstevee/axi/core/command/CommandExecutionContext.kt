package net.radstevee.axi.core.command

import org.incendo.cloud.context.CommandContext
import org.incendo.cloud.paper.util.sender.Source

/** Holds thread-local execution contexts. */
internal object CommandExecutionContext {
    private val ctx: ThreadLocal<CommandContext<Source>> = ThreadLocal()

    fun ctx(new: CommandContext<Source>) {
        ctx.set(new)
    }

    fun ctx(): CommandContext<Source>? {
        return ctx.get()
    }

    fun unset() {
        ctx.remove()
    }
}
