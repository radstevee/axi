package net.radsteve.axi.mixin;

import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import io.papermc.paper.entity.TeleportFlag;
import org.bukkit.Location;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(CraftPlayer.class)
public abstract class CraftPlayerMixin {
  @Shadow
  public abstract Player getPlayer();

  @Inject(method = "teleport(Lorg/bukkit/Location;Lorg/bukkit/event/player/PlayerTeleportEvent$TeleportCause;[Lio/papermc/paper/entity/TeleportFlag;)Z", at = @At("HEAD"))
  private void injectHead(Location location, PlayerTeleportEvent.TeleportCause cause, TeleportFlag[] flags, CallbackInfoReturnable<Boolean> cir, @Share("passengers") LocalRef<List<Entity>> passengerRef) {
    passengerRef.set(getPlayer().getPassengers());
    passengerRef.get().forEach((passenger) -> getPlayer().removePassenger(passenger));
  }

  @Inject(method = "teleport(Lorg/bukkit/Location;Lorg/bukkit/event/player/PlayerTeleportEvent$TeleportCause;[Lio/papermc/paper/entity/TeleportFlag;)Z", at = @At("TAIL"))
  private void injectTail(Location location, PlayerTeleportEvent.TeleportCause cause, TeleportFlag[] flags, CallbackInfoReturnable<Boolean> cir, @Share("passengers") LocalRef<List<Entity>> passengerRef) {
    passengerRef.get().forEach((passenger) -> getPlayer().addPassenger(passenger));
  }
}
