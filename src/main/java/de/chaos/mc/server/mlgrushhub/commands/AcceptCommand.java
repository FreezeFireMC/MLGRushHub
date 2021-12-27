package de.chaos.mc.server.mlgrushhub.commands;

import de.chaos.mc.server.mlgrushhub.MLGRushHub;
import de.chaos.mc.server.mlgrushhub.utils.MLGRushAbstractMessages;
import de.chaos.mc.serverapi.utils.stringLibary.AbstractMessages;
import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.service.ServiceId;
import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;
import de.dytanic.cloudnet.driver.service.ServiceTask;
import de.dytanic.cloudnet.ext.bridge.BridgeServiceProperty;
import de.dytanic.cloudnet.ext.bridge.ServiceInfoSnapshotUtil;
import de.dytanic.cloudnet.ext.bridge.player.IPlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
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
                ServiceId service = null;
                Collection<ServiceInfoSnapshot> servers = CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServices("MLGRush");
                for (ServiceInfoSnapshot serviceTask : servers) {
                    if (!serviceTask.getProperty(BridgeServiceProperty.IS_EMPTY).isPresent()) return true;
                    if (serviceTask.getProperty(BridgeServiceProperty.IS_EMPTY).get()) {
                            service = serviceTask.getServiceId();
                    }
                }
                    ServiceTask serviceTask = CloudNetDriver.getInstance().getServiceTaskProvider().getServiceTask("MLGRush");
                    CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class).getPlayerExecutor(player.getUniqueId()).connect(service.getName());
                    CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class).getPlayerExecutor(uuid).connect(service.getName());
                    CloudNetDriver.getInstance().getCloudServiceFactory().createCloudService(serviceTask, 2);
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