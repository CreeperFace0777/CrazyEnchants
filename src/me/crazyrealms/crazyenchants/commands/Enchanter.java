package me.crazyrealms.crazyenchants.commands;

import me.crazyrealms.crazyenchants.CrazyEnchants;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Enchanter implements CommandExecutor {
    //The /enchanter GUI
    private Inventory inventory = Bukkit.createInventory(null, 9 , "Enchanter");
    //Plugin prefix
    private String prefix = CrazyEnchants.getPrefix();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("enchanter")) {
            //Check if the sender is a player
            if(!(sender instanceof Player)) {
                sender.sendMessage(prefix + "You must be a player to do this.");
                return true;
            }
            //IF THEY ARE
            Player player = (Player) sender;


        }
        return true;
    }

    private void setupGUI() {
        //Inventory Items
        ItemStack simple = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        ItemStack common = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
        ItemStack epic = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
        ItemStack rare = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
        ItemStack legendary = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);



    }
    
    //Used instead of setting each item's meta/name separately
    private ItemStack createItem(ItemStack inputStack, String customName, String[] lore) {
    	ItemMeta itemMeta = inputStack.getItemMeta();
    	if (customName != null) {
    		itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', customName));
    	}
    	if (lore != null) {
    		ArrayList<String> newLore = new ArrayList<String>();
    		for (String loreLine : lore) {
    			newLore.add(ChatColor.translateAlternateColorCodes('&', loreLine));
    		}
    		itemMeta.setLore(newLore);
    	}
    	inputStack.setItemMeta(itemMeta);
    	return inputStack;
    }


}
