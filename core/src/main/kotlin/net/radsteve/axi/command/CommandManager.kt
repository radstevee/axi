package net.radsteve.axi.command

import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.NamedTextColor.RED
import net.radsteve.axi.command.caption.CaptionRegistry
import net.radsteve.axi.plugin.AxiPlugin
import net.radsteve.axi.plugin.AxiPluginHolder
import org.incendo.cloud.brigadier.BrigadierSetting.FORCE_EXECUTABLE
import org.incendo.cloud.exception.CommandExecutionException
import org.incendo.cloud.execution.ExecutionCoordinator.simpleCoordinator
import org.incendo.cloud.paper.PaperCommandManager
import org.incendo.cloud.paper.util.sender.PaperSimpleSenderMapper.simpleSenderMapper
import org.incendo.cloud.paper.util.sender.Source

/** A typealias to cloud's [PaperCommandManager]. */
public typealias CommandManager = PaperCommandManager<Source>

/** Creates a new command manager for the given [plugin]. */
public fun CommandManager(plugin: AxiPlugin = AxiPluginHolder.plugin()): CommandManager {
  val manager = PaperCommandManager.builder(simpleSenderMapper())
    .executionCoordinator(simpleCoordinator())
    .buildOnEnable(plugin)

  manager.captionRegistry().registerProvider(CaptionRegistry.provider())

  manager.exceptionController().registerHandler(CommandExecutionException::class.java) { ctx ->
    val exception = ctx.exception().cause ?: return@registerHandler
    ctx.context().sendMessage(text(exception.message ?: "<no message>", RED))
  }

  val brig = manager.brigadierManager()
  brig.settings().set(FORCE_EXECUTABLE, true)
  brig.setNativeNumberSuggestions(true)

  registerAutoRegisteredCommands(plugin, manager)

  return manager
}
