package de.chaos.mc.server.mlgrushhub.commands;

import de.chaos.mc.server.mlgrushhub.MLGRushHub;
import de.chaos.mc.serverapi.ServerAPIBukkitMain;
import de.chaos.mc.serverapi.utils.playerlibary.languageLibary.PlayerLanguage;
import de.chaos.mc.serverapi.utils.stringLibary.AbstractMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerLanguage playerLanguage = ServerAPIBukkitMain.getOnlinePlayers().get(player.getUniqueId());
            if (player.hasPermission("FreezeFire.setLocation")) {
                    MLGRushHub.getLocationInterface().addLocation("spawn", player.getLocation());
            } else player.sendMessage(playerLanguage.getNOPERMISSION());
        } else sender.sendMessage(AbstractMessages.BEAPLAYER);

        return true;
    }
}
