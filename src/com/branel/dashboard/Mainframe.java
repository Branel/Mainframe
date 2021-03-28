package com.branel.dashboard;

import com.branel.dashboard.commands.CleanupCmd;
import com.branel.dashboard.commands.SpeedCmd;
import com.branel.dashboard.events.PlayerEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Mainframe extends JavaPlugin{
    @Override
    public void onEnable(){
            getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
            getCommand("cleanup").setExecutor(new CleanupCmd());
            getCommand("speed").setExecutor(new SpeedCmd());
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Mainframe]: Enabled");
    }
    @Override
    public void onDisable(){
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Mainframe]: Disabled");
    }
}
