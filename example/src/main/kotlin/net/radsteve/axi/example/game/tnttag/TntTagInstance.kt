package net.radsteve.axi.example.game.tnttag

import net.radsteve.axi.ecs.data
import net.radsteve.axi.example.game.tnttag.phase.TaggingPhase
import net.radsteve.axi.example.game.tnttag.phase.FinalPhase
import net.radsteve.axi.example.game.tnttag.phase.WaitingPhase
import net.radsteve.axi.game.instance.GameContext
import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.game.phase.GameSchedule
import net.radsteve.axi.game.phase.GameSchedule.Companion.buildSchedule
import net.radsteve.axi.game.world.GameWorld
import net.radsteve.axi.game.world.GameWorldProvider
import net.radsteve.axi.utility.resource
import net.radsteve.axi.utility.uuids
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent
import java.util.UUID
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

public class TntTagInstance(
  context: GameContext<TntTagInstance>,
) : GameInstance<TntTagInstance>(context) {
  private var currentTagger: UUID? by data()

  public fun resetTagger() {
    currentTagger = null
  }

  public fun newTagger(uuid: UUID) {
    currentTagger = uuid
  }

  public fun currentTagger(): UUID {
    return currentTagger ?: rerollTagger()
  }

  public fun currentTaggerOrNull(): UUID? {
    return currentTagger
  }

  public fun isTagger(uuid: UUID): Boolean {
    return currentTagger() == uuid
  }

  public fun isTagger(player: Player): Boolean {
    return isTagger(player.uniqueId)
  }

  public fun rerollTagger(): UUID {
    val members = uuids
    val candidates = currentTagger?.let(members::minus) ?: members
    val elected = candidates.randomOrNull() ?: currentTagger ?: exit("not enough players")
    currentTagger = elected

    return elected
  }

  override val schedule: GameSchedule<TntTagInstance> = buildSchedule {
    add(10.seconds, ::WaitingPhase)
    add(1.minutes, ::TaggingPhase)
    add(10.seconds, ::FinalPhase)
  }

  override suspend fun spawnFor(player: Player): Location {
    return Location(world.world, -49.5, -6.0, -52.5)
  }

  public override suspend fun gameWorld(instance: GameInstance<*>): GameWorld {
    return delegateWorldProvider(GameWorldProvider.clipboard(resource("tnt-tag.schem")))
  }

  override suspend fun on(event: EntityDamageEvent) {
    event.isCancelled = true
  }
}
