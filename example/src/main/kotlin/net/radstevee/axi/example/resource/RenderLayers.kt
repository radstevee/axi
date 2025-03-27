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
        RedrawResult.Redraw
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
    redraw { tick ->
      if (tick % 2 == 0) {
        RedrawResult.Redraw
      } else {
        RedrawResult.None
      }
    }

    content {
      appendSpace((50 * sin(Bukkit.getCurrentTick().toDouble() / 2)).roundToInt())
      append("mmm ah yes cheese")
      font(Fonts.BeaverOffsets[10.0]!!)
      green()
    }
  }
}

public val OtherLayer: RenderLayer = buildRenderLayer {
  add {
    content(-50) {
      append("bye, world!")
      font(Fonts.BeaverOffsets[-10.0]!!)
    }
  }
}
