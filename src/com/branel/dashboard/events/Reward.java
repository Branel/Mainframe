package com.branel.dashboard.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class Reward implements Listener {

    @EventHandler
    public void onDeathChat(PlayerDeathEvent e){
        if(e.getEntity().getKiller()!=null && e.getEntity().getKiller() instanceof Player){
            Player killer = e.getEntity().getKiller();
            ItemStack reward = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
            killer.getInventory().addItem(reward);
            killer.getPlayer().sendMessage("You have been rewarded a Golden Apple.");
                    }
                }
            }

