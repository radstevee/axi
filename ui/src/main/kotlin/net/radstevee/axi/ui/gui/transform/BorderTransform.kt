package net.radstevee.axi.ui.gui.transform

import com.noxcrew.interfaces.drawable.Drawable.Companion.drawable
import com.noxcrew.interfaces.element.Element
import com.noxcrew.interfaces.element.StaticElement
import com.noxcrew.interfaces.grid.GridPoint
import com.noxcrew.interfaces.interfaces.Interface
import com.noxcrew.interfaces.interfaces.InterfaceBuilder
import com.noxcrew.interfaces.pane.Pane
import com.noxcrew.interfaces.transform.Transform
import com.noxcrew.interfaces.utilities.forEachInGrid
import com.noxcrew.interfaces.view.InterfaceView
import net.radstevee.axi.utility.buildItemStack
import net.radstevee.axi.utility.editItemMeta
import org.bukkit.Material

/** A transform that applies a border to a pane. */
public class BorderTransform<P : Pane>(
  /** The element used for the border. */
  public val borderElement: Element = DEFAULT_BORDER_ELEMENT,
  /** How many rows the border should take up */
  public val rows: Int = 6,
  /** The width of the border. */
  public val width: Int = 1,
  /** Excluded slots. */
  public val exclusions: Set<GridPoint> = setOf(),
) : Transform<P> {
  override suspend fun invoke(
    pane: P,
    view: InterfaceView,
  ) {
    forEachInGrid(rows, COLUMNS) { row, col ->
      val point = GridPoint.at(row, col)

      if (point in exclusions) {
        return@forEachInGrid
      }

      if (row < width) { // top
        pane[row, col] = borderElement
      } else if (row >= rows - width) { // bottom
        pane[row, col] = borderElement
      } else if (col < width || col >= COLUMNS - width) { // left / right
        pane[row, col] = borderElement
      }
    }
  }

  public companion object {
    private const val COLUMNS = 9
    private val DEFAULT_BORDER_ELEMENT: StaticElement = StaticElement(
      drawable(
        buildItemStack(Material.GRAY_STAINED_GLASS_PANE) {
          editItemMeta { isHideTooltip = true }
        },
      ),
    )

    /** Applies a border transform to this interface. */
    public fun <B : InterfaceBuilder<P, I>, P : Pane, I : Interface<I, P>> B.withBorder(
      borderElement: StaticElement = DEFAULT_BORDER_ELEMENT,
      rows: Int = 6,
      width: Int = 1,
      exclusions: Set<GridPoint> = setOf(),
    ): BorderTransform<P> {
      val transform = BorderTransform<P>(borderElement, rows, width, exclusions)
      withTransform(transform = transform)

      return transform
    }
  }
}
