package net.radstevee.axi.ecs.internal

import net.radstevee.axi.ecs.system.System

internal data class SystemsComponent(
  val systems: MutableList<System> = mutableListOf(),
)
