package com.branel.dashboard.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (!(sender instanceof Player)){
            sender.sendMessage( "Fail");
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("City")){
            player.getInventory().clear();
            World epicgamers = Bukkit.getWorld("2021");
            Location city = new Location(epicgamers, 591, 73.0, -333.0, 2, 2);
            player.teleport(city);
            player.getPlayer().setBedSpawnLocation(city, true);
            sender.sendMessage("You have been teleported to the city");
        }return true;}}
