package net.radsteve.axi.example.game.bedwars

import net.radsteve.axi.example.game.bedwars.phase.FightingPhase
import net.radsteve.axi.example.game.bedwars.phase.FinalPhase
import net.radsteve.axi.example.game.bedwars.phase.WaitingPhase
import net.radsteve.axi.game.instance.GameContext
import net.radsteve.axi.game.instance.GameInstance
import net.radsteve.axi.game.phase.GameSchedule
import net.radsteve.axi.game.phase.GameSchedule.Companion.buildSchedule
import net.radsteve.axi.game.world.GameWorld
import net.radsteve.axi.game.world.GameWorldProvider
import net.radsteve.axi.utility.resource
import kotlin.time.Duration.Companion.seconds

public class BedWarsInstance(
  context: GameContext<BedWarsInstance>,
) : GameInstance<BedWarsInstance>(context) {
  override val schedule: GameSchedule<BedWarsInstance> = buildSchedule {
    add(10.seconds, ::WaitingPhase)
    add(null, ::FightingPhase)
    add(10.seconds, ::FinalPhase)
  }

  public override suspend fun gameWorld(instance: GameInstance<*>): GameWorld {
    return delegateWorldProvider(GameWorldProvider.clipboard(resource("bedwars_map.nbt")))
  }
}
