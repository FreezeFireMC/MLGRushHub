package de.chaos.mc.server.mlgrushhub.listener;

import de.chaos.mc.server.mlgrushhub.MLGRushHub;
import de.chaos.mc.server.mlgrushhub.utils.ChallengeRequest;
import de.chaos.mc.server.mlgrushhub.utils.MLGRushPlayerLanguage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onDamagaEvent(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player target = (Player) event.getEntity();
            if (event.getDamager() instanceof Player) {
                Player player = (Player) event.getDamager();
                if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
                    MLGRushPlayerLanguage playerLanguage = MLGRushHub.getOnlinePlayers().get(player.getUniqueId());
                    MLGRushPlayerLanguage targetLanguage = MLGRushHub.getOnlinePlayers().get(target.getUniqueId());
                    if (MLGRushHub.getChallengeRequests().containsKey(player.getUniqueId())) {
                        player.sendMessage(playerLanguage.getPlayerWasAlradyChallenged());
                    } else {
                        ChallengeRequest challengeRequest = ChallengeRequest.builder()
                                .byUUID(player.getUniqueId())
                                .toUUID(target.getUniqueId())
                                .build();
                        MLGRushHub.getChallengeRequests().put(player.getUniqueId(), challengeRequest);
                        target.sendMessage(targetLanguage.playerChallengedYou(target.getUniqueId(), player));
                        target.sendMessage(targetLanguage.getPressHereToAccept());
                        player.sendMessage(playerLanguage.youChallengedPlayer(player.getUniqueId(), target));
                        MLGRushHub.getInstance().getAcceptInput().sendVoteMessag(player.getUniqueId(), target.getUniqueId());
                    }
                }
            }
        }
        event.setCancelled(true);
    }
}