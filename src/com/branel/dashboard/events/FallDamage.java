package com.branel.dashboard.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FallDamage implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            Player p = (Player) event.getEntity();

            if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
                event.setCancelled(true);
            }
            if(p.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL){
                event.setCancelled(true);
            }
        }
    }
}