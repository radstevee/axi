package net.radsteve.axi.utility

/** Marks that something is internal to axi. */
@RequiresOptIn(
  message = "The API you are trying to use is internal to axi and unsupported. " +
    "Please reconsider or open a feature request for what you want to do.",
)
public annotation class AxiInternal
