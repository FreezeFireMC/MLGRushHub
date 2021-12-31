package de.chaos.mc.server.mlgrushhub.commands;

import de.chaos.mc.server.mlgrushhub.MLGRushHub;
import de.chaos.mc.server.mlgrushhub.utils.MLGRushAbstractMessages;
import de.chaos.mc.serverapi.utils.stringLibary.AbstractMessages;
import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.player.ICloudPlayer;
import eu.thesimplecloud.api.service.ICloudService;
import eu.thesimplecloud.api.servicegroup.ICloudServiceGroup;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class AcceptCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
        Player player = (Player) sender;
            if (args.length == 1) {
                String playerName = args[0];
                UUID uuid = Bukkit.getPlayer(playerName).getUniqueId();
                if (MLGRushHub.getChallengeRequests().containsKey(uuid)) {
                MLGRushHub.getChallengeRequests().remove(uuid);
                Player target = Bukkit.getPlayer(uuid);
                player.sendMessage(MLGRushAbstractMessages.playerAcceptedChallenge(player.getUniqueId(), target));
                    ICloudServiceGroup gameGroup = CloudAPI.getInstance().getCloudServiceGroupManager().getServiceGroupByName("MLGRush");
                    assert gameGroup != null;
                    ICloudService service = null;
                    for (ICloudService cloudService : gameGroup.getAllServices()) {
                            if (cloudService.getOnlineCount() == 0) {
                                service = cloudService;
                        }
                    }
                    ICloudPlayer player1  = CloudAPI.getInstance().getCloudPlayerManager().getCachedCloudPlayer(target.getUniqueId());
                    ICloudPlayer player2 = CloudAPI.getInstance().getCloudPlayerManager().getCachedCloudPlayer(uuid);
                    CloudAPI.getInstance().getCloudPlayerManager().connectPlayer(player1, service);
                    CloudAPI.getInstance().getCloudPlayerManager().connectPlayer(player2, service);
                } else {
                    return true;
                }
            } else {
                player.sendMessage(AbstractMessages.wrongSyntax("/accept playername"));
            }
        } else {
            sender.sendMessage(AbstractMessages.BEAPLAYER);
            return true;
        }
        return false;
    }
}