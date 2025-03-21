package net.radstevee.axi.example

import net.kyori.adventure.text.Component.text
import net.radstevee.axi.command.AutoRegistered
import net.radstevee.axi.command.Command
import net.radstevee.axi.command.sendMessage
import org.incendo.cloud.parser.standard.IntegerParser.integerParser
import org.incendo.cloud.parser.standard.StringParser.stringParser

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

  sub("two") {
    val num by arg("number", integerParser())

    executor {
      ctx.sendMessage(text("number: $num"))
    }

    sub("three") {
      executor {
        ctx.sendMessage(text("omg: $num"))
      }
    }
  }
}

@AutoRegistered
public val OtherTestCommand: Command = Command("other_test") {
  val name by arg("name", stringParser())

  executor {
    ctx.sendMessage(text("Hello, $name!"))
  }

  sub("bye") {
    executor {
      ctx.sendMessage(text("Bye, $name!"))
    }
  }
}
