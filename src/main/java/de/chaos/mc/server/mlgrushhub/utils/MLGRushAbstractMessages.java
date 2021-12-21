package de.chaos.mc.server.mlgrushhub.utils;

import de.chaos.mc.server.mlgrushhub.MLGRushHub;
import de.chaos.mc.server.mlgrushhub.utils.languagelibary.translation.EnglishMLGRushHubTranslation;
import de.chaos.mc.server.mlgrushhub.utils.languagelibary.translation.FrenchMLGRushHubTranslation;
import de.chaos.mc.server.mlgrushhub.utils.languagelibary.translation.GermanMLGRushHubTranslation;
import de.chaos.mc.serverapi.utils.playerlibary.languageLibary.LanguageInterface;
import org.bukkit.entity.Player;

import java.util.UUID;

public class MLGRushAbstractMessages {
    private static LanguageInterface languageInterface = MLGRushHub.getInstance().getLanguageInterface();
    public static String playerChallengedYou(UUID uuid, Player player) {
        String string = null;
        switch(languageInterface.getLanguageType(player.getUniqueId())) {
            case EG:
                string = EnglishMLGRushHubTranslation.playerChallengedYou(player);
                break;
            case DE:
                string = GermanMLGRushHubTranslation.playerChallengedYou(player);
                break;
            case FR:
                string = FrenchMLGRushHubTranslation.playerChallengedYou(player);
                break;
            case OTHER:
                string = EnglishMLGRushHubTranslation.playerChallengedYou(player);
        }
        return string;
    }

    public static String youChallengedPlayer(UUID uuid, Player player) {
        String string = null;
        switch(languageInterface.getLanguageType(player.getUniqueId())) {
            case EG:
                string = EnglishMLGRushHubTranslation.youChallengedPlayer(player);
                break;
            case DE:
                string = GermanMLGRushHubTranslation.youChallengedPlayer(player);
                break;
            case FR:
                string = FrenchMLGRushHubTranslation.youChallengedPlayer(player);
                break;
            case OTHER:
                string = EnglishMLGRushHubTranslation.youChallengedPlayer(player);
        }
        return string;
    }
}
