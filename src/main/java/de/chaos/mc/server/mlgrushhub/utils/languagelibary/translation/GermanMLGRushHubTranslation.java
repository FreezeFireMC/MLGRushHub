package de.chaos.mc.server.mlgrushhub.utils.languagelibary.translation;

import de.chaos.mc.serverapi.utils.stringLibary.AbstractMessages;
import org.bukkit.entity.Player;

public class GermanMLGRushHubTranslation {
    public static String playerChallengedYou(Player player) {
        return AbstractMessages.normalMessage(player.getName() + " hat dich zu einem Kampf herausgefordert");
    }
    public static String youChallengedPlayer(Player player) {
        return AbstractMessages.normalMessage("Du hast " + player.getName() + " zu einem Kampf herausgefordert");
    }
    public static String playerWasAlradyChallenged = AbstractMessages.normalMessage("Du hast diesen Spieler schon herausgefordert");

    public static String Stats = "§6Stats: ";
    public static String kills = "§6Kills: ";
    public static String deaths = "§6Tode";
    public static String brokenBeds = "§6zerstörte Betten";
}
