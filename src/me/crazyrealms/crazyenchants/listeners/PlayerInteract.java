package me.crazyrealms.crazyenchants.listeners;

import me.crazyrealms.crazyenchants.EnchantBook;
import me.crazyrealms.crazyenchants.Utils;
import me.crazyrealms.crazyenchants.enums.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.List;

public class PlayerInteract implements Listener {
    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_AIR || e.getAction() != Action.RIGHT_CLICK_BLOCK || e.getItem() == null || e.getItem().getType() != Material.BOOK)
            return;
        // ^^ Checks if the the player right clicked, and the item is a book
        //TODO: Check if the book's name equals that of a custom enchant book as well as the lore
        ItemStack item = e.getItem();
        if(ChatColor.stripColor(item.getItemMeta().getDisplayName()).split(" ", 2)[1].equalsIgnoreCase("Enchantment Book (Right Click)"))
            if(item.getItemMeta().hasLore()) {
                List<String> lore = item.getItemMeta().getLore();
                if(ChatColor.stripColor(lore.get(0)).equalsIgnoreCase("Right Click to receive a random")) {
                    e.getPlayer().getInventory().remove(e.getItem());
                    e.getPlayer().getInventory().addItem(EnchantBook.getRandomBook(Rarity.valueOf(ChatColor.stripColor(item.getItemMeta().getDisplayName().split(" ")[0]))).getBook());
                    Firework f = e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
                    FireworkMeta meta = f.getFireworkMeta();
                    meta.addEffect(FireworkEffect.builder()
                        .flicker(false)
                        .trail(true)
                        .with(FireworkEffect.Type.BURST)
                        .withColor((Color)Utils.pickRandom(Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW))
                        .withFade((Color)Utils.pickRandom(Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW))
                        .build()
                    );
                }
        } else return;


    }
}
