package de.chaos.mc.server.mlgrushhub.utils.languagelibary.translation;

import de.chaos.mc.serverapi.utils.stringLibary.AbstractMessages;
import org.bukkit.entity.Player;

public class FrenchMLGRushHubTranslation {
    public static String playerChallengedYou(Player player) {
        return AbstractMessages.normalMessage(player.getName() + " Challenged you to a fight");
    }
    public static String youChallengedPlayer(Player player) {
        return AbstractMessages.normalMessage("You challenged " + player.getName() + " to a fight");
    }
    public static String playerWasAlradyChallenged = AbstractMessages.normalMessage("You already Challenged this player");

    public static String Stats = "§6Stats: ";
    public static String kills = "§6Kills: ";
    public static String deaths = "§6Tode";
    public static String brokenBeds = "§6Broken beds";
}
