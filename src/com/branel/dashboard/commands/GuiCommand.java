package com.branel.dashboard.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        Player player =  (Player) sender;

        Inventory gui = Bukkit.createInventory(player, 54, "Title");
        ItemStack item1 = new ItemStack(Material.ACACIA_BUTTON);
        ItemMeta item1_meta = item1.getItemMeta();
        item1_meta.setDisplayName("Button");
        item1.setItemMeta(item1_meta);

        gui.addItem(item1);

        player.openInventory(gui);
    return true;
    }
}
