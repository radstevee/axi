package net.radsteve.axi.ui.render

import net.kyori.adventure.audience.Audience
import net.radsteve.axi.ui.render.redraw.RedrawResult
import net.radsteve.axi.ui.render.redraw.Redrawable
import net.radsteve.axi.utility.forEachPlayer

/** Something that can be rendered and redrawn. */
public interface RedrawableRenderable :
  Redrawable,
  Renderable {
  /** Ticks and renders this for the given [audience]. */
  public suspend fun renderTick(tick: Int, audience: Audience) {
    val result = tickRedraw(tick)

    if (result == RedrawResult.None) {
      return
    }

    if (result == RedrawResult.Dispose) {
      audience.forEachPlayer { player ->
        player.renderState.currentlyRenderedRenderables.remove(this)
      }
      return
    }

    CompositeRenderer.render(this, renderer, audience)
  }
}
