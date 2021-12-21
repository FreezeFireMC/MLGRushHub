package de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary;

import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.itemnames.EnglishMLGRushITranslations;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.itemnames.FrenchMLGRushTranslations;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.itemnames.GermanMLGRushTranslations;
import de.chaos.mc.server.mlgrushhub.utils.mlgrushinventorylibary.ormlite.UpdateMLGRushInventorySortingInterface;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    private UpdateMLGRushInventorySortingInterface sortingInterface;
    public InventoryClickListener(UpdateMLGRushInventorySortingInterface inventorySortingInterface) {
        this.sortingInterface = inventorySortingInterface;
    }
    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase(GermanMLGRushTranslations.INVNAME.getTranslation()) || event.getInventory().getName().equalsIgnoreCase(EnglishMLGRushITranslations.INVNAME.getTranslation()) || event.getInventory().getName().equalsIgnoreCase(FrenchMLGRushTranslations.INVNAME.getTranslation())) {
        } else {
            event.setCancelled(true);
        }
    }
}
