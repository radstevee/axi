package net.radsteve.axi.displayname

import net.kyori.adventure.text.Component
import net.radsteve.axi.ecs.get
import net.radsteve.axi.ecs.set
import net.radsteve.axi.plugin.AxiPluginHolder
import org.bukkit.entity.Display
import org.bukkit.entity.Player
import org.bukkit.entity.TextDisplay
import kotlin.properties.Delegates

/** Holds the display name of a player. */
public class DisplayNameComponent(
  /** The display name. */
  displayName: Component,
) {
  /** The display name. */
  public var displayName: Component by Delegates.observable(displayName) { _, _, _ ->
    // textDisplay?.remove()
    // textDisplay = null
  }

  internal var textDisplay: TextDisplay? = null

  internal fun create(player: Player) {
    if (textDisplay != null) {
      return
    }

    textDisplay = player.world.spawn(player.location, TextDisplay::class.java) { display ->
      val transformation = display.transformation
      transformation.translation.add(0f, 0.45f, 0f)
      display.transformation = transformation
      display.billboard = Display.Billboard.CENTER
    }
    player.addPassenger(textDisplay!!)
    player.hideEntity(AxiPluginHolder.plugin(), textDisplay!!)
  }
}

/** The current display name tag of this player. */
public var Player.displayNameTag: Component?
  get() = get<DisplayNameComponent>()?.displayName
  set(value) {
    val existing = get<DisplayNameComponent>()
    if (existing != null && value != null) {
      existing.displayName = value
    } else if (existing == null && value != null) {
      set(DisplayNameComponent(value))
    } else {
      set<DisplayNameComponent>(null)
    }
  }
