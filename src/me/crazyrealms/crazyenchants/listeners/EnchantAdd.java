package me.crazyrealms.crazyenchants.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.HashMap;
import java.util.Map;

public class EnchantAdd implements Listener {
    Map<Player, Boolean> hasClicked = new HashMap<>();

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        if (!(e.getInventory().getHolder() instanceof Player)) return;
        Player player = (Player) e.getInventory().getHolder();
        if (e.getInventory() == player.getInventory()) {
            //We know that the inventory is the players
            if (hasClicked.get(player) != null || hasClicked.get(player) == true) {
                //TODO: if the player presses an itemstack that an enchant can be applied to, add the enchant
            } else {
                if (e.getCurrentItem().getType() == Material.BOOK)
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
}
