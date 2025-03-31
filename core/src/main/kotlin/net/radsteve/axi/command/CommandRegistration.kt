package net.radsteve.axi.command

import kotlinx.coroutines.coroutineScope
import net.radsteve.axi.command.internal.CloudCommandExecutionContext
import net.radsteve.axi.coroutines.AxiCoroutines.asyncContext
import net.radsteve.axi.coroutines.AxiCoroutines.coroutineScope
import net.radsteve.axi.coroutines.AxiCoroutines.syncContext
import net.radsteve.axi.plugin.AxiPlugin
import net.radsteve.axi.plugin.AxiPluginHolder
import org.incendo.cloud.kotlin.MutableCommandBuilder
import org.incendo.cloud.kotlin.coroutines.extension.suspendingHandler
import org.incendo.cloud.kotlin.extension.buildAndRegister
import org.incendo.cloud.paper.util.sender.Source
import java.util.ServiceLoader

internal fun autoRegisteredCommands(plugin: AxiPlugin): Iterator<Command> {
  return ServiceLoader.load(Command::class.java, plugin.javaClass.classLoader).iterator()
}

/** Registers a command to the given [manager]. */
// God this is a shitshow
// I will pray for anyone who needs to debug this
public fun Command.register(manager: CommandManager = AxiPluginHolder.plugin().commandManager) {
  fun MutableCommandBuilder<Source>.register(command: Command) {
    permission(command.permission)

    command.args.forEach { arg ->
      if (arg is NonNullableCommandArgument<*>) {
        if (arg.default != null) {
          optional(arg.id, arg.descriptor)
        } else {
          required(arg.id, arg.descriptor)
        }
      } else {
        optional(arg.id, arg.descriptor)
      }
    }
    val coroutineContext = if (command.asyncHandler) {
      asyncContext
    } else {
      syncContext
    }

    suspendingHandler(scope = coroutineScope, context = coroutineContext) { ctx ->
      coroutineScope {
        val executionContext = CloudCommandExecutionContext(ctx, coroutineContext, this)
        CloudCommandExecutionContext.Companion.Holder.set(executionContext)
        try {
          with(command) {
            executionContext.execute()
          }
        } finally {
          CloudCommandExecutionContext.Companion.Holder.remove()
        }
      }
    }
  }

  val aliases = aliases.toTypedArray()

  manager.buildAndRegister(name, aliases = aliases) {
    register(this@register)
  }

  fun registerChildren(parentName: String, parentAliases: Array<String>, children: Set<Command>) {
    fun MutableCommandBuilder<Source>.registerChildren(node: Command) {
      literal(node.name, aliases = node.aliases.toTypedArray()).build {
        register(node)
        node.children.forEach { child ->
          registerChildren(child)
        }
      }
    }

    children.forEach { child ->
      manager.buildAndRegister(parentName, aliases = parentAliases) {
        this.registerChildren(child)
      }
    }
  }

  registerChildren(name, aliases, children)
}

internal fun registerAutoRegisteredCommands(plugin: AxiPlugin, manager: CommandManager) {
  autoRegisteredCommands(plugin).forEach { command -> command.register(manager) }
}
