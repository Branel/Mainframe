package com.branel.dashboard;

import com.branel.dashboard.commands.*;
import com.branel.dashboard.events.FallDamage;
import com.branel.dashboard.events.PlayerEvents;
import com.branel.dashboard.events.Reward;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Mainframe extends JavaPlugin{
    @Override
    public void onEnable(){
            getServer().getPluginManager().registerEvents(new FallDamage(),this);
            getServer().getPluginManager().registerEvents(new Reward(),this);
            getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
            getServer().getPluginManager().registerEvents(new Gui(), this);
            getCommand("gui").setExecutor(new GuiCommand());
            getCommand("cleanup").setExecutor(new CleanupCmd());
            getCommand("walkspeed").setExecutor(new SpeedCmd());
            getCommand("flyspeed").setExecutor(new SpeedCmd());
            getCommand("kick").setExecutor(new Kick());
            getCommand("arena").setExecutor(new ArenaCmd());
            getCommand("pvpkit").setExecutor(new PvPKit());
            getCommand("city").setExecutor(new Teleport());
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Mainframe]: Enabled");
    }
    @Override
    public void onDisable(){
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Mainframe]: Disabled");
    }
}
