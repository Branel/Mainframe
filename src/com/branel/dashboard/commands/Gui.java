package com.branel.dashboard.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Gui implements Listener {


    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Title")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            return;}
            else if (e.getCurrentItem().getType().equals(Material.ACACIA_BUTTON)) {
                player.sendMessage("Button");
                player.closeInventory();
            }else if (e.getCurrentItem().getType().equals((Material.CACTUS))) {
                player.sendMessage("Cactus");
                player.closeInventory();
            }
        }
    }
}
