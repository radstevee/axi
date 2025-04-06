package net.radsteve.axi.command.parser

import net.radsteve.axi.command.caption.CaptionRegistry
import org.incendo.cloud.caption.Caption
import org.incendo.cloud.caption.CaptionVariable
import org.incendo.cloud.context.CommandContext
import org.incendo.cloud.context.CommandInput
import org.incendo.cloud.exception.parsing.ParserException
import org.incendo.cloud.parser.ArgumentParseResult
import org.incendo.cloud.parser.ArgumentParser
import org.incendo.cloud.parser.ParserDescriptor
import org.incendo.cloud.suggestion.BlockingSuggestionProvider

/** An argument parser for a Map<String, [T]>. */
public open class StringMapEntryParser<C, T : Any>(private val mapSupplier: () -> Map<String, T>) :
  ArgumentParser<C, T>,
  BlockingSuggestionProvider.Strings<C> {
  override fun parse(
    commandContext: CommandContext<C & Any>,
    commandInput: CommandInput,
  ): ArgumentParseResult<T> {
    val input = commandInput.readString()

    val entry = mapSupplier()[input.lowercase()]
    entry?.let { entry ->
      return ArgumentParseResult.success(entry)
    }

    return ArgumentParseResult.failure(
      StringMapEntryParserException(
        CaptionRegistry.AxiCaptions.InvalidMapKey,
        input,
        commandContext,
      ),
    )
  }

  override fun stringSuggestions(
    commandContext: CommandContext<C?>,
    input: CommandInput,
  ): Iterable<String> = mapSupplier().keys

  private class StringMapEntryParserException(
    caption: Caption,
    input: String,
    context: CommandContext<*>,
  ) : ParserException(StringMapEntryParser::class.java, context, caption, CaptionVariable.of("input", input))

  public companion object {
    /** Creates a [StringMapEntryParser] from the given [mapSupplier]. */
    public inline fun <C : Any, reified T : Any> stringMapEntryParser(noinline mapSupplier: () -> Map<String, T>): ParserDescriptor<C, T> {
      return ParserDescriptor.of(StringMapEntryParser<C, T>(mapSupplier), T::class.java)
    }
  }
}
