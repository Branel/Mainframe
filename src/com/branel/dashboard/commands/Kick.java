package com.branel.dashboard.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Fail");
            return true;
        }
        Player player = (Player) commandSender;
        if (command.getName().equalsIgnoreCase("kick")){
            if (strings.length >= 2){
                try{
                    float reason = Float.parseFloat(strings[0]);
                    player.kickPlayer("You have been kicked for: " + reason);
                }
                catch (IllegalArgumentException e){
                    player.sendMessage(ChatColor.RED + "Invalid Input!"
                    );
                }

            }
        }
    return true;
    }
}
