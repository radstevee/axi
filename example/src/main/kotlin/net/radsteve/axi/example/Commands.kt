package net.radsteve.axi.example

import net.kyori.adventure.text.Component.text
import net.radsteve.axi.command.AutoRegistered
import net.radsteve.axi.command.Command
import net.radsteve.axi.command.sendMessage
import net.radsteve.axi.ecs.data
import net.radsteve.axi.ecs.set
import net.radsteve.axi.example.game.bedwars.BedWarsGameType
import net.radsteve.axi.example.game.bedwars.BedWarsInstance
import net.radsteve.axi.game.instance.GameContext
import net.radsteve.axi.game.instance.GameInstanceController
import net.radsteve.axi.ui.text.mm
import net.radsteve.axi.utility.audience
import org.bukkit.entity.Player
import org.incendo.cloud.bukkit.parser.selector.MultiplePlayerSelectorParser.multiplePlayerSelectorParser
import org.incendo.cloud.parser.standard.IntegerParser.integerParser
import org.incendo.cloud.parser.standard.StringParser.stringParser

private val TestTwoCommand = Command("two") {
  val num by arg("num", integerParser())

  executor {
    ctx.sendMessage(text("number: $num"))
  }

  sub("three") {
    executor {
      ctx.sendMessage(text("omg: $num"))
    }
  }
}

@AutoRegistered
public val TestCommand: Command = Command("test") {
  executor {
    ctx.sendMessage(text("Hi!!!"))
  }

  sub("one") {
    val id by arg("id", stringParser())

    playerExecutor { player ->
      player.sendMessage(text("id: $id"))
    }
  }

  sub(TestTwoCommand)
}

@AutoRegistered
public val OtherTestCommand: Command = Command("other_test") {
  val name by arg("name", stringParser())

  executor {
    var test by player.data<TestComponent>()
    test = TestComponent("<rainbow>$name".mm)
  }

  sub("bye") {
    executor {
      player.set<TestComponent>(null)
    }
  }
}

@AutoRegistered
public val BedWarsCommand: Command = Command("bedwars") {
  val playersArg by arg("players", multiplePlayerSelectorParser())

  executor {
    val players = playersArg.values()
    val context = GameContext(BedWarsGameType, players.audience, players.map(Player::getUniqueId).toMutableList())

    val instance: BedWarsInstance = GameInstanceController.create(context)
  }
}
