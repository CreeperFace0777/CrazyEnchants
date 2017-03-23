package me.crazyrealms.crazyenchants.listeners;

import me.crazyrealms.crazyenchants.CrazyEnchants;
import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.EnchantBook;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnchantAdd implements Listener {
    Map<Player, Boolean> hasClicked = new HashMap<>();
    Map<Player, ItemStack> oldItem = new HashMap<>();

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        if (!(e.getInventory().getHolder() instanceof Player)) return;
        Player player = (Player) e.getInventory().getHolder();
        if (e.getInventory() == player.getInventory()) {
            //We know that the inventory is the players
            if (hasClicked.get(player) != null && hasClicked.get(player) == true) {
                hasClicked.replace(player, false);
                ItemStack item = oldItem.get(player);
                oldItem.remove(player);
                Enchant enchant = Enchant.getEnchantByName(ChatColor.stripColor(item.getItemMeta().getDisplayName().split(" ")[0]));
                if (enchant != null) {
                    for (ItemSet i : enchant.getItemSet())
                        for (Material m : i.getItems())
                            if (e.getCurrentItem().getType() == m) {
                                //If the item can be enchanted with the enchant the player just clicked it with
                                List<String> lore = null;
                                if (e.getCurrentItem().getItemMeta().getLore() != null) {
                                    boolean permFinding = true;
                                    int current = 0;
                                    //Find how many enchants can be on one item for that player;
                                    while (permFinding) {
                                        if (player.hasPermission("crazyenchants.lore." + current)) {
                                            permFinding = false;
                                        } else current++;
                                    }
                                    //Current is now equal to the max amount of enchants that player is allowed on one item.
                                    if (lore.size() >= current) {
                                        if (isMax(lore, current)) {
                                            player.closeInventory();
                                            player.sendMessage(CrazyEnchants.getPrefix() + "You have to many enchants on this item!");
                                            return;
                                        }
                                    }

                                    lore = e.getCurrentItem().getItemMeta().getLore();

                                } else lore = new ArrayList<>();
                                EnchantBook enchBook = EnchantBook.getEnchantBook(item);
                                //Add the enchant to item if the success is done.
                                if(enchBook.getSuccess() == 100) {
                                    //TODO ADD LORE TO ITEM
                                }


                            }

                }
                //TODO: if the player presses an itemstack that an enchant can be applied to, add the enchant
            } else {
                if (e.getCurrentItem().getType() == Material.BOOK)
                    oldItem.put(player, e.getCurrentItem());
                hasClicked.put(player, true);

            }
        }

    }

    @EventHandler
    public void closeInventory(InventoryCloseEvent e) {
        if (e.getPlayer() instanceof Player)
            if (hasClicked.get(e.getPlayer()) != null)
                if (hasClicked.get(e.getPlayer()) == true)
                    hasClicked.replace((Player) e.getPlayer(), false);
    }

    private boolean isMax(List<String> checkLore, int max) {

        //TODO: Check if the players lore is maxed out
        return false;
    }

}
