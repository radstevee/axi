package net.radstevee.axi.ui.render

import net.kyori.adventure.audience.Audience
import net.radstevee.axi.core.ecs.getOrPut
import net.radstevee.axi.core.util.forEachPlayer
import net.radstevee.axi.ui.render.redraw.RedrawResult
import net.radstevee.axi.ui.render.redraw.Redrawable

/** Something that can be rendered and redrawn. */
public interface RedrawableRenderable : Redrawable, Renderable {
  /** Ticks and renders this for the given [audience]. */
  public fun renderTick(tick: Int, audience: Audience) {
    val result = tickRedraw(tick)

    if (result == RedrawResult.None) {
      return
    }

    if (result == RedrawResult.Dispose) {
      audience.forEachPlayer { player ->
        player.getOrPut(RenderStateComponent()).currentlyRenderedRenderables.remove(this)
      }
      return
    }

    CompositeRenderer.render(this, renderer, audience)
  }
}
