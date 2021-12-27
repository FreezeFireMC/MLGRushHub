package de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary;

import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.itemnames.EnglishMLGRushITranslations;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.itemnames.FrenchMLGRushTranslations;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.itemnames.GermanMLGRushTranslations;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) event.setCancelled(true);
        if (event.getAction() == InventoryAction.HOTBAR_SWAP) event.setCancelled(true);
        if (event.getAction() == InventoryAction.CLONE_STACK) event.setCancelled(true);
        if (event.getAction() == InventoryAction.HOTBAR_MOVE_AND_READD) event.setCancelled(true);

        if (event.getInventory().equals(player.getInventory())) {
            event.setCancelled(true);
            return;
        }
        if (event.getInventory().getName().equalsIgnoreCase(GermanMLGRushTranslations.INVNAME.getTranslation()) || event.getInventory().getName().equalsIgnoreCase(EnglishMLGRushITranslations.INVNAME.getTranslation()) || event.getInventory().getName().equalsIgnoreCase(FrenchMLGRushTranslations.INVNAME.getTranslation())) {
        } else {
            event.setCancelled(true);
        }
    }
}
