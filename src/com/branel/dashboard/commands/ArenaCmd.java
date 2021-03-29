package com.branel.dashboard.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArenaCmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (!(sender instanceof Player)){
            sender.sendMessage( "Fail");
            return true;
        }
        Player player = (Player) sender;
// Will destroy all items on the ground
        if (cmd.getName().equalsIgnoreCase("Arena")){
            World epicgamers = Bukkit.getWorld("epicgamers");
            Location loc = new Location(epicgamers, -29.0, 76.0, -313.0, -91, 5);
            player.teleport(loc);
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 50, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 50, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 99999, 99));
            ItemStack Weapons = new ItemStack(Material.NETHERITE_AXE);
            ItemStack Chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemStack Leggings = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemStack Boots = new ItemStack(Material.LEATHER_BOOTS);
            ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
            ItemStack bow = new ItemStack(Material.BOW);
            ItemStack arrow = new ItemStack(Material.ARROW);
            bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
            bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
            Helmet.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            Boots.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            Leggings.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            Chestplate.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            Weapons.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            bow.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            player.getInventory().addItem(bow);
            player.getInventory().addItem(Weapons);
            player.getInventory().setLeggings(Leggings);
            player.getInventory().setChestplate(Chestplate);
            player.getInventory().setBoots(Boots);
            player.getInventory().setHelmet(Helmet);
            player.getInventory().addItem(arrow);
            player.setWalkSpeed(0.2f);
            sender.sendMessage("You have been teleported to the Arena.");
            return true;
        }

        return true;}}


