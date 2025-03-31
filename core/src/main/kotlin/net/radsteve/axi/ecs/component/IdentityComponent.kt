package net.radsteve.axi.ecs.component

import net.radsteve.axi.ecs.Attachable
import net.radsteve.axi.ecs.get
import java.util.UUID

/** Represents the identity of something, as UUID. */
public data class IdentityComponent(
  /** The identity. */
  public val identity: UUID,
)

/** The identity of this attachable. */
public val Attachable.identity: UUID? get() = get<IdentityComponent>()?.identity
