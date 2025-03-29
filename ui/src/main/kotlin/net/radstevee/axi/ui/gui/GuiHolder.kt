package net.radstevee.axi.ui.gui

import com.noxcrew.interfaces.interfaces.Interface
import com.noxcrew.interfaces.pane.Pane

/** Something that can hold an interfaces GUI. */
public interface GuiHolder<I : Interface<I, P>, P : Pane> {
  /** The GUI. */
  public val gui: I
}
