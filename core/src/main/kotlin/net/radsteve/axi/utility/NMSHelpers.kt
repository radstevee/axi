package net.radsteve.axi.utility

import net.minecraft.network.protocol.Packet
import net.minecraft.network.protocol.game.ClientGamePacketListener
import net.minecraft.server.level.ServerLevel
import net.minecraft.server.level.ServerPlayer
import org.bukkit.World
import org.bukkit.craftbukkit.CraftWorld
import org.bukkit.craftbukkit.entity.CraftPlayer
import org.bukkit.entity.Player

public val World.nms: ServerLevel get() = (this as CraftWorld).handle
public val Player.nms: ServerPlayer get() = (this as CraftPlayer).handle

public fun Player.sendPacket(packet: Packet<ClientGamePacketListener>) {
  nms.connection.send(packet)
}
