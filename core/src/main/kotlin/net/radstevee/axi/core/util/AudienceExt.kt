package net.radstevee.axi.core.util

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.identity.Identity
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

/** Gets the UUID of this audience, or null. */
public fun Audience.uuidOrNull(): UUID? = get(Identity.UUID).getOrNull()

/** Gets the UUID of this audience, or throws. */
public fun Audience.uuid(): UUID = uuidOrNull() ?: error("audience does not have a UUID")
