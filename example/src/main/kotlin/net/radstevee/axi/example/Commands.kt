package net.radstevee.axi.example

import net.kyori.adventure.text.Component.text
import net.radstevee.axi.core.command.AutoRegistered
import net.radstevee.axi.core.command.Command
import net.radstevee.axi.core.command.sendMessage
import org.incendo.cloud.parser.standard.IntegerParser.integerParser
import org.incendo.cloud.parser.standard.StringParser.stringParser

@AutoRegistered
public val TestCommand: Command = Command("test") {
  executor { sendMessage(text("Hi!!!")) }

  sub("one") {
    val id by arg("id", stringParser())

    playerExecutor { _ ->
      sendMessage(text("id: $id"))
    }
  }

  sub("two") {
    val num by arg("number", integerParser())

    executor {
      sendMessage(text("number: $num"))
    }

    sub("three") {
      executor { sendMessage(text("omg: $num")) }
    }
  }
}

@AutoRegistered
public val OtherTestCommand: Command = Command("other_test") {
  executor { sendMessage(text("Bye!!!")) }
}
