package net.radstevee.axi.ui.text

import com.google.gson.Gson
import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer

private val GSON: Gson = Gson()

public fun ComponentLike.json(): String = GSON.toJson(GsonComponentSerializer.gson().serializeToTree(asComponent()))
