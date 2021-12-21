package de.chaos.mc.server.mlgrushhub.listener;

import de.chaos.mc.server.mlgrushhub.utils.languagelibary.LanguageLoader;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.ormlite.UpdateMLGRushInventorySortingInterface;
import de.chaos.mc.server.mlgrushhub.utils.statsLibary.StatsInterface;
import de.chaos.mc.serverapi.utils.stringLibary.AbstractMessages;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ConnectionListener implements Listener {
    private UpdateMLGRushInventorySortingInterface sortingInterface;
    private StatsInterface statsInterface;
    private LanguageLoader languageLoader;
    public ConnectionListener(UpdateMLGRushInventorySortingInterface sortingInterface, StatsInterface statsInterface, LanguageLoader languageLoader) {
        this.sortingInterface = sortingInterface;
        this.statsInterface = statsInterface;
        this.languageLoader = languageLoader;
    }

    @EventHandler
    public void onSpawn(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(AbstractMessages.joinMessage(player));
        player.setGameMode(GameMode.ADVENTURE);
        sortingInterface.checkIfFirstJoin(player.getUniqueId());
        statsInterface.checkIfFirstJoin(player.getUniqueId());
        languageLoader.loadPlayer(player.getUniqueId());
    }
}