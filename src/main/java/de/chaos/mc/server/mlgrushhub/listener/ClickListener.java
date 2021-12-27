package de.chaos.mc.server.mlgrushhub.listener;

import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.MLGRushProfileInv;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickListener implements Listener {
    MLGRushProfileInv mlgRushProfileInv;
    public ClickListener(MLGRushProfileInv mlgRushProfileInv) {
        this.mlgRushProfileInv = mlgRushProfileInv;
    }
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getItem() == null) {
            event.setCancelled(true);
            return;
        }
        if (event.getItem().getType().equals(Material.CHEST)) {
            event.getPlayer().openInventory(mlgRushProfileInv.getInventory(event.getPlayer()));
            event.setCancelled(true);
        }
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock().getType() == Material.BEACON ||
                    event.getClickedBlock().getType() == Material.CHEST ||
                    event.getClickedBlock().getType() == Material.ENDER_CHEST ||
                    event.getClickedBlock().getType() == Material.ANVIL ||
                    event.getClickedBlock().getType() == Material.FLOWER_POT ||
                    event.getClickedBlock().getType() == Material.HOPPER ||
                    event.getClickedBlock().getType() == Material.HOPPER_MINECART ||
                    event.getClickedBlock().getType() == Material.ACACIA_DOOR ||
                    event.getClickedBlock().getType() == Material.DARK_OAK_DOOR ||
                    event.getClickedBlock().getType() == Material.DARK_OAK_FENCE_GATE ||
                    event.getClickedBlock().getType() == Material.DAYLIGHT_DETECTOR ||
                    event.getClickedBlock().getType() == Material.BOOKSHELF ||
                    event.getClickedBlock().getType() == Material.NOTE_BLOCK ||
                    event.getClickedBlock().getType() == Material.CAULDRON ||
                    event.getClickedBlock().getType() == Material.TRAPPED_CHEST ||
                    event.getClickedBlock().getType() == Material.FURNACE ||
                    event.getClickedBlock().getType() == Material.DISPENSER) {
                event.setCancelled(true);
            }
        }
    }
}
