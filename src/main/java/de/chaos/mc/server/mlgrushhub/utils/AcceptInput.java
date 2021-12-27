package de.chaos.mc.server.mlgrushhub.utils;

import de.chaos.mc.server.mlgrushhub.MLGRushHub;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;

import java.util.UUID;

public class AcceptInput {
    public void sendVoteMessag(UUID player, UUID target) {
        MLGRushPlayerLanguage targetLanguage = MLGRushHub.getOnlinePlayers().get(target);
        TextComponent link = new TextComponent(targetLanguage.getAccept());
        link.setColor(ChatColor.GREEN);
        link.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("/accept " + Bukkit.getPlayer(player).getName()).create()));
        link.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/accept " + Bukkit.getPlayer(player).getName()));
        Bukkit.getPlayer(target).spigot().sendMessage(link);
    }
}