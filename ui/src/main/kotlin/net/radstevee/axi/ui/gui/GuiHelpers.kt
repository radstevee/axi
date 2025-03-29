package net.radstevee.axi.ui.gui

import com.noxcrew.interfaces.InterfacesListeners
import com.noxcrew.interfaces.element.Element
import com.noxcrew.interfaces.interfaces.Interface
import com.noxcrew.interfaces.interfaces.InterfaceBuilder
import com.noxcrew.interfaces.pane.Pane
import com.noxcrew.interfaces.view.InterfaceView
import org.bukkit.entity.Player

/** Opens the given GUI [holder] for this player. */
public suspend fun Player.openGui(
  holder: GuiHolder<*, *>,
  parent: InterfaceView? = InterfacesListeners.INSTANCE.convertHolderToInterfaceView(openInventory.topInventory.holder),
) {
  holder.gui.open(this, parent)
}

/** Fills the given [row] with the given [element]. */
public fun <B : InterfaceBuilder<P, I>, P : Pane, I : Interface<I, P>> B.fillRow(
  row: Int,
  element: Element,
) {
  withTransform { pane, view ->
    repeat(9) { column ->
      pane[row, column] = element
    }
  }
}
