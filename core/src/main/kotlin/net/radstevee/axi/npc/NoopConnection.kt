package net.radstevee.axi.npc

import com.mojang.authlib.GameProfile
import net.minecraft.network.Connection
import net.minecraft.network.protocol.PacketFlow
import net.minecraft.server.MinecraftServer
import net.minecraft.server.level.ServerPlayer
import net.minecraft.server.network.CommonListenerCookie
import net.minecraft.server.network.ServerGamePacketListenerImpl

/** A no-op [ServerGamePacketListenerImpl] and [Connection] implementation. */
internal class NoopConnection(
  player: ServerPlayer,
  profile: GameProfile
) : ServerGamePacketListenerImpl(
  MinecraftServer.getServer(),
  NOOP_CONNECTION,
  player,
  CommonListenerCookie.createInitial(profile, false),
) {
  private companion object {
    val NOOP_CONNECTION: Connection = object : Connection(PacketFlow.SERVERBOUND) {}
  }
}
