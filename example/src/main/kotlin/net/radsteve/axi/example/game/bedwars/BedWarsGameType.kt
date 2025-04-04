package net.radsteve.axi.example.game.bedwars

import net.kyori.adventure.key.Key.key
import net.radsteve.axi.game.type.GameType
import net.radsteve.axi.game.type.GameTypeMetadata
import net.radsteve.axi.ui.text.buildText

public object BedWarsGameType : GameType<BedWarsInstance>(
  ::BedWarsInstance,
  GameTypeMetadata(
    key("axi", "bed_wars"),
    buildText {
      append("BedWars")
      red()
    },
    buildText {
      append("You know this one.")
    }
  )
)

/**
// An alternative way of doing the above would be this:

public object ExampleGameTypes : GameTypeRegistry() {
  public val BedWars: GameType<BedWarsInstance> = register(
    GameType(
      ::BedWarsInstance,
      GameTypeMetadata(
        key("axi", "bed_wars"),
        buildText {
          append("BedWars")
          red()
        },
        buildText {
          append("You know this one.")
        }
      )
    )
  )
}
*/
