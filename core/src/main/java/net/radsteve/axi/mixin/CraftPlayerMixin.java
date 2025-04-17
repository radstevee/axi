package net.radsteve.axi.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import io.papermc.paper.entity.TeleportFlag;
import org.bukkit.Location;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(CraftPlayer.class)
public abstract class CraftPlayerMixin {
  @Shadow
  public abstract Player getPlayer();

  @WrapMethod(method = "teleport(Lorg/bukkit/Location;Lorg/bukkit/event/player/PlayerTeleportEvent$TeleportCause;[Lio/papermc/paper/entity/TeleportFlag;)Z")
  private boolean wrap(Location location, PlayerTeleportEvent.TeleportCause cause, TeleportFlag[] flags, Operation<Boolean> original) {
    final Player player = this.getPlayer();
    final List<Entity> passengers = player.getPassengers();

    passengers.forEach(player::removePassenger);
    final boolean result = original.call(location, cause, flags);
    passengers.forEach(player::addPassenger);

    return result;
  }
}
