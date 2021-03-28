package com.branel.dashboard.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (!(sender instanceof Player)){
            sender.sendMessage( "Fail");
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("speed")){
            player.setFlySpeed(1.0f);
            player.sendMessage(ChatColor.GREEN + "Speed was set to 1");
            return true;
        }return true;}}


