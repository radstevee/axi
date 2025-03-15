package net.radstevee.axi.ui.render

import net.radstevee.axi.core.ecs.Attachable
import net.radstevee.axi.core.ecs.ECSDataTracker.getOrPut
import net.radstevee.axi.core.ecs.getOrPut
import org.bukkit.entity.Player

/** The currently rendered renderables of an attachable. */
public data class RenderStateComponent(
  /** The currently rendered renderables. */
  public val currentlyRenderedRenderables: MutableSet<RedrawableRenderable> = mutableSetOf(),
)

/** This attachable's [RenderStateComponent]. */
public val Attachable.renderState: RenderStateComponent get() = getOrPut(RenderStateComponent())

/** This player's [RenderStateComponent]. */
public val Player.renderState: RenderStateComponent get() = getOrPut(RenderStateComponent())
