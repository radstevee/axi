package net.radstevee.axi.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.job
import net.radstevee.axi.core.internal.AxiPluginHolder

public val StacktracePrintingCoroutineExceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { ctx, throwable ->
    val name = ctx[CoroutineName.Key]?.name ?: ctx.job[CoroutineName.Key]?.name ?: "<unknown>"
    AxiPluginHolder.plugin().slF4JLogger.error("Exception in coroutine $name", throwable)
}
