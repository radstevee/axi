package net.radsteve.axi.utility

import net.kyori.adventure.text.format.TextColor
import net.minecraft.util.ARGB
import net.minecraft.util.Mth

/** Lerps between the given colors [a] and [b] with the given [delta] time. */
public fun lerpColor(delta: Float, a: Int, b: Int): Int {
  val red = Mth.lerpInt(delta, ARGB.red(a), ARGB.red(b))
  val green = Mth.lerpInt(delta, ARGB.green(a), ARGB.green(b))
  val blue = Mth.lerpInt(delta, ARGB.blue(a), ARGB.blue(b))

  return red shl 16 or green shl 8 or blue
}

/** Lerps between the given colors [a] and [b] with the given [delta] time. */
public fun lerpColor(delta: Float, a: TextColor, b: TextColor): TextColor {
  return TextColor.color(lerpColor(delta, a.value(), b.value()))
}
