// THIS FILE IS AUTO-GENERATED! DO NOT MODIFY!
// spotless:off
@file:Suppress("SpellCheckingInspection", "unused")

package net.radsteve.axi.event

import kotlinx.coroutines.withContext
import org.bukkit.event.EventHandler

/** Event handler implementation for [Handleable]s. */
public class HandleableHandler(
  /** Supplier for all handleables that should be called. */
  private val handleableSupplier: suspend () -> Iterable<Handleable>,
) : SuspendingListener {
  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.block.AnvilDamagedEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.block.AnvilDamagedEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.block.BeaconEffectEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.block.BeaconEffectEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.block.BlockDestroyEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.block.BlockDestroyEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.brigadier.AsyncPlayerSendSuggestionsEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.brigadier.AsyncPlayerSendSuggestionsEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.CreeperIgniteEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.CreeperIgniteEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EnderDragonFireballHitEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EnderDragonFireballHitEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EnderDragonFlameEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EnderDragonFlameEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EnderDragonShootFireballEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EnderDragonShootFireballEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EndermanAttackPlayerEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EndermanAttackPlayerEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EndermanEscapeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EndermanEscapeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityAddToWorldEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityAddToWorldEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityJumpEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityJumpEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityPathfindEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityPathfindEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.EntityZapEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.EntityZapEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.ExperienceOrbMergeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.ExperienceOrbMergeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.PhantomPreSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.PhantomPreSpawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.PlayerNaturallySpawnCreaturesEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.PlayerNaturallySpawnCreaturesEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.PreCreatureSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.PreCreatureSpawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.PreSpawnerSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.PreSpawnerSpawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SkeletonHorseTrapEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SkeletonHorseTrapEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeChangeDirectionEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SlimeChangeDirectionEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SlimePathfindEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SlimePathfindEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeSwimEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SlimeSwimEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeTargetLivingEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SlimeTargetLivingEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeWanderEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.SlimeWanderEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.ThrownEggHatchEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.ThrownEggHatchEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.TurtleGoHomeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.TurtleGoHomeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.TurtleLayEggEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.TurtleLayEggEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.TurtleStartDiggingEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.TurtleStartDiggingEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.WitchConsumePotionEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.WitchConsumePotionEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.WitchReadyPotionEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.WitchReadyPotionEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.entity.WitchThrowPotionEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.entity.WitchThrowPotionEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.inventory.PrepareResultEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.inventory.PrepareResultEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerArmorChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerArmorChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerAttackEntityCooldownResetEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerAttackEntityCooldownResetEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerClientOptionsChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerClientOptionsChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerConnectionCloseEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerConnectionCloseEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerElytraBoostEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerElytraBoostEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerHandshakeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerHandshakeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerJumpEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerJumpEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerPostRespawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerPostRespawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerReadyArrowEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerReadyArrowEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerRecipeBookClickEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerRecipeBookClickEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerSetSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerSetSpawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerStartSpectatingEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerStartSpectatingEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerStopSpectatingEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerStopSpectatingEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.player.PlayerUseUnknownEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.player.PlayerUseUnknownEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.profile.FillProfileEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.profile.FillProfileEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.profile.LookupProfileEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.profile.LookupProfileEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.profile.PreFillProfileEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.profile.PreFillProfileEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.profile.PreLookupProfileEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.profile.PreLookupProfileEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.profile.ProfileWhitelistVerifyEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.profile.ProfileWhitelistVerifyEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.server.AsyncTabCompleteEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.server.AsyncTabCompleteEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.server.GS4QueryEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.server.GS4QueryEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.server.PaperServerListPingEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.server.PaperServerListPingEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.server.ServerExceptionEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.server.ServerExceptionEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.event.server.WhitelistToggleEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.event.server.WhitelistToggleEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: com.destroystokyo.paper.loottable.LootableInventoryReplenishEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(com.destroystokyo.paper.loottable.LootableInventoryReplenishEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BeaconActivatedEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.block.BeaconActivatedEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BeaconDeactivatedEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.block.BeaconDeactivatedEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BlockBreakBlockEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.block.BlockBreakBlockEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BlockBreakProgressUpdateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.block.BlockBreakProgressUpdateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BlockFailedDispenseEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.block.BlockFailedDispenseEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BlockLockCheckEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.block.BlockLockCheckEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.BlockPreDispenseEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.block.BlockPreDispenseEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.CompostItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.block.CompostItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.DragonEggFormEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.block.DragonEggFormEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.PlayerShearBlockEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.block.PlayerShearBlockEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.block.TargetHitEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.block.TargetHitEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.ElderGuardianAppearanceEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.ElderGuardianAppearanceEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityAttemptSmashAttackEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityAttemptSmashAttackEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityCompostItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityCompostItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityDamageItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityDamageItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityDyeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityDyeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityEquipmentChangedEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityEquipmentChangedEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityFertilizeEggEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityFertilizeEggEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityInsideBlockEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityInsideBlockEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityKnockbackEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityKnockbackEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityLoadCrossbowEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityLoadCrossbowEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityMoveEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityMoveEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityPortalReadyEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityPortalReadyEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityPushedByEntityAttackEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityPushedByEntityAttackEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.EntityToggleSitEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.EntityToggleSitEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.PufferFishStateChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.PufferFishStateChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.ShulkerDuplicateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.ShulkerDuplicateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.TameableDeathMessageEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.TameableDeathMessageEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.WardenAngerChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.WardenAngerChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.entity.WaterBottleSplashEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.entity.WaterBottleSplashEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.packet.PlayerChunkLoadEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.packet.PlayerChunkLoadEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.packet.PlayerChunkUnloadEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.packet.PlayerChunkUnloadEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.AsyncChatCommandDecorateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.AsyncChatCommandDecorateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.AsyncChatDecorateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.AsyncChatDecorateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.AsyncChatEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.AsyncChatEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.CartographyItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.CartographyItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerArmSwingEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerArmSwingEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerBedFailEnterEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerBedFailEnterEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerChangeBeaconEffectEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerChangeBeaconEffectEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerClientLoadedWorldEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerClientLoadedWorldEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerDeepSleepEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerDeepSleepEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerFailMoveEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerFailMoveEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerFlowerPotManipulateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerFlowerPotManipulateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerInsertLecternBookEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerInsertLecternBookEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerInventorySlotChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerInventorySlotChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerItemCooldownEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerItemCooldownEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerItemFrameChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerItemFrameChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerItemGroupCooldownEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerItemGroupCooldownEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerLecternPageChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerLecternPageChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerLoomPatternSelectEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerLoomPatternSelectEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerNameEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerNameEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerOpenSignEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerOpenSignEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerPickItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerPickItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerPurchaseEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerPurchaseEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerShieldDisableEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerShieldDisableEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerSignCommandPreprocessEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerSignCommandPreprocessEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerStonecutterRecipeSelectEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerStonecutterRecipeSelectEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerStopUsingItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerStopUsingItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerTrackEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerTrackEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerTradeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerTradeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PlayerUntrackEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PlayerUntrackEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.player.PrePlayerAttackEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.player.PrePlayerAttackEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.server.ServerResourcesReloadedEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.server.ServerResourcesReloadedEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.server.WhitelistStateUpdateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.server.WhitelistStateUpdateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.world.StructuresLocateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.world.StructuresLocateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.world.WorldGameRuleChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.world.WorldGameRuleChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.world.border.WorldBorderBoundsChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.world.border.WorldBorderBoundsChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.world.border.WorldBorderBoundsChangeFinishEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.world.border.WorldBorderBoundsChangeFinishEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: io.papermc.paper.event.world.border.WorldBorderCenterChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(io.papermc.paper.event.world.border.WorldBorderCenterChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BellResonateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BellResonateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BellRingEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BellRingEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockBreakEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockBreakEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockBurnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockBurnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockCanBuildEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockCanBuildEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockCookEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockCookEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDamageAbortEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockDamageAbortEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDamageEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockDamageEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDispenseArmorEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockDispenseArmorEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDispenseEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockDispenseEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDispenseLootEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockDispenseLootEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockDropItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockDropItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockExpEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockExpEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockExplodeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockExplodeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockFadeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockFadeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockFertilizeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockFertilizeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockFormEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockFormEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockFromToEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockFromToEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockGrowEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockGrowEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockIgniteEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockIgniteEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockMultiPlaceEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockMultiPlaceEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockPhysicsEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockPhysicsEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockPistonExtendEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockPistonExtendEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockPistonRetractEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockPistonRetractEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockPlaceEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockPlaceEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockReceiveGameEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockReceiveGameEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockRedstoneEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockRedstoneEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockShearEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockShearEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BlockSpreadEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BlockSpreadEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.BrewingStartEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.BrewingStartEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.CampfireStartEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.CampfireStartEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.CauldronLevelChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.CauldronLevelChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.CrafterCraftEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.CrafterCraftEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.EntityBlockFormEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.EntityBlockFormEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.FluidLevelChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.FluidLevelChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.InventoryBlockStartEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.InventoryBlockStartEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.LeavesDecayEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.LeavesDecayEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.MoistureChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.MoistureChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.NotePlayEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.NotePlayEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.SculkBloomEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.SculkBloomEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.SignChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.SignChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.SpongeAbsorbEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.SpongeAbsorbEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.TNTPrimeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.TNTPrimeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.block.VaultDisplayItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.block.VaultDisplayItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.command.UnknownCommandEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.command.UnknownCommandEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.enchantment.EnchantItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.enchantment.EnchantItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.enchantment.PrepareItemEnchantEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.enchantment.PrepareItemEnchantEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.AreaEffectCloudApplyEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.AreaEffectCloudApplyEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ArrowBodyCountChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.ArrowBodyCountChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.BatToggleSleepEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.BatToggleSleepEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.CreatureSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.CreatureSpawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.CreeperPowerEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.CreeperPowerEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EnderDragonChangePhaseEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EnderDragonChangePhaseEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityAirChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityAirChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityBreakDoorEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityBreakDoorEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityBreedEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityBreedEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityChangeBlockEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityChangeBlockEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityCombustByBlockEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityCombustByBlockEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityCombustByEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityCombustByEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityCombustEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityCombustEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDamageByBlockEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityDamageByBlockEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDamageByEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityDamageByEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDamageEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityDamageEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDeathEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityDeathEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDismountEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityDismountEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityDropItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityDropItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityEnterBlockEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityEnterBlockEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityEnterLoveModeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityEnterLoveModeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityExhaustionEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityExhaustionEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityExplodeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityExplodeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityInteractEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityInteractEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityMountEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityMountEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPickupItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityPickupItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPlaceEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityPlaceEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPortalEnterEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityPortalEnterEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPortalEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityPortalEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPortalExitEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityPortalExitEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPoseChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityPoseChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityPotionEffectEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityPotionEffectEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityRegainHealthEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityRegainHealthEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityRemoveEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityRemoveEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityResurrectEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityResurrectEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityShootBowEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityShootBowEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntitySpawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntitySpawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntitySpellCastEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntitySpellCastEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityTameEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityTameEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityTargetEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityTargetEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityTargetLivingEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityTargetLivingEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityTeleportEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityTeleportEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityToggleGlideEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityToggleGlideEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityToggleSwimEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityToggleSwimEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityTransformEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityTransformEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.EntityUnleashEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.EntityUnleashEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ExpBottleEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.ExpBottleEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ExplosionPrimeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.ExplosionPrimeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.FireworkExplodeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.FireworkExplodeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.FoodLevelChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.FoodLevelChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.HorseJumpEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.HorseJumpEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ItemDespawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.ItemDespawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ItemMergeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.ItemMergeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ItemSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.ItemSpawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.LingeringPotionSplashEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.LingeringPotionSplashEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PigZapEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.PigZapEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PigZombieAngerEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.PigZombieAngerEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PiglinBarterEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.PiglinBarterEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PlayerDeathEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.PlayerDeathEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PlayerLeashEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.PlayerLeashEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.PotionSplashEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.PotionSplashEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ProjectileHitEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.ProjectileHitEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.ProjectileLaunchEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.ProjectileLaunchEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.SheepDyeWoolEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.SheepDyeWoolEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.SheepRegrowWoolEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.SheepRegrowWoolEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.SlimeSplitEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.SlimeSplitEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.SpawnerSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.SpawnerSpawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.StriderTemperatureChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.StriderTemperatureChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.TrialSpawnerSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.TrialSpawnerSpawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.VillagerAcquireTradeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.VillagerAcquireTradeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.VillagerCareerChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.VillagerCareerChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.entity.VillagerReplenishTradeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.entity.VillagerReplenishTradeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.hanging.HangingBreakByEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.hanging.HangingBreakByEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.hanging.HangingBreakEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.hanging.HangingBreakEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.hanging.HangingPlaceEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.hanging.HangingPlaceEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.BrewEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.BrewEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.BrewingStandFuelEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.BrewingStandFuelEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.CraftItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.CraftItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.FurnaceBurnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.FurnaceBurnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.FurnaceExtractEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.FurnaceExtractEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.FurnaceSmeltEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.FurnaceSmeltEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.FurnaceStartSmeltEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.FurnaceStartSmeltEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.HopperInventorySearchEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.HopperInventorySearchEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryClickEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryClickEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryCloseEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryCloseEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryCreativeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryCreativeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryDragEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryDragEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryMoveItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryMoveItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryOpenEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryOpenEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.InventoryPickupItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.InventoryPickupItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.PrepareAnvilEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.PrepareAnvilEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.PrepareGrindstoneEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.PrepareGrindstoneEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.PrepareItemCraftEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.PrepareItemCraftEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.PrepareSmithingEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.PrepareSmithingEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.SmithItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.SmithItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.inventory.TradeSelectEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.inventory.TradeSelectEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.AsyncPlayerPreLoginEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.AsyncPlayerPreLoginEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerAdvancementDoneEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerAdvancementDoneEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerAnimationEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerAnimationEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerArmorStandManipulateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerArmorStandManipulateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerAttemptPickupItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerAttemptPickupItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerBedEnterEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerBedEnterEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerBedLeaveEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerBedLeaveEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerBucketEmptyEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerBucketEmptyEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerBucketEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerBucketEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerBucketFillEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerBucketFillEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerChangedMainHandEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerChangedMainHandEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerChangedWorldEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerChangedWorldEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerCommandPreprocessEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerCommandPreprocessEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerCommandSendEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerCommandSendEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerDropItemEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerDropItemEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerEditBookEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerEditBookEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerEggThrowEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerEggThrowEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerExpChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerExpChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerExpCooldownChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerExpCooldownChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerFishEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerFishEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerGameModeChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerGameModeChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerHarvestBlockEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerHarvestBlockEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerHideEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerHideEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerInputEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerInputEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerInteractAtEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerInteractAtEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerInteractEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerInteractEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerInteractEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerInteractEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerItemBreakEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerItemBreakEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerItemConsumeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerItemConsumeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerItemDamageEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerItemDamageEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerItemHeldEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerItemHeldEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerItemMendEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerItemMendEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerJoinEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerJoinEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerKickEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerKickEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerLevelChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerLevelChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerLinksSendEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerLinksSendEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerLocaleChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerLocaleChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerLoginEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerLoginEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerMoveEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerMoveEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerPickupArrowEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerPickupArrowEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerPortalEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerPortalEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerQuitEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerQuitEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerRecipeDiscoverEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerRecipeDiscoverEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerRegisterChannelEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerRegisterChannelEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerResourcePackStatusEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerResourcePackStatusEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerRespawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerRespawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerRiptideEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerRiptideEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerShearEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerShearEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerShowEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerShowEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerStatisticIncrementEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerStatisticIncrementEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerSwapHandItemsEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerSwapHandItemsEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerTakeLecternBookEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerTakeLecternBookEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerTeleportEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerTeleportEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerToggleFlightEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerToggleFlightEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerToggleSneakEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerToggleSneakEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerToggleSprintEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerToggleSprintEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerUnleashEntityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerUnleashEntityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerUnregisterChannelEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerUnregisterChannelEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.player.PlayerVelocityEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.player.PlayerVelocityEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.raid.RaidFinishEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.raid.RaidFinishEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.raid.RaidSpawnWaveEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.raid.RaidSpawnWaveEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.raid.RaidStopEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.raid.RaidStopEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.raid.RaidTriggerEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.raid.RaidTriggerEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.BroadcastMessageEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.server.BroadcastMessageEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.MapInitializeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.server.MapInitializeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.PluginDisableEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.server.PluginDisableEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.PluginEnableEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.server.PluginEnableEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.RemoteServerCommandEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.server.RemoteServerCommandEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.ServerCommandEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.server.ServerCommandEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.ServerListPingEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.server.ServerListPingEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.ServerLoadEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.server.ServerLoadEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.ServiceRegisterEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.server.ServiceRegisterEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.ServiceUnregisterEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.server.ServiceUnregisterEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.server.TabCompleteEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.server.TabCompleteEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleBlockCollisionEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleBlockCollisionEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleCreateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleCreateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleDamageEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleDamageEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleDestroyEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleDestroyEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleEnterEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleEnterEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleEntityCollisionEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleEntityCollisionEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleExitEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleExitEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleMoveEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleMoveEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.vehicle.VehicleUpdateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.vehicle.VehicleUpdateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.weather.LightningStrikeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.weather.LightningStrikeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.weather.ThunderChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.weather.ThunderChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.weather.WeatherChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.weather.WeatherChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.AsyncStructureGenerateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.AsyncStructureGenerateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.AsyncStructureSpawnEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.AsyncStructureSpawnEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.ChunkLoadEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.ChunkLoadEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.ChunkPopulateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.ChunkPopulateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.ChunkUnloadEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.ChunkUnloadEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.EntitiesLoadEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.EntitiesLoadEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.EntitiesUnloadEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.EntitiesUnloadEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.GenericGameEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.GenericGameEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.LootGenerateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.LootGenerateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.PortalCreateEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.PortalCreateEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.SpawnChangeEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.SpawnChangeEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.StructureGrowEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.StructureGrowEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.TimeSkipEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.TimeSkipEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.WorldInitEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.WorldInitEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.WorldLoadEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.WorldLoadEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.WorldSaveEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.WorldSaveEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.bukkit.event.world.WorldUnloadEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.bukkit.event.world.WorldUnloadEvent::class)) {
        handleable.on(event)
      }
    }
  }

  @EventHandler
  private suspend fun on(event: org.spigotmc.event.player.PlayerSpawnLocationEvent) {
    handleableSupplier().forEach { handleable ->
      withContext(handleable.coroutineContext + CurrentlyCalledEvent(org.spigotmc.event.player.PlayerSpawnLocationEvent::class)) {
        handleable.on(event)
      }
    }
  }
}
