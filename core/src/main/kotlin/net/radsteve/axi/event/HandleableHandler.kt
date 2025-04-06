// THIS FILE IS AUTO-GENERATED! DO NOT MODIFY!
// spotless:off
@file:Suppress("SpellCheckingInspection", "unused")

package net.radsteve.axi.event

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import org.bukkit.event.EventHandler

/** Event handler implementation for [Handleable]s. */
public class HandleableHandler(
  /** Supplier for all handleables that should be called. */
  private val handleableSupplier: suspend () -> Iterable<Handleable>,
) : SuspendingListener {
  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.block.AnvilDamagedEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.block.AnvilDamagedEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.block.BeaconEffectEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.block.BeaconEffectEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.block.BlockDestroyEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.block.BlockDestroyEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.brigadier.AsyncPlayerSendSuggestionsEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.brigadier.AsyncPlayerSendSuggestionsEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.CreeperIgniteEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.CreeperIgniteEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EnderDragonFireballHitEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EnderDragonFireballHitEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EnderDragonFlameEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EnderDragonFlameEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EnderDragonShootFireballEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EnderDragonShootFireballEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EndermanAttackPlayerEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EndermanAttackPlayerEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EndermanEscapeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EndermanEscapeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityAddToWorldEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityAddToWorldEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityJumpEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityJumpEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityPathfindEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityPathfindEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityZapEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityZapEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.ExperienceOrbMergeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.ExperienceOrbMergeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.PhantomPreSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.PhantomPreSpawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.PlayerNaturallySpawnCreaturesEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.PlayerNaturallySpawnCreaturesEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.PreCreatureSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.PreCreatureSpawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.PreSpawnerSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.PreSpawnerSpawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SkeletonHorseTrapEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SkeletonHorseTrapEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeChangeDirectionEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SlimeChangeDirectionEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SlimePathfindEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SlimePathfindEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeSwimEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SlimeSwimEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeTargetLivingEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SlimeTargetLivingEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeWanderEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SlimeWanderEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.ThrownEggHatchEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.ThrownEggHatchEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.TurtleGoHomeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.TurtleGoHomeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.TurtleLayEggEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.TurtleLayEggEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.TurtleStartDiggingEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.TurtleStartDiggingEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.WitchConsumePotionEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.WitchConsumePotionEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.WitchReadyPotionEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.WitchReadyPotionEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.WitchThrowPotionEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.WitchThrowPotionEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.inventory.PrepareResultEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.inventory.PrepareResultEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerArmorChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerArmorChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerAttackEntityCooldownResetEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerAttackEntityCooldownResetEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerClientOptionsChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerClientOptionsChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerConnectionCloseEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerConnectionCloseEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerElytraBoostEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerElytraBoostEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerHandshakeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerHandshakeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerJumpEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerJumpEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerPostRespawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerPostRespawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerReadyArrowEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerReadyArrowEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerRecipeBookClickEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerRecipeBookClickEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerSetSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerSetSpawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerStartSpectatingEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerStartSpectatingEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerStopSpectatingEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerStopSpectatingEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerUseUnknownEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerUseUnknownEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.profile.FillProfileEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.profile.FillProfileEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.profile.LookupProfileEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.profile.LookupProfileEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.profile.PreFillProfileEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.profile.PreFillProfileEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.profile.PreLookupProfileEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.profile.PreLookupProfileEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.profile.ProfileWhitelistVerifyEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.profile.ProfileWhitelistVerifyEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.server.AsyncTabCompleteEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.server.AsyncTabCompleteEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.server.GS4QueryEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.server.GS4QueryEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.server.PaperServerListPingEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.server.PaperServerListPingEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.server.ServerExceptionEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.server.ServerExceptionEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.server.WhitelistToggleEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.event.server.WhitelistToggleEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.loottable.LootableInventoryReplenishEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(com.destroystokyo.paper.loottable.LootableInventoryReplenishEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BeaconActivatedEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.block.BeaconActivatedEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BeaconDeactivatedEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.block.BeaconDeactivatedEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BlockBreakBlockEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.block.BlockBreakBlockEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BlockBreakProgressUpdateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.block.BlockBreakProgressUpdateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BlockFailedDispenseEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.block.BlockFailedDispenseEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BlockLockCheckEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.block.BlockLockCheckEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BlockPreDispenseEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.block.BlockPreDispenseEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.CompostItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.block.CompostItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.DragonEggFormEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.block.DragonEggFormEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.PlayerShearBlockEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.block.PlayerShearBlockEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.TargetHitEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.block.TargetHitEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.ElderGuardianAppearanceEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.ElderGuardianAppearanceEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityAttemptSmashAttackEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityAttemptSmashAttackEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityCompostItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityCompostItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityDamageItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityDamageItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityDyeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityDyeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityEquipmentChangedEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityEquipmentChangedEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityFertilizeEggEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityFertilizeEggEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityInsideBlockEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityInsideBlockEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityKnockbackEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityKnockbackEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityLoadCrossbowEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityLoadCrossbowEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityMoveEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityMoveEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityPortalReadyEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityPortalReadyEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityPushedByEntityAttackEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityPushedByEntityAttackEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityToggleSitEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityToggleSitEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.PufferFishStateChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.PufferFishStateChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.ShulkerDuplicateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.ShulkerDuplicateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.TameableDeathMessageEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.TameableDeathMessageEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.WardenAngerChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.WardenAngerChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.WaterBottleSplashEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.entity.WaterBottleSplashEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.packet.PlayerChunkLoadEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.packet.PlayerChunkLoadEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.packet.PlayerChunkUnloadEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.packet.PlayerChunkUnloadEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.AsyncChatCommandDecorateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.AsyncChatCommandDecorateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.AsyncChatDecorateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.AsyncChatDecorateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.AsyncChatEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.AsyncChatEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.CartographyItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.CartographyItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerArmSwingEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerArmSwingEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerBedFailEnterEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerBedFailEnterEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerChangeBeaconEffectEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerChangeBeaconEffectEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerClientLoadedWorldEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerClientLoadedWorldEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerDeepSleepEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerDeepSleepEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerFailMoveEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerFailMoveEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerFlowerPotManipulateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerFlowerPotManipulateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerInsertLecternBookEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerInsertLecternBookEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerInventorySlotChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerInventorySlotChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerItemCooldownEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerItemCooldownEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerItemFrameChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerItemFrameChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerItemGroupCooldownEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerItemGroupCooldownEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerLecternPageChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerLecternPageChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerLoomPatternSelectEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerLoomPatternSelectEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerNameEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerNameEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerOpenSignEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerOpenSignEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerPickItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerPickItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerPurchaseEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerPurchaseEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerShieldDisableEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerShieldDisableEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerSignCommandPreprocessEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerSignCommandPreprocessEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerStonecutterRecipeSelectEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerStonecutterRecipeSelectEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerStopUsingItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerStopUsingItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerTrackEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerTrackEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerTradeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerTradeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerUntrackEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerUntrackEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PrePlayerAttackEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.player.PrePlayerAttackEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.server.ServerResourcesReloadedEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.server.ServerResourcesReloadedEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.server.WhitelistStateUpdateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.server.WhitelistStateUpdateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.world.StructuresLocateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.world.StructuresLocateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.world.WorldGameRuleChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.world.WorldGameRuleChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.world.border.WorldBorderBoundsChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.world.border.WorldBorderBoundsChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.world.border.WorldBorderBoundsChangeFinishEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.world.border.WorldBorderBoundsChangeFinishEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.world.border.WorldBorderCenterChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(io.papermc.paper.event.world.border.WorldBorderCenterChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BellResonateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BellResonateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BellRingEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BellRingEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockBreakEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockBreakEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockBurnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockBurnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockCanBuildEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockCanBuildEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockCookEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockCookEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDamageAbortEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockDamageAbortEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDamageEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockDamageEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDispenseArmorEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockDispenseArmorEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDispenseEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockDispenseEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDispenseLootEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockDispenseLootEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDropItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockDropItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockExpEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockExpEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockExplodeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockExplodeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockFadeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockFadeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockFertilizeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockFertilizeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockFormEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockFormEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockFromToEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockFromToEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockGrowEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockGrowEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockIgniteEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockIgniteEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockMultiPlaceEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockMultiPlaceEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockPhysicsEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockPhysicsEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockPistonExtendEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockPistonExtendEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockPistonRetractEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockPistonRetractEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockPlaceEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockPlaceEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockReceiveGameEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockReceiveGameEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockRedstoneEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockRedstoneEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockShearEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockShearEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockSpreadEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BlockSpreadEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BrewingStartEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.BrewingStartEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.CampfireStartEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.CampfireStartEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.CauldronLevelChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.CauldronLevelChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.CrafterCraftEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.CrafterCraftEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.EntityBlockFormEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.EntityBlockFormEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.FluidLevelChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.FluidLevelChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.InventoryBlockStartEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.InventoryBlockStartEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.LeavesDecayEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.LeavesDecayEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.MoistureChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.MoistureChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.NotePlayEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.NotePlayEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.SculkBloomEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.SculkBloomEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.SignChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.SignChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.SpongeAbsorbEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.SpongeAbsorbEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.TNTPrimeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.TNTPrimeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.VaultDisplayItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.block.VaultDisplayItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.command.UnknownCommandEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.command.UnknownCommandEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.enchantment.EnchantItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.enchantment.EnchantItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.enchantment.PrepareItemEnchantEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.enchantment.PrepareItemEnchantEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.AreaEffectCloudApplyEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.AreaEffectCloudApplyEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ArrowBodyCountChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.ArrowBodyCountChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.BatToggleSleepEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.BatToggleSleepEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.CreatureSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.CreatureSpawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.CreeperPowerEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.CreeperPowerEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EnderDragonChangePhaseEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EnderDragonChangePhaseEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityAirChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityAirChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityBreakDoorEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityBreakDoorEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityBreedEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityBreedEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityChangeBlockEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityChangeBlockEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityCombustByBlockEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityCombustByBlockEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityCombustByEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityCombustByEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityCombustEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityCombustEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDamageByBlockEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityDamageByBlockEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDamageByEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityDamageByEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDamageEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityDamageEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDeathEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityDeathEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDismountEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityDismountEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDropItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityDropItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityEnterBlockEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityEnterBlockEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityEnterLoveModeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityEnterLoveModeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityExhaustionEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityExhaustionEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityExplodeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityExplodeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityInteractEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityInteractEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityMountEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityMountEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPickupItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityPickupItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPlaceEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityPlaceEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPortalEnterEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityPortalEnterEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPortalEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityPortalEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPortalExitEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityPortalExitEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPoseChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityPoseChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPotionEffectEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityPotionEffectEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityRegainHealthEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityRegainHealthEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityRemoveEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityRemoveEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityResurrectEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityResurrectEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityShootBowEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityShootBowEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntitySpawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntitySpawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntitySpellCastEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntitySpellCastEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityTameEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityTameEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityTargetEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityTargetEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityTargetLivingEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityTargetLivingEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityTeleportEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityTeleportEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityToggleGlideEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityToggleGlideEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityToggleSwimEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityToggleSwimEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityTransformEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityTransformEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityUnleashEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.EntityUnleashEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ExpBottleEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.ExpBottleEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ExplosionPrimeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.ExplosionPrimeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.FireworkExplodeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.FireworkExplodeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.FoodLevelChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.FoodLevelChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.HorseJumpEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.HorseJumpEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ItemDespawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.ItemDespawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ItemMergeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.ItemMergeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ItemSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.ItemSpawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.LingeringPotionSplashEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.LingeringPotionSplashEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PigZapEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.PigZapEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PigZombieAngerEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.PigZombieAngerEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PiglinBarterEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.PiglinBarterEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PlayerDeathEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.PlayerDeathEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PlayerLeashEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.PlayerLeashEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PotionSplashEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.PotionSplashEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ProjectileHitEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.ProjectileHitEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ProjectileLaunchEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.ProjectileLaunchEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.SheepDyeWoolEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.SheepDyeWoolEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.SheepRegrowWoolEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.SheepRegrowWoolEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.SlimeSplitEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.SlimeSplitEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.SpawnerSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.SpawnerSpawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.StriderTemperatureChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.StriderTemperatureChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.TrialSpawnerSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.TrialSpawnerSpawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.VillagerAcquireTradeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.VillagerAcquireTradeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.VillagerCareerChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.VillagerCareerChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.VillagerReplenishTradeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.entity.VillagerReplenishTradeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.hanging.HangingBreakByEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.hanging.HangingBreakByEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.hanging.HangingBreakEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.hanging.HangingBreakEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.hanging.HangingPlaceEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.hanging.HangingPlaceEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.BrewEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.BrewEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.BrewingStandFuelEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.BrewingStandFuelEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.CraftItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.CraftItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.FurnaceBurnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.FurnaceBurnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.FurnaceExtractEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.FurnaceExtractEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.FurnaceSmeltEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.FurnaceSmeltEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.FurnaceStartSmeltEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.FurnaceStartSmeltEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.HopperInventorySearchEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.HopperInventorySearchEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryClickEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryClickEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryCloseEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryCloseEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryCreativeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryCreativeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryDragEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryDragEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryMoveItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryMoveItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryOpenEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryOpenEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryPickupItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryPickupItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.PrepareAnvilEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.PrepareAnvilEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.PrepareGrindstoneEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.PrepareGrindstoneEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.PrepareItemCraftEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.PrepareItemCraftEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.PrepareSmithingEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.PrepareSmithingEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.SmithItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.SmithItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.TradeSelectEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.inventory.TradeSelectEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.AsyncPlayerPreLoginEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.AsyncPlayerPreLoginEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerAdvancementDoneEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerAdvancementDoneEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerAnimationEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerAnimationEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerArmorStandManipulateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerArmorStandManipulateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerAttemptPickupItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerAttemptPickupItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerBedEnterEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerBedEnterEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerBedLeaveEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerBedLeaveEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerBucketEmptyEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerBucketEmptyEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerBucketEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerBucketEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerBucketFillEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerBucketFillEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerChangedMainHandEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerChangedMainHandEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerChangedWorldEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerChangedWorldEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerCommandPreprocessEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerCommandPreprocessEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerCommandSendEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerCommandSendEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerDropItemEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerDropItemEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerEditBookEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerEditBookEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerEggThrowEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerEggThrowEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerExpChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerExpChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerExpCooldownChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerExpCooldownChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerFishEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerFishEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerGameModeChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerGameModeChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerHarvestBlockEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerHarvestBlockEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerHideEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerHideEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerInputEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerInputEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerInteractAtEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerInteractAtEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerInteractEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerInteractEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerInteractEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerInteractEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerItemBreakEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerItemBreakEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerItemConsumeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerItemConsumeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerItemDamageEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerItemDamageEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerItemHeldEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerItemHeldEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerItemMendEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerItemMendEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerJoinEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerJoinEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerKickEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerKickEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerLevelChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerLevelChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerLinksSendEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerLinksSendEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerLocaleChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerLocaleChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerLoginEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerLoginEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerMoveEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerMoveEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerPickupArrowEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerPickupArrowEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerPortalEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerPortalEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerQuitEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerQuitEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerRecipeDiscoverEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerRecipeDiscoverEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerRegisterChannelEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerRegisterChannelEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerResourcePackStatusEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerResourcePackStatusEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerRespawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerRespawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerRiptideEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerRiptideEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerShearEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerShearEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerShowEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerShowEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerStatisticIncrementEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerStatisticIncrementEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerSwapHandItemsEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerSwapHandItemsEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerTakeLecternBookEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerTakeLecternBookEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerTeleportEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerTeleportEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerToggleFlightEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerToggleFlightEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerToggleSneakEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerToggleSneakEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerToggleSprintEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerToggleSprintEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerUnleashEntityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerUnleashEntityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerUnregisterChannelEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerUnregisterChannelEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerVelocityEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.player.PlayerVelocityEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.raid.RaidFinishEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.raid.RaidFinishEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.raid.RaidSpawnWaveEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.raid.RaidSpawnWaveEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.raid.RaidStopEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.raid.RaidStopEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.raid.RaidTriggerEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.raid.RaidTriggerEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.BroadcastMessageEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.server.BroadcastMessageEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.MapInitializeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.server.MapInitializeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.PluginDisableEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.server.PluginDisableEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.PluginEnableEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.server.PluginEnableEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.RemoteServerCommandEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.server.RemoteServerCommandEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.ServerCommandEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.server.ServerCommandEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.ServerListPingEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.server.ServerListPingEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.ServerLoadEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.server.ServerLoadEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.ServiceRegisterEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.server.ServiceRegisterEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.ServiceUnregisterEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.server.ServiceUnregisterEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.TabCompleteEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.server.TabCompleteEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleBlockCollisionEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleBlockCollisionEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleCreateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleCreateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleDamageEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleDamageEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleDestroyEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleDestroyEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleEnterEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleEnterEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleEntityCollisionEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleEntityCollisionEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleExitEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleExitEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleMoveEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleMoveEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleUpdateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleUpdateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.weather.LightningStrikeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.weather.LightningStrikeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.weather.ThunderChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.weather.ThunderChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.weather.WeatherChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.weather.WeatherChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.AsyncStructureGenerateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.AsyncStructureGenerateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.AsyncStructureSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.AsyncStructureSpawnEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.ChunkLoadEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.ChunkLoadEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.ChunkPopulateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.ChunkPopulateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.ChunkUnloadEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.ChunkUnloadEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.EntitiesLoadEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.EntitiesLoadEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.EntitiesUnloadEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.EntitiesUnloadEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.GenericGameEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.GenericGameEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.LootGenerateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.LootGenerateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.PortalCreateEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.PortalCreateEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.SpawnChangeEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.SpawnChangeEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.StructureGrowEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.StructureGrowEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.TimeSkipEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.TimeSkipEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.WorldInitEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.WorldInitEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.WorldLoadEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.WorldLoadEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.WorldSaveEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.WorldSaveEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.WorldUnloadEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.bukkit.event.world.WorldUnloadEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.spigotmc.event.player.PlayerSpawnLocationEvent) {
    handleableSupplier().forEach { handleable ->
      handleable.coroutineScope.launch(context = CurrentlyCalledEvent(org.spigotmc.event.player.PlayerSpawnLocationEvent::class), start = CoroutineStart.UNDISPATCHED) {
        handleable.on(event)
      }
    }
  }
}
