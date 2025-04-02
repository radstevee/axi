package net.radsteve.axi.npc

import com.mojang.authlib.GameProfile
import com.mojang.authlib.properties.Property
import io.papermc.paper.adventure.PaperAdventure
import net.kyori.adventure.text.Component
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Action.INITIALIZE_CHAT
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Action.UPDATE_DISPLAY_NAME
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Action.UPDATE_GAME_MODE
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Action.UPDATE_LATENCY
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Action.UPDATE_LISTED
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket
import net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket
import net.minecraft.network.syncher.EntityDataSerializers
import net.minecraft.network.syncher.SynchedEntityData
import net.minecraft.server.MinecraftServer
import net.minecraft.server.level.ClientInformation
import net.minecraft.server.level.ParticleStatus
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.Display
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.HumanoidArm
import net.minecraft.world.entity.player.ChatVisiblity
import net.minecraft.world.level.GameType.DEFAULT_MODE
import net.minecraft.world.phys.Vec3
import net.minecraft.world.scores.PlayerTeam
import net.minecraft.world.scores.Scoreboard
import net.minecraft.world.scores.Team
import net.radsteve.axi.utility.nms
import net.radsteve.axi.utility.sendPacket
import org.bukkit.Location
import org.bukkit.entity.Player
import java.util.EnumSet
import java.util.UUID

/** An NPC, a fake player displayed in a world that does not actually exist on the server. */
public class NPC(
  /** The display name of the NPC. */
  displayName: Component,
  /** The location of this NPC. */
  location: Location,
  /** The skin data, including the value and signature. */
  skinData: SkinData,
  /** Properties for skin display. */
  skinProperties: Set<SkinProperty> = SkinProperty.entries.toSet(),
  /** The UUID of this NPC. */
  public val uuid: UUID = UUID.randomUUID(),
) {
  public constructor(
    /** The display name of the NPC. */
    name: Component,
    /** The location of this NPC. */
    location: Location,
    /** The [SkinRegistry.AxiSkins] registry key for the skin data. */
    skinDataId: String,
    /** Properties for skin display. */
    skinProperties: Set<SkinProperty> = SkinProperty.entries.toSet(),
    /** The UUID of this NPC. */
    uuid: UUID = UUID.randomUUID(),
  ) : this(
    name,
    location,
    requireNotNull(SkinRegistry.AxiSkins[skinDataId]) { "invalid skin data id" },
    skinProperties,
    uuid,
  )

  private companion object {
    const val NAME: String = "                "
  }

  /** The game profile for this NPC. */
  private val profile = GameProfile(uuid, NAME).apply {
    properties.put("textures", Property("textures", skinData.value, skinData.signature))
  }

  /** Information about this NPC sent to players. */
  private val information: ClientInformation = ClientInformation(
    "en_us",
    0,
    ChatVisiblity.HIDDEN,
    false,
    SkinProperty.pack(skinProperties),
    HumanoidArm.RIGHT,
    false,
    false,
    ParticleStatus.MINIMAL,
  )

  /** The NPC player. */
  public val npc: ServerPlayer = ServerPlayer(
    MinecraftServer.getServer(),
    location.world.nms,
    profile,
    information,
  ).apply {
    setPos(location.x, location.y, location.z)
    connection = NoopConnection(this, profile)
    id = 42_000_000 - id
  }

  private val displayName: net.minecraft.network.chat.Component = PaperAdventure.asVanilla(displayName)

  /** The name tag text display. */
  private val nameTag: Display.TextDisplay = Display.TextDisplay(EntityType.TEXT_DISPLAY, location.world.nms).apply {
    setPos(location.x, location.y + 2.05, location.z)
    id = 42_000_000 - id
  }

  /** Shows this NPC to the given [player]. */
  public fun show(player: Player) {
    // Add the NPC to the client player list
    player.sendPacket(
      ClientboundPlayerInfoUpdatePacket(
        EnumSet.of(
          ADD_PLAYER,
          INITIALIZE_CHAT,
          UPDATE_GAME_MODE,
          UPDATE_LISTED,
          UPDATE_LATENCY,
          UPDATE_DISPLAY_NAME,
        ),
        ClientboundPlayerInfoUpdatePacket.Entry(
          uuid,
          profile,
          false,
          0,
          DEFAULT_MODE,
          displayName,
          true,
          0,
          npc.chatSession?.asData(),
        ),
      ),
    )

    // Actually spawn the NPC now
    player.sendPacket(
      ClientboundAddEntityPacket(
        npc.id,
        uuid,
        npc.x,
        npc.y,
        npc.z,
        npc.xRot,
        npc.yRot,
        npc.type,
        0,
        Vec3.ZERO,
        npc.yHeadRot.toDouble(),
      ),
    )

    // Fix its skin parts
    player.sendPacket(
      ClientboundSetEntityDataPacket(
        npc.id,
        listOf(
          SynchedEntityData.DataValue(
            17,
            EntityDataSerializers.BYTE,
            information.modelCustomisation().toByte(),
          ),
        ),
      ),
    )

    // Then we spawn the name tag
    player.sendPacket(
      ClientboundAddEntityPacket(
        nameTag.id,
        nameTag.uuid,
        nameTag.x,
        nameTag.y,
        nameTag.z,
        nameTag.xRot,
        nameTag.yRot,
        nameTag.type,
        0,
        Vec3.ZERO,
        nameTag.yHeadRot.toDouble(),
      ),
    )

    // And set its data
    player.sendPacket(
      ClientboundSetEntityDataPacket(
        nameTag.id,
        listOf(
          // The text contents
          SynchedEntityData.DataValue(
            23,
            EntityDataSerializers.COMPONENT,
            displayName,
          ),
          // The billboard type
          SynchedEntityData.DataValue(
            15,
            EntityDataSerializers.BYTE,
            3, // CENTER
          ),
        ),
      ),
    )

    // And finally, we add the NPC to a team that hides its name tag
    player.sendPacket(
      ClientboundSetPlayerTeamPacket.createAddOrModifyPacket(
        PlayerTeam(
          Scoreboard(),
          NAME,
        ).apply {
          players.add(name)
          nameTagVisibility = Team.Visibility.NEVER
        },
        true,
      ),
    )
  }
}
