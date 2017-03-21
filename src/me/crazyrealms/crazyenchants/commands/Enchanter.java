package me.crazyrealms.crazyenchants.commands;

import me.crazyrealms.crazyenchants.CrazyEnchants;

import java.util.ArrayList;

import me.crazyrealms.crazyenchants.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Enchanter implements CommandExecutor, Listener {
    
    //Only should be called when the server starts
    public Enchanter() {
        setupGUI();
    }

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
            //If the sender is a player
            Player player = (Player) sender;
            player.openInventory(inventory);


        }
        return true;
    }

    private void setupGUI() {
        //Inventory Items
        ItemStack simple = Utils.createItem(new ItemStack(Material.STAINED_GLASS_PANE,1, (short) 7), ChatColor.WHITE + "Simple Enchant", new String[]{ChatColor.AQUA + "" + ChatColor.BOLD + "COST " + ChatColor.WHITE + "200EXP"});
        ItemStack common = Utils.createItem(new ItemStack(Material.STAINED_GLASS_PANE,1, (short) 5), ChatColor.GREEN + "Common Enchant", new String[]{ChatColor.AQUA + "" + ChatColor.BOLD + "COST " + ChatColor.WHITE + "400EXP"});
        ItemStack rare = Utils.createItem(new ItemStack(Material.STAINED_GLASS_PANE,1, (short) 3), ChatColor.BLUE + "Rare Enchant", new String[]{ChatColor.AQUA + "" + ChatColor.BOLD + "COST " + ChatColor.WHITE + "2000EXP"});
        ItemStack epic = Utils.createItem(new ItemStack(Material.STAINED_GLASS_PANE,1, (short) 4), ChatColor.YELLOW + "Epic Enchant", new String[]{ChatColor.AQUA + "" + ChatColor.BOLD + "COST " + ChatColor.WHITE + "4000EXP"});
        ItemStack legendary = Utils.createItem(new ItemStack(Material.STAINED_GLASS_PANE,1, (short) 1), ChatColor.GOLD + "Legendary Enchant", new String[]{ChatColor.AQUA + "" + ChatColor.BOLD + "COST " + ChatColor.WHITE + "10000EPX"});

        inventory.setItem(2, simple);
        inventory.setItem(3, common);
        inventory.setItem(4, rare)      ;
        inventory.setItem(5, epic);
        inventory.setItem(6, legendary);

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getInventory().equals(inventory)) {
            e.setCancelled(true);
            ItemStack item = e.getCurrentItem();
            Player player = (Player) e.getWhoClicked();
            if(!(item == null || item.getType() == Material.AIR)) {
                //If the player clicked on an actual item. The item MUST be an item frame as it's the only item in the inventory
                short damage = item.getDurability();
                switch(damage) {
                    case 7: //Simple
                        if(player.getTotalExperience() >= 20) {
                            player.setTotalExperience(player.getTotalExperience()-20);
                            player.getInventory().addItem();
                        }
                        break;
                    case 5: //Common
                        break;
                    case 3: //Rare
                        break;
                    case 4: //Epic
                        break;
                    case 1: //Legendary
                        break;
                }
            }

            //TODO: HANDLE INVENTORY CLICK
        }
    }


}
