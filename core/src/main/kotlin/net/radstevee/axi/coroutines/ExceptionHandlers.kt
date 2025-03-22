package net.radstevee.axi.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.job
import net.radstevee.axi.plugin.AxiPluginHolder

/** Prints the stacktrace of a coroutine exception to the [net.radstevee.axi.plugin.AxiPlugin]'s logger */
public val LoggingExceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { ctx, throwable ->
  val name = ctx[CoroutineName]?.name ?: ctx.job[CoroutineName]?.name ?: "<unknown>"
  AxiPluginHolder.plugin().slF4JLogger.error("Exception in coroutine $name", throwable)
}
