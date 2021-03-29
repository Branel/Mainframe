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
        if (cmd.getName().equalsIgnoreCase("flyspeed")){
            if (args.length >= 1){
                try {
                    float amount = Float.parseFloat(args[0]);
                    float speed = amount / 100;
                        player.setFlySpeed(speed);
                        player.sendMessage(ChatColor.GREEN + "Flyspeed was set to " + amount);
                    // Takes user input 0-100, converts it from a string to a float, divides it by 100 [because function only accepts 0 - 1.0 values].
                }
                catch (IllegalArgumentException e) {
                    player.sendMessage(ChatColor.RED + "Invalid input! /flyspeed 0 - 100.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid input! /flyspeed 0 - 100.");}

            }
        if (cmd.getName().equalsIgnoreCase("walkspeed")){
            if (args.length >= 1){
                try {
                    float input = Float.parseFloat(args[0]);
                    float walkspeed = input / 100;
                        player.setWalkSpeed(walkspeed);
                        player.sendMessage(ChatColor.GREEN + "Walkspeed was set to " + input);
                }
                catch (IllegalArgumentException e) {
                    player.sendMessage(ChatColor.RED + "Invalid input! /walkspeed 0 - 100.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid input! /walkspeed 0 - 100.");}

        }
        return true;}

        }


