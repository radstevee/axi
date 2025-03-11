package net.radstevee.axi.ui.render

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.TextComponent
import net.radstevee.axi.core.ecs.getOrPut
import net.radstevee.axi.core.util.forEachPlayer
import net.radstevee.axi.ui.render.layer.layered.buildLayeredText
import org.bukkit.entity.Player

/** Renders renderables for an audience. */
public object CompositeRenderer {
  private fun stack(player: Player, renderable: Renderable): TextComponent {
    val component = player.getOrPut(PlayerRenderedComponent())
    component.currentlyRenderedRenderables.add(renderable)

    return buildLayeredText(component.currentlyRenderedRenderables)
  }

  /** Renders the given [renderable] to the given [audience] using the given [renderer]. */
  public fun render(renderable: Renderable, renderer: Renderer, audience: Audience) {
    audience.forEachPlayer { player ->
      renderer.render(player, renderable, stack(player, renderable))
    }
  }
}
