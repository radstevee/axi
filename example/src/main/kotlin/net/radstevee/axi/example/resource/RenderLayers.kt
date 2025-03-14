package net.radstevee.axi.example.resource

import net.radstevee.axi.ui.render.layer.RenderLayer
import net.radstevee.axi.ui.render.layer.buildRenderLayer
import net.radstevee.axi.ui.render.redraw.RedrawResult
import org.bukkit.Bukkit
import kotlin.math.roundToInt
import kotlin.math.sin

public fun testRenderLayer(initTick: Int): RenderLayer = buildRenderLayer {
  add {
    content {
      append("Tick: ${Bukkit.getCurrentTick()}")
      font(Fonts.BeaverOffsets[20.0]!!)
    }

    redraw { tick ->
      // Disappear after 10 seconds
      if (tick > initTick + 200) {
        RedrawResult.Dispose
      } else {
        // Only redraw every 10 ticks
        if (tick % 10 == 0) {
          RedrawResult.Redraw
        } else {
          RedrawResult.None
        }
      }
    }
  }

  add {
    content {
      append("Hello world!")
      font(Fonts.Beaver)
    }
  }

  add {
    content {
      appendSpace((75 * sin(Bukkit.getCurrentTick().toDouble() / 2)).roundToInt())
      append("mmm ah yes cheese")
      font(Fonts.BeaverOffsets[10.0]!!)
    }

    redraw { tick ->
      if (tick % 2 == 0) {
        RedrawResult.Redraw
      } else {
        RedrawResult.None
      }
    }
  }
}
