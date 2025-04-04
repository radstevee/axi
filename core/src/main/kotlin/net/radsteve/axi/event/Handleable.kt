// THIS FILE IS AUTO-GENERATED! DO NOT MODIFY!
// spotless:off
@file:Suppress("SpellCheckingInspection")

package net.radsteve.axi.event

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/** Something that can handle events. */
public interface Handleable {
  /** The coroutine context for these events. */
  public val coroutineContext: CoroutineContext get() = EmptyCoroutineContext

  /** Called when a [com.destroystokyo.paper.event.block.AnvilDamagedEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.block.AnvilDamagedEvent) {}

  /** Called when a [com.destroystokyo.paper.event.block.BeaconEffectEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.block.BeaconEffectEvent) {}

  /** Called when a [com.destroystokyo.paper.event.block.BlockDestroyEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.block.BlockDestroyEvent) {}

  /** Called when a [com.destroystokyo.paper.event.brigadier.AsyncPlayerSendSuggestionsEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.brigadier.AsyncPlayerSendSuggestionsEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.CreeperIgniteEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.CreeperIgniteEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EnderDragonFireballHitEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EnderDragonFireballHitEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EnderDragonFlameEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EnderDragonFlameEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EnderDragonShootFireballEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EnderDragonShootFireballEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EndermanAttackPlayerEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EndermanAttackPlayerEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EndermanEscapeEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EndermanEscapeEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EntityAddToWorldEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EntityAddToWorldEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EntityJumpEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EntityJumpEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EntityPathfindEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EntityPathfindEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EntityTeleportEndGatewayEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.EntityZapEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.EntityZapEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.ExperienceOrbMergeEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.ExperienceOrbMergeEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.PhantomPreSpawnEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.PhantomPreSpawnEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.PlayerNaturallySpawnCreaturesEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.PlayerNaturallySpawnCreaturesEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.PreCreatureSpawnEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.PreCreatureSpawnEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.PreSpawnerSpawnEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.PreSpawnerSpawnEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.SkeletonHorseTrapEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.SkeletonHorseTrapEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.SlimeChangeDirectionEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeChangeDirectionEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.SlimePathfindEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.SlimePathfindEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.SlimeSwimEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeSwimEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.SlimeTargetLivingEntityEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeTargetLivingEntityEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.SlimeWanderEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.SlimeWanderEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.ThrownEggHatchEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.ThrownEggHatchEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.TurtleGoHomeEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.TurtleGoHomeEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.TurtleLayEggEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.TurtleLayEggEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.TurtleStartDiggingEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.TurtleStartDiggingEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.WitchConsumePotionEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.WitchConsumePotionEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.WitchReadyPotionEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.WitchReadyPotionEvent) {}

  /** Called when a [com.destroystokyo.paper.event.entity.WitchThrowPotionEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.entity.WitchThrowPotionEvent) {}

  /** Called when a [com.destroystokyo.paper.event.inventory.PrepareResultEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.inventory.PrepareResultEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerArmorChangeEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerArmorChangeEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerAttackEntityCooldownResetEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerAttackEntityCooldownResetEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerClientOptionsChangeEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerClientOptionsChangeEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerConnectionCloseEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerConnectionCloseEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerElytraBoostEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerElytraBoostEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerHandshakeEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerHandshakeEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerJumpEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerJumpEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerLaunchProjectileEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerPostRespawnEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerPostRespawnEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerReadyArrowEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerReadyArrowEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerRecipeBookClickEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerRecipeBookClickEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerSetSpawnEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerSetSpawnEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerStartSpectatingEntityEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerStartSpectatingEntityEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerStopSpectatingEntityEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerStopSpectatingEntityEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerTeleportEndGatewayEvent) {}

  /** Called when a [com.destroystokyo.paper.event.player.PlayerUseUnknownEntityEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.player.PlayerUseUnknownEntityEvent) {}

  /** Called when a [com.destroystokyo.paper.event.profile.FillProfileEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.profile.FillProfileEvent) {}

  /** Called when a [com.destroystokyo.paper.event.profile.LookupProfileEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.profile.LookupProfileEvent) {}

  /** Called when a [com.destroystokyo.paper.event.profile.PreFillProfileEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.profile.PreFillProfileEvent) {}

  /** Called when a [com.destroystokyo.paper.event.profile.PreLookupProfileEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.profile.PreLookupProfileEvent) {}

  /** Called when a [com.destroystokyo.paper.event.profile.ProfileWhitelistVerifyEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.profile.ProfileWhitelistVerifyEvent) {}

  /** Called when a [com.destroystokyo.paper.event.server.AsyncTabCompleteEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.server.AsyncTabCompleteEvent) {}

  /** Called when a [com.destroystokyo.paper.event.server.GS4QueryEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.server.GS4QueryEvent) {}

  /** Called when a [com.destroystokyo.paper.event.server.PaperServerListPingEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.server.PaperServerListPingEvent) {}

  /** Called when a [com.destroystokyo.paper.event.server.ServerExceptionEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.server.ServerExceptionEvent) {}

  /** Called when a [com.destroystokyo.paper.event.server.WhitelistToggleEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.event.server.WhitelistToggleEvent) {}

  /** Called when a [com.destroystokyo.paper.loottable.LootableInventoryReplenishEvent] is called. */
  public suspend fun on(event: com.destroystokyo.paper.loottable.LootableInventoryReplenishEvent) {}

  /** Called when a [io.papermc.paper.event.block.BeaconActivatedEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.block.BeaconActivatedEvent) {}

  /** Called when a [io.papermc.paper.event.block.BeaconDeactivatedEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.block.BeaconDeactivatedEvent) {}

  /** Called when a [io.papermc.paper.event.block.BlockBreakBlockEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.block.BlockBreakBlockEvent) {}

  /** Called when a [io.papermc.paper.event.block.BlockBreakProgressUpdateEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.block.BlockBreakProgressUpdateEvent) {}

  /** Called when a [io.papermc.paper.event.block.BlockFailedDispenseEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.block.BlockFailedDispenseEvent) {}

  /** Called when a [io.papermc.paper.event.block.BlockLockCheckEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.block.BlockLockCheckEvent) {}

  /** Called when a [io.papermc.paper.event.block.BlockPreDispenseEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.block.BlockPreDispenseEvent) {}

  /** Called when a [io.papermc.paper.event.block.CompostItemEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.block.CompostItemEvent) {}

  /** Called when a [io.papermc.paper.event.block.DragonEggFormEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.block.DragonEggFormEvent) {}

  /** Called when a [io.papermc.paper.event.block.PlayerShearBlockEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.block.PlayerShearBlockEvent) {}

  /** Called when a [io.papermc.paper.event.block.TargetHitEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.block.TargetHitEvent) {}

  /** Called when a [io.papermc.paper.event.entity.ElderGuardianAppearanceEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.ElderGuardianAppearanceEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityAttemptSmashAttackEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityAttemptSmashAttackEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityCompostItemEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityCompostItemEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityDamageItemEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityDamageItemEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityDyeEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityDyeEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityEquipmentChangedEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityEquipmentChangedEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityFertilizeEggEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityFertilizeEggEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityInsideBlockEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityInsideBlockEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityKnockbackEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityKnockbackEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityLoadCrossbowEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityLoadCrossbowEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityMoveEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityMoveEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityPortalReadyEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityPortalReadyEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityPushedByEntityAttackEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityPushedByEntityAttackEvent) {}

  /** Called when a [io.papermc.paper.event.entity.EntityToggleSitEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.EntityToggleSitEvent) {}

  /** Called when a [io.papermc.paper.event.entity.PufferFishStateChangeEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.PufferFishStateChangeEvent) {}

  /** Called when a [io.papermc.paper.event.entity.ShulkerDuplicateEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.ShulkerDuplicateEvent) {}

  /** Called when a [io.papermc.paper.event.entity.TameableDeathMessageEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.TameableDeathMessageEvent) {}

  /** Called when a [io.papermc.paper.event.entity.WardenAngerChangeEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.WardenAngerChangeEvent) {}

  /** Called when a [io.papermc.paper.event.entity.WaterBottleSplashEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.entity.WaterBottleSplashEvent) {}

  /** Called when a [io.papermc.paper.event.packet.PlayerChunkLoadEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.packet.PlayerChunkLoadEvent) {}

  /** Called when a [io.papermc.paper.event.packet.PlayerChunkUnloadEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.packet.PlayerChunkUnloadEvent) {}

  /** Called when a [io.papermc.paper.event.player.AsyncChatCommandDecorateEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.AsyncChatCommandDecorateEvent) {}

  /** Called when a [io.papermc.paper.event.player.AsyncChatDecorateEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.AsyncChatDecorateEvent) {}

  /** Called when a [io.papermc.paper.event.player.AsyncChatEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.AsyncChatEvent) {}

  /** Called when a [io.papermc.paper.event.player.CartographyItemEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.CartographyItemEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerArmSwingEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerArmSwingEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerBedFailEnterEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerBedFailEnterEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerChangeBeaconEffectEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerChangeBeaconEffectEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerClientLoadedWorldEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerClientLoadedWorldEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerDeepSleepEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerDeepSleepEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerFailMoveEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerFailMoveEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerFlowerPotManipulateEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerFlowerPotManipulateEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerInsertLecternBookEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerInsertLecternBookEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerInventorySlotChangeEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerInventorySlotChangeEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerItemCooldownEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerItemCooldownEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerItemFrameChangeEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerItemFrameChangeEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerItemGroupCooldownEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerItemGroupCooldownEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerLecternPageChangeEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerLecternPageChangeEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerLoomPatternSelectEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerLoomPatternSelectEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerNameEntityEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerNameEntityEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerOpenSignEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerOpenSignEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerPickItemEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerPickItemEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerPurchaseEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerPurchaseEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerShieldDisableEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerShieldDisableEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerSignCommandPreprocessEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerSignCommandPreprocessEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerStonecutterRecipeSelectEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerStonecutterRecipeSelectEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerStopUsingItemEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerStopUsingItemEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerTrackEntityEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerTrackEntityEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerTradeEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerTradeEvent) {}

  /** Called when a [io.papermc.paper.event.player.PlayerUntrackEntityEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PlayerUntrackEntityEvent) {}

  /** Called when a [io.papermc.paper.event.player.PrePlayerAttackEntityEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.player.PrePlayerAttackEntityEvent) {}

  /** Called when a [io.papermc.paper.event.server.ServerResourcesReloadedEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.server.ServerResourcesReloadedEvent) {}

  /** Called when a [io.papermc.paper.event.server.WhitelistStateUpdateEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.server.WhitelistStateUpdateEvent) {}

  /** Called when a [io.papermc.paper.event.world.StructuresLocateEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.world.StructuresLocateEvent) {}

  /** Called when a [io.papermc.paper.event.world.WorldGameRuleChangeEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.world.WorldGameRuleChangeEvent) {}

  /** Called when a [io.papermc.paper.event.world.border.WorldBorderBoundsChangeEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.world.border.WorldBorderBoundsChangeEvent) {}

  /** Called when a [io.papermc.paper.event.world.border.WorldBorderBoundsChangeFinishEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.world.border.WorldBorderBoundsChangeFinishEvent) {}

  /** Called when a [io.papermc.paper.event.world.border.WorldBorderCenterChangeEvent] is called. */
  public suspend fun on(event: io.papermc.paper.event.world.border.WorldBorderCenterChangeEvent) {}

  /** Called when a [org.bukkit.event.block.BellResonateEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BellResonateEvent) {}

  /** Called when a [org.bukkit.event.block.BellRingEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BellRingEvent) {}

  /** Called when a [org.bukkit.event.block.BlockBreakEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockBreakEvent) {}

  /** Called when a [org.bukkit.event.block.BlockBurnEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockBurnEvent) {}

  /** Called when a [org.bukkit.event.block.BlockCanBuildEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockCanBuildEvent) {}

  /** Called when a [org.bukkit.event.block.BlockCookEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockCookEvent) {}

  /** Called when a [org.bukkit.event.block.BlockDamageAbortEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockDamageAbortEvent) {}

  /** Called when a [org.bukkit.event.block.BlockDamageEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockDamageEvent) {}

  /** Called when a [org.bukkit.event.block.BlockDispenseArmorEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockDispenseArmorEvent) {}

  /** Called when a [org.bukkit.event.block.BlockDispenseEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockDispenseEvent) {}

  /** Called when a [org.bukkit.event.block.BlockDispenseLootEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockDispenseLootEvent) {}

  /** Called when a [org.bukkit.event.block.BlockDropItemEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockDropItemEvent) {}

  /** Called when a [org.bukkit.event.block.BlockExpEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockExpEvent) {}

  /** Called when a [org.bukkit.event.block.BlockExplodeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockExplodeEvent) {}

  /** Called when a [org.bukkit.event.block.BlockFadeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockFadeEvent) {}

  /** Called when a [org.bukkit.event.block.BlockFertilizeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockFertilizeEvent) {}

  /** Called when a [org.bukkit.event.block.BlockFormEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockFormEvent) {}

  /** Called when a [org.bukkit.event.block.BlockFromToEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockFromToEvent) {}

  /** Called when a [org.bukkit.event.block.BlockGrowEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockGrowEvent) {}

  /** Called when a [org.bukkit.event.block.BlockIgniteEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockIgniteEvent) {}

  /** Called when a [org.bukkit.event.block.BlockMultiPlaceEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockMultiPlaceEvent) {}

  /** Called when a [org.bukkit.event.block.BlockPhysicsEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockPhysicsEvent) {}

  /** Called when a [org.bukkit.event.block.BlockPistonExtendEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockPistonExtendEvent) {}

  /** Called when a [org.bukkit.event.block.BlockPistonRetractEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockPistonRetractEvent) {}

  /** Called when a [org.bukkit.event.block.BlockPlaceEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockPlaceEvent) {}

  /** Called when a [org.bukkit.event.block.BlockReceiveGameEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockReceiveGameEvent) {}

  /** Called when a [org.bukkit.event.block.BlockRedstoneEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockRedstoneEvent) {}

  /** Called when a [org.bukkit.event.block.BlockShearEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockShearEntityEvent) {}

  /** Called when a [org.bukkit.event.block.BlockSpreadEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BlockSpreadEvent) {}

  /** Called when a [org.bukkit.event.block.BrewingStartEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.BrewingStartEvent) {}

  /** Called when a [org.bukkit.event.block.CampfireStartEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.CampfireStartEvent) {}

  /** Called when a [org.bukkit.event.block.CauldronLevelChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.CauldronLevelChangeEvent) {}

  /** Called when a [org.bukkit.event.block.CrafterCraftEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.CrafterCraftEvent) {}

  /** Called when a [org.bukkit.event.block.EntityBlockFormEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.EntityBlockFormEvent) {}

  /** Called when a [org.bukkit.event.block.FluidLevelChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.FluidLevelChangeEvent) {}

  /** Called when a [org.bukkit.event.block.InventoryBlockStartEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.InventoryBlockStartEvent) {}

  /** Called when a [org.bukkit.event.block.LeavesDecayEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.LeavesDecayEvent) {}

  /** Called when a [org.bukkit.event.block.MoistureChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.MoistureChangeEvent) {}

  /** Called when a [org.bukkit.event.block.NotePlayEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.NotePlayEvent) {}

  /** Called when a [org.bukkit.event.block.SculkBloomEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.SculkBloomEvent) {}

  /** Called when a [org.bukkit.event.block.SignChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.SignChangeEvent) {}

  /** Called when a [org.bukkit.event.block.SpongeAbsorbEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.SpongeAbsorbEvent) {}

  /** Called when a [org.bukkit.event.block.TNTPrimeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.TNTPrimeEvent) {}

  /** Called when a [org.bukkit.event.block.VaultDisplayItemEvent] is called. */
  public suspend fun on(event: org.bukkit.event.block.VaultDisplayItemEvent) {}

  /** Called when a [org.bukkit.event.command.UnknownCommandEvent] is called. */
  public suspend fun on(event: org.bukkit.event.command.UnknownCommandEvent) {}

  /** Called when a [org.bukkit.event.enchantment.EnchantItemEvent] is called. */
  public suspend fun on(event: org.bukkit.event.enchantment.EnchantItemEvent) {}

  /** Called when a [org.bukkit.event.enchantment.PrepareItemEnchantEvent] is called. */
  public suspend fun on(event: org.bukkit.event.enchantment.PrepareItemEnchantEvent) {}

  /** Called when a [org.bukkit.event.entity.AreaEffectCloudApplyEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.AreaEffectCloudApplyEvent) {}

  /** Called when a [org.bukkit.event.entity.ArrowBodyCountChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.ArrowBodyCountChangeEvent) {}

  /** Called when a [org.bukkit.event.entity.BatToggleSleepEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.BatToggleSleepEvent) {}

  /** Called when a [org.bukkit.event.entity.CreatureSpawnEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.CreatureSpawnEvent) {}

  /** Called when a [org.bukkit.event.entity.CreeperPowerEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.CreeperPowerEvent) {}

  /** Called when a [org.bukkit.event.entity.EnderDragonChangePhaseEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EnderDragonChangePhaseEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityAirChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityAirChangeEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityBreakDoorEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityBreakDoorEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityBreedEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityBreedEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityChangeBlockEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityChangeBlockEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityCombustByBlockEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityCombustByBlockEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityCombustByEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityCombustByEntityEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityCombustEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityCombustEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityDamageByBlockEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityDamageByBlockEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityDamageByEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityDamageByEntityEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityDamageEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityDamageEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityDeathEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityDeathEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityDismountEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityDismountEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityDropItemEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityDropItemEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityEnterBlockEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityEnterBlockEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityEnterLoveModeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityEnterLoveModeEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityExhaustionEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityExhaustionEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityExplodeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityExplodeEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityInteractEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityInteractEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityMountEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityMountEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityPickupItemEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityPickupItemEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityPlaceEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityPlaceEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityPortalEnterEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityPortalEnterEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityPortalEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityPortalEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityPortalExitEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityPortalExitEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityPoseChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityPoseChangeEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityPotionEffectEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityPotionEffectEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityRegainHealthEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityRegainHealthEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityRemoveEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityRemoveEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityResurrectEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityResurrectEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityShootBowEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityShootBowEvent) {}

  /** Called when a [org.bukkit.event.entity.EntitySpawnEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntitySpawnEvent) {}

  /** Called when a [org.bukkit.event.entity.EntitySpellCastEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntitySpellCastEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityTameEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityTameEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityTargetEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityTargetEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityTargetLivingEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityTargetLivingEntityEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityTeleportEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityTeleportEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityToggleGlideEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityToggleGlideEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityToggleSwimEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityToggleSwimEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityTransformEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityTransformEvent) {}

  /** Called when a [org.bukkit.event.entity.EntityUnleashEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.EntityUnleashEvent) {}

  /** Called when a [org.bukkit.event.entity.ExpBottleEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.ExpBottleEvent) {}

  /** Called when a [org.bukkit.event.entity.ExplosionPrimeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.ExplosionPrimeEvent) {}

  /** Called when a [org.bukkit.event.entity.FireworkExplodeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.FireworkExplodeEvent) {}

  /** Called when a [org.bukkit.event.entity.FoodLevelChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.FoodLevelChangeEvent) {}

  /** Called when a [org.bukkit.event.entity.HorseJumpEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.HorseJumpEvent) {}

  /** Called when a [org.bukkit.event.entity.ItemDespawnEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.ItemDespawnEvent) {}

  /** Called when a [org.bukkit.event.entity.ItemMergeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.ItemMergeEvent) {}

  /** Called when a [org.bukkit.event.entity.ItemSpawnEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.ItemSpawnEvent) {}

  /** Called when a [org.bukkit.event.entity.LingeringPotionSplashEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.LingeringPotionSplashEvent) {}

  /** Called when a [org.bukkit.event.entity.PigZapEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.PigZapEvent) {}

  /** Called when a [org.bukkit.event.entity.PigZombieAngerEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.PigZombieAngerEvent) {}

  /** Called when a [org.bukkit.event.entity.PiglinBarterEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.PiglinBarterEvent) {}

  /** Called when a [org.bukkit.event.entity.PlayerDeathEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.PlayerDeathEvent) {}

  /** Called when a [org.bukkit.event.entity.PlayerLeashEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.PlayerLeashEntityEvent) {}

  /** Called when a [org.bukkit.event.entity.PotionSplashEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.PotionSplashEvent) {}

  /** Called when a [org.bukkit.event.entity.ProjectileHitEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.ProjectileHitEvent) {}

  /** Called when a [org.bukkit.event.entity.ProjectileLaunchEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.ProjectileLaunchEvent) {}

  /** Called when a [org.bukkit.event.entity.SheepDyeWoolEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.SheepDyeWoolEvent) {}

  /** Called when a [org.bukkit.event.entity.SheepRegrowWoolEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.SheepRegrowWoolEvent) {}

  /** Called when a [org.bukkit.event.entity.SlimeSplitEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.SlimeSplitEvent) {}

  /** Called when a [org.bukkit.event.entity.SpawnerSpawnEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.SpawnerSpawnEvent) {}

  /** Called when a [org.bukkit.event.entity.StriderTemperatureChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.StriderTemperatureChangeEvent) {}

  /** Called when a [org.bukkit.event.entity.TrialSpawnerSpawnEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.TrialSpawnerSpawnEvent) {}

  /** Called when a [org.bukkit.event.entity.VillagerAcquireTradeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.VillagerAcquireTradeEvent) {}

  /** Called when a [org.bukkit.event.entity.VillagerCareerChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.VillagerCareerChangeEvent) {}

  /** Called when a [org.bukkit.event.entity.VillagerReplenishTradeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.entity.VillagerReplenishTradeEvent) {}

  /** Called when a [org.bukkit.event.hanging.HangingBreakByEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.hanging.HangingBreakByEntityEvent) {}

  /** Called when a [org.bukkit.event.hanging.HangingBreakEvent] is called. */
  public suspend fun on(event: org.bukkit.event.hanging.HangingBreakEvent) {}

  /** Called when a [org.bukkit.event.hanging.HangingPlaceEvent] is called. */
  public suspend fun on(event: org.bukkit.event.hanging.HangingPlaceEvent) {}

  /** Called when a [org.bukkit.event.inventory.BrewEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.BrewEvent) {}

  /** Called when a [org.bukkit.event.inventory.BrewingStandFuelEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.BrewingStandFuelEvent) {}

  /** Called when a [org.bukkit.event.inventory.CraftItemEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.CraftItemEvent) {}

  /** Called when a [org.bukkit.event.inventory.FurnaceBurnEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.FurnaceBurnEvent) {}

  /** Called when a [org.bukkit.event.inventory.FurnaceExtractEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.FurnaceExtractEvent) {}

  /** Called when a [org.bukkit.event.inventory.FurnaceSmeltEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.FurnaceSmeltEvent) {}

  /** Called when a [org.bukkit.event.inventory.FurnaceStartSmeltEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.FurnaceStartSmeltEvent) {}

  /** Called when a [org.bukkit.event.inventory.HopperInventorySearchEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.HopperInventorySearchEvent) {}

  /** Called when a [org.bukkit.event.inventory.InventoryClickEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.InventoryClickEvent) {}

  /** Called when a [org.bukkit.event.inventory.InventoryCloseEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.InventoryCloseEvent) {}

  /** Called when a [org.bukkit.event.inventory.InventoryCreativeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.InventoryCreativeEvent) {}

  /** Called when a [org.bukkit.event.inventory.InventoryDragEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.InventoryDragEvent) {}

  /** Called when a [org.bukkit.event.inventory.InventoryEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.InventoryEvent) {}

  /** Called when a [org.bukkit.event.inventory.InventoryMoveItemEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.InventoryMoveItemEvent) {}

  /** Called when a [org.bukkit.event.inventory.InventoryOpenEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.InventoryOpenEvent) {}

  /** Called when a [org.bukkit.event.inventory.InventoryPickupItemEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.InventoryPickupItemEvent) {}

  /** Called when a [org.bukkit.event.inventory.PrepareAnvilEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.PrepareAnvilEvent) {}

  /** Called when a [org.bukkit.event.inventory.PrepareGrindstoneEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.PrepareGrindstoneEvent) {}

  /** Called when a [org.bukkit.event.inventory.PrepareItemCraftEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.PrepareItemCraftEvent) {}

  /** Called when a [org.bukkit.event.inventory.PrepareSmithingEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.PrepareSmithingEvent) {}

  /** Called when a [org.bukkit.event.inventory.SmithItemEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.SmithItemEvent) {}

  /** Called when a [org.bukkit.event.inventory.TradeSelectEvent] is called. */
  public suspend fun on(event: org.bukkit.event.inventory.TradeSelectEvent) {}

  /** Called when a [org.bukkit.event.player.AsyncPlayerPreLoginEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.AsyncPlayerPreLoginEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerAdvancementDoneEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerAdvancementDoneEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerAnimationEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerAnimationEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerArmorStandManipulateEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerArmorStandManipulateEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerAttemptPickupItemEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerAttemptPickupItemEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerBedEnterEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerBedEnterEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerBedLeaveEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerBedLeaveEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerBucketEmptyEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerBucketEmptyEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerBucketEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerBucketEntityEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerBucketFillEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerBucketFillEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerChangedMainHandEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerChangedMainHandEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerChangedWorldEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerChangedWorldEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerCommandPreprocessEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerCommandPreprocessEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerCommandSendEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerCommandSendEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerDropItemEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerDropItemEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerEditBookEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerEditBookEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerEggThrowEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerEggThrowEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerExpChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerExpChangeEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerExpCooldownChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerExpCooldownChangeEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerFishEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerFishEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerGameModeChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerGameModeChangeEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerHarvestBlockEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerHarvestBlockEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerHideEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerHideEntityEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerInputEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerInputEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerInteractAtEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerInteractAtEntityEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerInteractEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerInteractEntityEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerInteractEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerInteractEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerItemBreakEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerItemBreakEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerItemConsumeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerItemConsumeEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerItemDamageEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerItemDamageEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerItemHeldEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerItemHeldEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerItemMendEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerItemMendEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerJoinEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerJoinEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerKickEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerKickEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerLevelChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerLevelChangeEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerLinksSendEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerLinksSendEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerLocaleChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerLocaleChangeEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerLoginEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerLoginEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerMoveEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerMoveEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerPickupArrowEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerPickupArrowEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerPortalEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerPortalEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerQuitEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerQuitEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerRecipeDiscoverEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerRecipeDiscoverEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerRegisterChannelEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerRegisterChannelEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerResourcePackStatusEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerResourcePackStatusEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerRespawnEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerRespawnEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerRiptideEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerRiptideEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerShearEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerShearEntityEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerShowEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerShowEntityEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerStatisticIncrementEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerStatisticIncrementEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerSwapHandItemsEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerSwapHandItemsEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerTakeLecternBookEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerTakeLecternBookEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerTeleportEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerTeleportEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerToggleFlightEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerToggleFlightEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerToggleSneakEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerToggleSneakEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerToggleSprintEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerToggleSprintEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerUnleashEntityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerUnleashEntityEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerUnregisterChannelEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerUnregisterChannelEvent) {}

  /** Called when a [org.bukkit.event.player.PlayerVelocityEvent] is called. */
  public suspend fun on(event: org.bukkit.event.player.PlayerVelocityEvent) {}

  /** Called when a [org.bukkit.event.raid.RaidFinishEvent] is called. */
  public suspend fun on(event: org.bukkit.event.raid.RaidFinishEvent) {}

  /** Called when a [org.bukkit.event.raid.RaidSpawnWaveEvent] is called. */
  public suspend fun on(event: org.bukkit.event.raid.RaidSpawnWaveEvent) {}

  /** Called when a [org.bukkit.event.raid.RaidStopEvent] is called. */
  public suspend fun on(event: org.bukkit.event.raid.RaidStopEvent) {}

  /** Called when a [org.bukkit.event.raid.RaidTriggerEvent] is called. */
  public suspend fun on(event: org.bukkit.event.raid.RaidTriggerEvent) {}

  /** Called when a [org.bukkit.event.server.BroadcastMessageEvent] is called. */
  public suspend fun on(event: org.bukkit.event.server.BroadcastMessageEvent) {}

  /** Called when a [org.bukkit.event.server.MapInitializeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.server.MapInitializeEvent) {}

  /** Called when a [org.bukkit.event.server.PluginDisableEvent] is called. */
  public suspend fun on(event: org.bukkit.event.server.PluginDisableEvent) {}

  /** Called when a [org.bukkit.event.server.PluginEnableEvent] is called. */
  public suspend fun on(event: org.bukkit.event.server.PluginEnableEvent) {}

  /** Called when a [org.bukkit.event.server.RemoteServerCommandEvent] is called. */
  public suspend fun on(event: org.bukkit.event.server.RemoteServerCommandEvent) {}

  /** Called when a [org.bukkit.event.server.ServerCommandEvent] is called. */
  public suspend fun on(event: org.bukkit.event.server.ServerCommandEvent) {}

  /** Called when a [org.bukkit.event.server.ServerListPingEvent] is called. */
  public suspend fun on(event: org.bukkit.event.server.ServerListPingEvent) {}

  /** Called when a [org.bukkit.event.server.ServerLoadEvent] is called. */
  public suspend fun on(event: org.bukkit.event.server.ServerLoadEvent) {}

  /** Called when a [org.bukkit.event.server.ServiceRegisterEvent] is called. */
  public suspend fun on(event: org.bukkit.event.server.ServiceRegisterEvent) {}

  /** Called when a [org.bukkit.event.server.ServiceUnregisterEvent] is called. */
  public suspend fun on(event: org.bukkit.event.server.ServiceUnregisterEvent) {}

  /** Called when a [org.bukkit.event.server.TabCompleteEvent] is called. */
  public suspend fun on(event: org.bukkit.event.server.TabCompleteEvent) {}

  /** Called when a [org.bukkit.event.vehicle.VehicleBlockCollisionEvent] is called. */
  public suspend fun on(event: org.bukkit.event.vehicle.VehicleBlockCollisionEvent) {}

  /** Called when a [org.bukkit.event.vehicle.VehicleCreateEvent] is called. */
  public suspend fun on(event: org.bukkit.event.vehicle.VehicleCreateEvent) {}

  /** Called when a [org.bukkit.event.vehicle.VehicleDamageEvent] is called. */
  public suspend fun on(event: org.bukkit.event.vehicle.VehicleDamageEvent) {}

  /** Called when a [org.bukkit.event.vehicle.VehicleDestroyEvent] is called. */
  public suspend fun on(event: org.bukkit.event.vehicle.VehicleDestroyEvent) {}

  /** Called when a [org.bukkit.event.vehicle.VehicleEnterEvent] is called. */
  public suspend fun on(event: org.bukkit.event.vehicle.VehicleEnterEvent) {}

  /** Called when a [org.bukkit.event.vehicle.VehicleEntityCollisionEvent] is called. */
  public suspend fun on(event: org.bukkit.event.vehicle.VehicleEntityCollisionEvent) {}

  /** Called when a [org.bukkit.event.vehicle.VehicleExitEvent] is called. */
  public suspend fun on(event: org.bukkit.event.vehicle.VehicleExitEvent) {}

  /** Called when a [org.bukkit.event.vehicle.VehicleMoveEvent] is called. */
  public suspend fun on(event: org.bukkit.event.vehicle.VehicleMoveEvent) {}

  /** Called when a [org.bukkit.event.vehicle.VehicleUpdateEvent] is called. */
  public suspend fun on(event: org.bukkit.event.vehicle.VehicleUpdateEvent) {}

  /** Called when a [org.bukkit.event.weather.LightningStrikeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.weather.LightningStrikeEvent) {}

  /** Called when a [org.bukkit.event.weather.ThunderChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.weather.ThunderChangeEvent) {}

  /** Called when a [org.bukkit.event.weather.WeatherChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.weather.WeatherChangeEvent) {}

  /** Called when a [org.bukkit.event.world.AsyncStructureGenerateEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.AsyncStructureGenerateEvent) {}

  /** Called when a [org.bukkit.event.world.AsyncStructureSpawnEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.AsyncStructureSpawnEvent) {}

  /** Called when a [org.bukkit.event.world.ChunkLoadEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.ChunkLoadEvent) {}

  /** Called when a [org.bukkit.event.world.ChunkPopulateEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.ChunkPopulateEvent) {}

  /** Called when a [org.bukkit.event.world.ChunkUnloadEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.ChunkUnloadEvent) {}

  /** Called when a [org.bukkit.event.world.EntitiesLoadEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.EntitiesLoadEvent) {}

  /** Called when a [org.bukkit.event.world.EntitiesUnloadEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.EntitiesUnloadEvent) {}

  /** Called when a [org.bukkit.event.world.GenericGameEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.GenericGameEvent) {}

  /** Called when a [org.bukkit.event.world.LootGenerateEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.LootGenerateEvent) {}

  /** Called when a [org.bukkit.event.world.PortalCreateEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.PortalCreateEvent) {}

  /** Called when a [org.bukkit.event.world.SpawnChangeEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.SpawnChangeEvent) {}

  /** Called when a [org.bukkit.event.world.StructureGrowEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.StructureGrowEvent) {}

  /** Called when a [org.bukkit.event.world.TimeSkipEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.TimeSkipEvent) {}

  /** Called when a [org.bukkit.event.world.WorldInitEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.WorldInitEvent) {}

  /** Called when a [org.bukkit.event.world.WorldLoadEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.WorldLoadEvent) {}

  /** Called when a [org.bukkit.event.world.WorldSaveEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.WorldSaveEvent) {}

  /** Called when a [org.bukkit.event.world.WorldUnloadEvent] is called. */
  public suspend fun on(event: org.bukkit.event.world.WorldUnloadEvent) {}

  /** Called when a [org.spigotmc.event.player.PlayerSpawnLocationEvent] is called. */
  public suspend fun on(event: org.spigotmc.event.player.PlayerSpawnLocationEvent) {}
}
