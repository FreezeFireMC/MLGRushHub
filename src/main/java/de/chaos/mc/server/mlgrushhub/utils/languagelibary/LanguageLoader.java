package de.chaos.mc.server.mlgrushhub.utils.languagelibary;

import de.chaos.mc.server.mlgrushhub.MLGRushHub;
import de.chaos.mc.server.mlgrushhub.utils.MLGRushPlayerLanguage;
import de.chaos.mc.server.mlgrushhub.utils.languagelibary.translation.EnglishMLGRushHubTranslation;
import de.chaos.mc.server.mlgrushhub.utils.languagelibary.translation.FrenchMLGRushHubTranslation;
import de.chaos.mc.server.mlgrushhub.utils.languagelibary.translation.GermanMLGRushHubTranslation;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.itemnames.EnglishMLGRushITranslations;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.itemnames.FrenchMLGRushTranslations;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.itemnames.GermanMLGRushTranslations;
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
                        .STICK(EnglishMLGRushITranslations.STICK.getTranslation())
                        .PICKAXT(EnglishMLGRushITranslations.PICKAXT.getTranslation())
                        .BLOCKS(EnglishMLGRushITranslations.BLOCKS.getTranslation())
                        .INVNAME(EnglishMLGRushITranslations.INVNAME.getTranslation())
                        .INVENTORYUPDATED(EnglishMLGRushITranslations.INVENTORYUPDATED.getTranslation())
                        .SWORDNAME(EnglishMLGRushHubTranslation.swordname)
                        .pressHereToAccept(EnglishMLGRushHubTranslation.pressHereToAccept)
                        .accept(EnglishMLGRushHubTranslation.accept)
                        .build();
                MLGRushHub.getOnlinePlayers().put(uuid, mlgRushPlayerLanguage);
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
                        .STICK(GermanMLGRushTranslations.STICK.getTranslation())
                        .PICKAXT(GermanMLGRushTranslations.PICKAXT.getTranslation())
                        .BLOCKS(GermanMLGRushTranslations.BLOCKS.getTranslation())
                        .INVNAME(GermanMLGRushTranslations.INVNAME.getTranslation())
                        .INVENTORYUPDATED(GermanMLGRushTranslations.INVENTORYUPDATED.getTranslation())
                        .pressHereToAccept(GermanMLGRushHubTranslation.pressHereToAccept)
                        .accept(GermanMLGRushHubTranslation.accept)
                        .SWORDNAME(GermanMLGRushHubTranslation.swordname)
                        .build();
                MLGRushHub.getOnlinePlayers().put(uuid, mlgRushPlayerLanguage);
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
                        .STICK(FrenchMLGRushTranslations.STICK.getTranslation())
                        .PICKAXT(FrenchMLGRushTranslations.PICKAXT.getTranslation())
                        .BLOCKS(FrenchMLGRushTranslations.BLOCKS.getTranslation())
                        .INVNAME(FrenchMLGRushTranslations.INVNAME.getTranslation())
                        .INVENTORYUPDATED(FrenchMLGRushTranslations.INVENTORYUPDATED.getTranslation())
                        .SWORDNAME(FrenchMLGRushHubTranslation.swordname)
                        .pressHereToAccept(FrenchMLGRushHubTranslation.pressHereToAccept)
                        .accept(FrenchMLGRushHubTranslation.accept)
                        .build();
                MLGRushHub.getOnlinePlayers().put(uuid, mlgRushPlayerLanguage);
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
                        .STICK(EnglishMLGRushITranslations.STICK.getTranslation())
                        .PICKAXT(EnglishMLGRushITranslations.PICKAXT.getTranslation())
                        .BLOCKS(EnglishMLGRushITranslations.BLOCKS.getTranslation())
                        .INVNAME(EnglishMLGRushITranslations.INVNAME.getTranslation())
                        .INVENTORYUPDATED(EnglishMLGRushITranslations.INVENTORYUPDATED.getTranslation())
                        .SWORDNAME(EnglishMLGRushHubTranslation.swordname)
                        .pressHereToAccept(EnglishMLGRushHubTranslation.pressHereToAccept)
                        .accept(EnglishMLGRushHubTranslation.accept)
                        .build();
                MLGRushHub.getOnlinePlayers().put(uuid, mlgRushPlayerLanguage);
                break;
        }
        MLGRushHub.getOnlinePlayers().put(uuid, mlgRushPlayerLanguage);
    }
}