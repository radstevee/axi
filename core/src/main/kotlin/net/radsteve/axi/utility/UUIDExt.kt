package net.radsteve.axi.utility

import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import java.util.UUID

/** The currently online player for this UUID. Throws if this player is not online. */
public val UUID.onlinePlayer: Player get() = Bukkit.getPlayer(this) ?: error("player not online")

/** The offline player for this UUID. */
public val UUID.offlinePlayer: OfflinePlayer get() = Bukkit.getOfflinePlayer(this)
