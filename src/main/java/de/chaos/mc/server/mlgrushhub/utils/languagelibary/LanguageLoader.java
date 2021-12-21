package de.chaos.mc.server.mlgrushhub.utils.languagelibary;

import de.chaos.mc.server.mlgrushhub.MLGRushHub;
import de.chaos.mc.server.mlgrushhub.utils.MLGRushPlayerLanguage;
import de.chaos.mc.server.mlgrushhub.utils.languagelibary.translation.EnglishMLGRushHubTranslation;
import de.chaos.mc.server.mlgrushhub.utils.languagelibary.translation.FrenchMLGRushHubTranslation;
import de.chaos.mc.server.mlgrushhub.utils.languagelibary.translation.GermanMLGRushHubTranslation;
import de.chaos.mc.serverapi.utils.playerlibary.languageLibary.LanguageInterface;
import de.chaos.mc.serverapi.utils.playerlibary.languageLibary.LanguageType;

import java.util.UUID;

public class LanguageLoader {
    private LanguageInterface languageInterface;
    public LanguageLoader(LanguageInterface languageInterface) {
        this.languageInterface = languageInterface;
    }
    public void loadPlayer(UUID uuid) {
        MLGRushPlayerLanguage mlgRushPlayerLanguage = null;
        switch(languageInterface.getLanguageType(uuid)) {
            case EG:
                mlgRushPlayerLanguage = MLGRushPlayerLanguage.builder()
                        .uuid(uuid)
                        .languageType(LanguageType.EG)
                        .playerWasAlradyChallenged(EnglishMLGRushHubTranslation.playerWasAlradyChallenged)
                        .Stats(EnglishMLGRushHubTranslation.Stats)
                        .kills(EnglishMLGRushHubTranslation.kills)
                        .deaths(EnglishMLGRushHubTranslation.deaths)
                        .brokenBeds(EnglishMLGRushHubTranslation.brokenBeds)
                        .build();
                break;
            case DE:
                mlgRushPlayerLanguage = MLGRushPlayerLanguage.builder()
                        .uuid(uuid)
                        .languageType(LanguageType.DE)
                        .playerWasAlradyChallenged(GermanMLGRushHubTranslation.playerWasAlradyChallenged)
                        .Stats(GermanMLGRushHubTranslation.Stats)
                        .kills(GermanMLGRushHubTranslation.kills)
                        .deaths(GermanMLGRushHubTranslation.deaths)
                        .brokenBeds(GermanMLGRushHubTranslation.brokenBeds)
                        .build();
                break;
            case FR:
                mlgRushPlayerLanguage = MLGRushPlayerLanguage.builder()
                        .uuid(uuid)
                        .languageType(LanguageType.FR)
                        .playerWasAlradyChallenged(FrenchMLGRushHubTranslation.playerWasAlradyChallenged)
                        .Stats(FrenchMLGRushHubTranslation.Stats)
                        .kills(FrenchMLGRushHubTranslation.kills)
                        .deaths(FrenchMLGRushHubTranslation.deaths)
                        .brokenBeds(FrenchMLGRushHubTranslation.brokenBeds)
                        .build();
                break;
            case OTHER:
                mlgRushPlayerLanguage = MLGRushPlayerLanguage.builder()
                        .uuid(uuid)
                        .languageType(LanguageType.OTHER)
                        .playerWasAlradyChallenged(EnglishMLGRushHubTranslation.playerWasAlradyChallenged)
                        .Stats(EnglishMLGRushHubTranslation.Stats)
                        .kills(EnglishMLGRushHubTranslation.kills)
                        .deaths(EnglishMLGRushHubTranslation.deaths)
                        .brokenBeds(EnglishMLGRushHubTranslation.brokenBeds)
                        .build();
                break;
        }
        MLGRushHub.getOnlinePlayers().put(uuid, mlgRushPlayerLanguage);
    }
}
