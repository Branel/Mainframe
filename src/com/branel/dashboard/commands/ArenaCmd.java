package com.branel.dashboard.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
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
        if (cmd.getName().equalsIgnoreCase("Arena")){
            player.getInventory().clear();
            World epicgamers = Bukkit.getWorld("2021");
            Location loc = new Location(epicgamers, 1192, 200.0, 1214.0, -91, 5); // Location of the arena
            Location spec = new Location(epicgamers, 1214, 69, 1213, 0 , 0); // Location of the new spawn location
            player.teleport(loc); // Teleports the user to the arena
            player.getPlayer().setBedSpawnLocation(spec, true); // Sets new spawnlocation for user to reduce loading time upon next execution of the command.

            //Potion effects
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 50, 2, false, false, false)); // Invis, unsure why I added this, might remove
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, 1)); // Increased damage to make the axe a more viable weapon
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 99999, 99)); // Saturation to remove the need for food in the arena


            //Item stack, defining each term so that the server knows what items are being added to the user
            ItemStack Axe = new ItemStack(Material.NETHERITE_AXE);
            ItemStack Chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemStack Leggings = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemStack Boots = new ItemStack(Material.LEATHER_BOOTS);
            ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
            ItemStack Bow = new ItemStack(Material.BOW);
            ItemStack Arrow = new ItemStack(Material.ARROW);
            ItemStack Trident = new ItemStack(Material.TRIDENT);

            // Item Meta
            // Tri = Trident, Chest = Chestplate
            ItemMeta Yxa = Axe.getItemMeta();
            LeatherArmorMeta Chest = (LeatherArmorMeta)Chestplate.getItemMeta();
            LeatherArmorMeta Leg = (LeatherArmorMeta)Leggings.getItemMeta();
            LeatherArmorMeta Boot = (LeatherArmorMeta)Boots.getItemMeta();
            LeatherArmorMeta Head = (LeatherArmorMeta)Helmet.getItemMeta();
            ItemMeta Tri = Trident.getItemMeta();
            ItemMeta Longbow = Bow.getItemMeta();

            //Leather color, self expl


            Chest.setColor(Color.fromRGB(0, 0, 0));
            Leg.setColor(Color.fromRGB(0, 0, 0));
            Head.setColor(Color.fromRGB(0, 0, 0));
            Boot.setColor(Color.fromRGB(0, 0, 0));


            // Meta Flag. Hide all attri. and ench. to prevent distractions and prevent users from knowing the ench.
            Yxa.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Yxa.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            Chest.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Chest.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            Leg.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Leg.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            Boot.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Boot.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            Head.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Head.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            Longbow.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Longbow.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            Tri.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Tri.addItemFlags(ItemFlag.HIDE_ENCHANTS);




            // Unbreakable items, prevents it being a meta around durabillity
            Yxa.setUnbreakable(true);
            Chest.setUnbreakable(true);
            Leg.setUnbreakable(true);
            Boot.setUnbreakable(true);
            Head.setUnbreakable(true);
            Longbow.setUnbreakable(true);
            Tri.setUnbreakable(true);

            // Meta Display Name
            Tri.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "TRIDENT");
            Yxa.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "AXE");
            Longbow.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "BOW");

            // Set ItemMeta
            Axe.setItemMeta(Yxa);
            Chestplate.setItemMeta(Chest);
            Leggings.setItemMeta(Leg);
            Boots.setItemMeta(Boot);
            Helmet.setItemMeta(Head);
            Trident.setItemMeta(Tri);
            Bow.setItemMeta(Longbow);

            // Enchantments
            Trident.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            Bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
            Bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
            Helmet.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            Boots.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            Boots.addEnchantment(Enchantment.PROTECTION_FALL, 4);
            Leggings.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            Chestplate.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            Axe.addEnchantment(Enchantment.VANISHING_CURSE, 1);
            Bow.addEnchantment(Enchantment.VANISHING_CURSE, 1);

            //Add items
            player.getInventory().addItem(Bow);
            player.getInventory().addItem(Axe);
            player.getInventory().addItem(Trident);
            player.getInventory().setLeggings(Leggings);
            player.getInventory().setChestplate(Chestplate);
            player.getInventory().setBoots(Boots);
            player.getInventory().setHelmet(Helmet);
            player.getInventory().addItem(Arrow);

            // Set walking speed, adventure, health, and message.
            player.setWalkSpeed(0.2f);
            sender.sendMessage("You have been teleported to the Arena.");
            player.setGameMode(GameMode.ADVENTURE);
            player.setHealth(20);
            return true;
        }

        return true;
    }
}




