package net.radsteve.axi.utility

/** Formats a duration of the given [seconds] to a MM:SS string. */
public fun formatSeconds(seconds: Int): String {
  val minutes = seconds / 60
  val remainingSeconds = seconds % 60
  return "%02d:%02d".format(minutes, remainingSeconds)
}
