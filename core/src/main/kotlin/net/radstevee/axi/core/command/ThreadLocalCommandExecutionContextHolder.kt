package net.radstevee.axi.core.command

internal object ThreadLocalCommandExecutionContextHolder {
  val local: ThreadLocal<CommandExecutionContext> = ThreadLocal()
}
