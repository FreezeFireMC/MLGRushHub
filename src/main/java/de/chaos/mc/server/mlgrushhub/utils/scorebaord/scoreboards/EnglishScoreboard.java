package de.chaos.mc.server.mlgrushhub.utils.scorebaord.scoreboards;

import de.chaos.mc.server.mlgrushhub.utils.scorebaord.PlayerScorebaord;
import de.chaos.mc.server.mlgrushhub.utils.statsLibary.StatsInterface;
import de.chaos.mc.serverapi.utils.playerlibary.languageLibary.LanguageType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.UUID;

public class EnglishScoreboard {
    public HashMap<UUID, PlayerScorebaord> playerScorebaordHashMap;
    public StatsInterface statsInterface;
    public EnglishScoreboard(Plugin plugin, HashMap<UUID, PlayerScorebaord> playerScorebaordHashMap, StatsInterface statsInterface) {
        this.playerScorebaordHashMap = playerScorebaordHashMap;
        this.statsInterface = statsInterface;
        startUpdater(plugin);
    }
    public void startUpdater(Plugin plugin) {
        BukkitTask bukkitTask = new BukkitRunnable() {
            @Override
            public void run() {
                for (UUID uuid : playerScorebaordHashMap.keySet()) {
                    PlayerScorebaord playerScorebaord = playerScorebaordHashMap.get(uuid);
                    if (playerScorebaord.getLanguageType() == LanguageType.DE) {
                        Objective objective = playerScorebaord.getScoreboard().getObjective("Lobby");
                        playerScorebaord.getDeaths().setSuffix("§b" + statsInterface.getDeaths(uuid));
                        playerScorebaord.getDeaths().addEntry(ChatColor.AQUA.toString());
                        playerScorebaord.getKills().setSuffix("§b" + statsInterface.getKills(uuid));
                        playerScorebaord.getKills().addEntry(ChatColor.DARK_RED.toString());

                        objective.getScore(ChatColor.DARK_RED.toString()).setScore(4);
                        objective.getScore(ChatColor.AQUA.toString()).setScore(1);
                    }
                }
            }
        }.runTaskTimer(plugin,20, 1);
    }


    public Scoreboard getScorebaord(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("Lobby", "2");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("  §bFreeze§cFire  ");
        if (scoreboard.getTeam(player.getName() + ".1") != null) {
            scoreboard.getTeam(player.getName() + ".1").unregister();
        }
        if (scoreboard.getTeam(player.getName() + ".2") != null) {
            scoreboard.getTeam(player.getName() + ".2").unregister();
        }

        Team kills = scoreboard.registerNewTeam(player.getName() + ".1");
        kills.setPrefix("§8» §b");
        kills.setSuffix("§b" + statsInterface.getKills(player.getUniqueId()));
        kills.addEntry(ChatColor.DARK_RED.toString());

        Team deaths = scoreboard.registerNewTeam( player.getName() + ".2");
        deaths.setPrefix("§8» §b");
        deaths.setSuffix("§b" + statsInterface.getDeaths(player.getUniqueId()));
        deaths.addEntry(ChatColor.AQUA.toString());

        objective.getScore("§0").setScore(6);
        objective.getScore("§cKills:").setScore(5);
        objective.getScore(ChatColor.DARK_RED.toString()).setScore(4);
        objective.getScore("§1 ").setScore(3);
        objective.getScore("§cDeaths: ").setScore(2);
        objective.getScore(ChatColor.AQUA.toString()).setScore(1);
        objective.getScore("§3").setScore(0);


        PlayerScorebaord playerScorebaord = PlayerScorebaord.builder()
                .uuid(player.getUniqueId())
                .scoreboard(scoreboard)
                .kills(kills)
                .deaths(deaths)
                .languageType(LanguageType.DE)
                .build();

        playerScorebaordHashMap.put(player.getUniqueId(), playerScorebaord);
        player.setScoreboard(scoreboard);
        return scoreboard;
    }
}