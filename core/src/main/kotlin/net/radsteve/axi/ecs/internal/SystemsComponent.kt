package net.radsteve.axi.ecs.internal

import net.radsteve.axi.ecs.system.System

internal data class SystemsComponent(
  val systems: MutableList<System> = mutableListOf(),
)
