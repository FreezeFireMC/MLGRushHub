package de.chaos.mc.server.mlgrushhub.utils;

import de.chaos.mc.serverapi.utils.playerlibary.languageLibary.LanguageType;
import lombok.Builder;
import lombok.Data;
import org.bukkit.entity.Player;

import java.util.UUID;

@Data
@Builder
public class MLGRushPlayerLanguage {
    public UUID uuid;
    public LanguageType languageType;

    public String playerChallengedYou(UUID uuid, Player player) {
        return MLGRushAbstractMessages.playerChallengedYou(uuid, player);
    }
    public String youChallengedPlayer(UUID uuid, Player player) {
        return MLGRushAbstractMessages.youChallengedPlayer(uuid, player);
    }
    public String playerWasAlradyChallenged;

    // stats
    public String Stats;
    public String kills;
    public String deaths;
    public String brokenBeds;

    // InventoryUpdating
    public String STICK;
    public String PICKAXT;
    public String BLOCKS;
    public String INVNAME;
    public String INVENTORYUPDATED;

    //Items
    public String SWORDNAME;

    //Challenge
    public String pressHereToAccept;
    public String accept;
}
