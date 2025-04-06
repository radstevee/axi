package net.radsteve.axi.example.game.tnttag

import net.radsteve.axi.example.game.tnttag.phase.FightingPhase
import net.radsteve.axi.example.game.tnttag.phase.FinalPhase
import net.radsteve.axi.example.game.tnttag.phase.WaitingPhase
import net.radsteve.axi.game.instance.GameContext
import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.game.phase.GameSchedule
import net.radsteve.axi.game.phase.GameSchedule.Companion.buildSchedule
import net.radsteve.axi.game.world.GameWorld
import net.radsteve.axi.game.world.GameWorldProvider
import net.radsteve.axi.utility.resource
import org.bukkit.Location
import org.bukkit.entity.Player
import kotlin.time.Duration.Companion.seconds

public class TntTagInstance(
  context: GameContext<TntTagInstance>,
) : GameInstance<TntTagInstance>(context) {
  override val schedule: GameSchedule<TntTagInstance> = buildSchedule {
    add(10.seconds, ::WaitingPhase)
    add(null, ::FightingPhase)
    add(10.seconds, ::FinalPhase)
  }

  override suspend fun spawnFor(player: Player): Location {
    return Location(world.world, -49.5, -6.0, -52.5)
  }

  public override suspend fun gameWorld(instance: GameInstance<*>): GameWorld {
    return delegateWorldProvider(GameWorldProvider.clipboard(resource("tnt-tag.schem")))
  }
}
