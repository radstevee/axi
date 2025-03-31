package net.radsteve.axi.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.job
import net.radsteve.axi.plugin.AxiPluginHolder

/** Prints the stacktrace of a coroutine exception to the [net.radsteve.axi.plugin.AxiPlugin]'s logger */
public val LoggingExceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { ctx, throwable ->
  val name = ctx[CoroutineName]?.name ?: ctx.job[CoroutineName]?.name ?: "<unknown>"
  AxiPluginHolder.plugin().slF4JLogger.error("Exception in coroutine $name", throwable)
}
