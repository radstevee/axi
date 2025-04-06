package net.radsteve.axi.utility

private class UnreachableReachedException : RuntimeException("Unreachable location was reached. This is impossible.")

/** Marks something as unreachable. */
public fun unreachable(): Nothing {
  throw UnreachableReachedException()
}
