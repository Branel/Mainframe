package com.branel.dashboard.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
        if (cmd.getName().equalsIgnoreCase("City")) {
            player.getInventory().clear(); // Clears inventory of the player using the command!
            World epicgamers = Bukkit.getWorld("2021");
            Location city = new Location(epicgamers, 591, 73.0, -333.0, 2, 2);
            player.teleport(city);
            player.getPlayer().setBedSpawnLocation(city, true);
            sender.sendMessage("You have been teleported to the city");

        }
        if (cmd.getName().equalsIgnoreCase("survivalchallenge"))
        {
            player.getInventory().clear(); // Clears inventory of the player using the command!
            World survivalchallenge = Bukkit.getWorld("100blocks");
            Location challenge = new Location(survivalchallenge, 85, 88.0, 330.0, 2, 2);
            player.teleport(challenge);
            player.getPlayer().setBedSpawnLocation(challenge, true);
            player.setGameMode(GameMode.SURVIVAL);
            sender.sendMessage("You have been teleported to the survival challenge world");
        }return true;
    }

}



