package net.radsteve.axi.example.game

import net.kyori.adventure.key.Key.key
import net.radsteve.axi.example.game.tnttag.TntTagInstance
import net.radsteve.axi.game.type.GameType
import net.radsteve.axi.game.type.GameTypeMetadata
import net.radsteve.axi.game.type.GameTypeRegistry
import net.radsteve.axi.ui.text.buildText

public object GameTypes : GameTypeRegistry() {
  public val TntTag: GameType<TntTagInstance> = register(
    ::TntTagInstance,
    GameTypeMetadata(
      key("axi", "tnt_tag"),
      buildText {
        append("TNT Tag")
        red()
      },
    )
  )
}
