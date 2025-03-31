package net.radsteve.axi.ui.text

import com.google.gson.Gson
import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer

private val GSON: Gson = Gson()

/** Converts a component to a JSON string. */
public fun ComponentLike.json(): String {
  return GSON.toJson(GsonComponentSerializer.gson().serializeToTree(asComponent()))
}
