package com.branel.dashboard.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CleanupCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (!(sender instanceof Player)){
            sender.sendMessage( "Fail");
            return true;
        }
        Player player = (Player) sender;
// Will destroy all items on the ground
        if (cmd.getName().equalsIgnoreCase("cleanup")){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kill @e[type=item]");
            Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Successfully deleted all items on the ground.");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("plague")){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kill@e");
            Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Killed all mobs.");
            return true;
        }
    return true;}}
