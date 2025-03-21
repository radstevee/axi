package net.radstevee.axi.ui.render

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.TextComponent
import net.radstevee.axi.ui.render.layer.layered.buildLayeredText
import net.radstevee.axi.util.players
import org.bukkit.entity.Player

/** Renders renderables for an audience. */
public object CompositeRenderer {
  private suspend fun stack(player: Player, renderable: RedrawableRenderable): TextComponent {
    val renderState = player.renderState
    renderState.currentlyRenderedRenderables.add(renderable)

    return buildLayeredText(layers = renderState.currentlyRenderedRenderables.map { renderable -> renderable.render() })
  }

  /** Renders the given [renderable] to the given [audience] using the given [renderer]. */
  public suspend fun render(renderable: RedrawableRenderable, renderer: Renderer, audience: Audience) {
    audience.players().forEach { player ->
      renderer.render(player, renderable, stack(player, renderable))
    }
  }
}
