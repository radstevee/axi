package net.radstevee.axi.ui.gui.transform

import com.noxcrew.interfaces.click.ClickContext
import com.noxcrew.interfaces.click.CompletableClickHandler
import com.noxcrew.interfaces.drawable.Drawable
import com.noxcrew.interfaces.drawable.Drawable.Companion.drawable
import com.noxcrew.interfaces.element.Element
import com.noxcrew.interfaces.element.StaticElement
import com.noxcrew.interfaces.grid.GridPoint
import com.noxcrew.interfaces.interfaces.Interface
import com.noxcrew.interfaces.interfaces.InterfaceBuilder
import com.noxcrew.interfaces.pane.Pane
import com.noxcrew.interfaces.properties.InterfaceProperty
import com.noxcrew.interfaces.properties.interfaceProperty
import com.noxcrew.interfaces.transform.Transform
import com.noxcrew.interfaces.view.InterfaceView
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

/** A transform that applies a pagination to a pane. */
public class PaginationTransform<P : Pane, T>(
  /** The interface property of the items. */
  itemsProp: InterfaceProperty<List<T>>,
  /** Maps an item to a drawable. */
  private val mapper: (T) -> Drawable,
  /** Handles clicks. */
  private val clickHandler: CompletableClickHandler.(ctx: ClickContext, item: T) -> Unit,
  /** The width of the pagination grid. */
  private val width: Int = 7,
  /** The height of the pagination grid. */
  private val height: Int = 3,
  /** A horizontal and vertical offset to item positioning. */
  private val offset: Int = 0,
  /** The position for the previous page button. */
  private val previousPagePosition: GridPoint = GridPoint.at(height - 1, 0),
  /** The position for the next page button. */
  private val nextPagePosition: GridPoint = GridPoint.at(height - 1, width + 1),
  /** The drawable for the previous page button. */
  previousPageDrawable: Drawable = drawable(ItemStack.of(Material.ARROW)),
  /** The drawable for the next page button. */
  nextPageDrawable: Drawable = drawable(ItemStack.of(Material.ARROW)),
) : Transform<P> {
  public var items: List<T> by itemsProp
  public val pageProp: InterfaceProperty<Int> = interfaceProperty(0)
  private var page: Int by pageProp
  private val maxPage: Int get() = items.size / (width * height)
  private val pages: Map<Int, List<T>> get() = buildMap {
    var startIdx = 0
    for (idx in 0 until maxPage + 1) {
      val endIdx = startIdx + (height * width).coerceAtMost(items.size - startIdx)
      this[idx] = items.subList(startIdx, endIdx)
      startIdx = endIdx
    }
  }
  private val itemsOnPage: List<T> get() = pages[page] ?: emptyList()
  private val previousPage: Element = StaticElement(previousPageDrawable) {
    if (page > 0) {
      page--
    }
  }
  private val nextPage: Element = StaticElement(nextPageDrawable) {
    if (page < maxPage) {
      page++
    }
  }

  override suspend fun invoke(
    pane: P,
    view: InterfaceView,
  ) {
    val itemsSplit = itemsOnPage.chunked(width)

    pane[previousPagePosition] = previousPage
    pane[nextPagePosition] = nextPage

    for (idx in 1 until width + 1) {
      runCatching {
        repeat(height) { row ->
          val item = itemsSplit[row][idx - 1]

          pane[row + 1 + offset, idx + offset] = StaticElement(mapper(item)) { ctx ->
            clickHandler(ctx, item)
          }
        }
      }
    }
  }

  /** Provides utility extensions to interface builders. */
  public companion object Extensions {
    /** Applies a [PaginationTransform] to this interface. See its KDoc for information on args. */
    public fun <B : InterfaceBuilder<P, I>, P : Pane, I : Interface<I, P>, T> B.withPagination(
      /** The items. */
      items: List<T>,
      mapper: (T) -> Drawable,
      clickHandler: CompletableClickHandler.(ctx: ClickContext, item: T) -> Unit,
      width: Int = 7,
      height: Int = 3,
      offset: Int = 0,
      previousPagePosition: GridPoint = GridPoint.at(height - 1, 0),
      nextPagePosition: GridPoint = GridPoint.at(height - 1, width + 1),
      previousPageDrawable: Drawable = drawable(ItemStack.of(Material.ARROW)),
      nextPageDrawable: Drawable = drawable(ItemStack.of(Material.ARROW)),
    ): PaginationTransform<P, T> = withPagination(
      interfaceProperty(items),
      mapper,
      clickHandler,
      width,
      height,
      offset,
      previousPagePosition,
      nextPagePosition,
      previousPageDrawable,
      nextPageDrawable,
    )

    /** Applies a [PaginationTransform] to this interface. See its KDoc for information on args. */
    public fun <B : InterfaceBuilder<P, I>, P : Pane, I : Interface<I, P>, T> B.withPagination(
      itemsProp: InterfaceProperty<List<T>>,
      mapper: (T) -> Drawable,
      clickHandler: CompletableClickHandler.(ctx: ClickContext, item: T) -> Unit,
      width: Int = 7,
      height: Int = 3,
      offset: Int = 0,
      previousPagePosition: GridPoint = GridPoint.at(height - 1, 0),
      nextPagePosition: GridPoint = GridPoint.at(height - 1, width + 1),
      previousPageDrawable: Drawable = drawable(ItemStack.of(Material.ARROW)),
      nextPageDrawable: Drawable = drawable(ItemStack.of(Material.ARROW)),
    ): PaginationTransform<P, T> {
      val transform = PaginationTransform<P, _>(
        itemsProp,
        mapper,
        clickHandler,
        width,
        height,
        offset,
        previousPagePosition,
        nextPagePosition,
        previousPageDrawable,
        nextPageDrawable,
      )

      withTransform(itemsProp, transform.pageProp, transform = transform)

      return transform
    }
  }
}
