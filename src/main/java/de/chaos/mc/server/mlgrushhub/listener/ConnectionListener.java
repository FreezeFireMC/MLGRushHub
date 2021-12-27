package de.chaos.mc.server.mlgrushhub.listener;

import de.chaos.mc.server.mlgrushhub.MLGRushHub;
import de.chaos.mc.server.mlgrushhub.utils.MLGRushPlayerLanguage;
import de.chaos.mc.server.mlgrushhub.utils.languagelibary.LanguageLoader;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.ormlite.UpdateMLGRushInventorySortingInterface;
import de.chaos.mc.server.mlgrushhub.utils.statsLibary.StatsInterface;
import de.chaos.mc.serverapi.utils.ItemBuilder;
import de.chaos.mc.serverapi.utils.stringLibary.AbstractMessages;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
        languageLoader.loadPlayer(player.getUniqueId());
        MLGRushPlayerLanguage playerLanguage = MLGRushHub.getOnlinePlayers().get(player.getUniqueId());
        event.setJoinMessage(AbstractMessages.joinMessage(player));
        player.setGameMode(GameMode.ADVENTURE);
        sortingInterface.checkIfFirstJoin(player.getUniqueId());
        statsInterface.checkIfFirstJoin(player.getUniqueId());
        player.getInventory().setItem(1, new ItemBuilder(Material.DIAMOND_AXE).name(playerLanguage.getSWORDNAME()).itemStack());
        player.getInventory().setItem(7, new ItemBuilder(Material.CHEST).name(playerLanguage.getINVNAME()).itemStack());
        player.teleport(MLGRushHub.getLocationInterface().getLocation("spawn"));
        MLGRushHub.getScoreboardManager().getScorebaord(player);
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        event.setQuitMessage(AbstractMessages.leaveMessage(event.getPlayer()));
    }
}