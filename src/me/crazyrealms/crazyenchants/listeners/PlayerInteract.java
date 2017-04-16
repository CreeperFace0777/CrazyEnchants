package me.crazyrealms.crazyenchants.listeners;

import me.crazyrealms.crazyenchants.CrazyEnchants;
import me.crazyrealms.crazyenchants.EnchantBook;
import me.crazyrealms.crazyenchants.Utils;
import me.crazyrealms.crazyenchants.enums.Rarity;
import org.bukkit.*;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerInteract implements Listener {
    Map<Player, Boolean> playerMap = new HashMap<>();
    CrazyEnchants plugin;

    public PlayerInteract(CrazyEnchants plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent e) {
<<<<<<< HEAD
        if (e.getItem() == null && e.getItem().getType() != Material.BOOK)
            return;
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            // ^^ Checks if the the player right clicked, and the item is a book
            //TODO: Check if the book's name equals that of a custom enchant book as well as the lore
            ItemStack item = e.getItem();
            if (ChatColor.stripColor(item.getItemMeta().getDisplayName()).split(" ", 2)[1].equalsIgnoreCase("Enchantment Book (Right Click)"))

                if (item.getItemMeta().hasLore()) {

                    List<String> lore = item.getItemMeta().getLore();
                    if (ChatColor.stripColor(lore.get(0)).equalsIgnoreCase("Right Click to receive a random")) {

                        item.setAmount(item.getAmount() - 1);
                        e.getPlayer().getInventory().addItem(EnchantBook.getRandomBook(Rarity.valueOf(ChatColor.stripColor(item.getItemMeta().getDisplayName().split(" ")[0]).toUpperCase())).getBook());
                        Firework f = e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
                        FireworkMeta meta = f.getFireworkMeta();
                        meta.addEffect(FireworkEffect.builder()
                            .flicker(false)
                            .trail(true)
                            .with(FireworkEffect.Type.BURST)
                            .withColor((Color) Utils.pickRandom(Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW))
                            .withFade((Color) Utils.pickRandom(Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW))
                            .build()
                        );
                        f.setFireworkMeta(meta);
                    }
                } else return;
=======
        if (playerMap.get(e.getPlayer()) == null || playerMap.get(e.getPlayer()) == false) {
            if(playerMap.containsKey(e.getPlayer())) playerMap.replace(e.getPlayer(), true);
            else playerMap.put(e.getPlayer(), true);
            if (e.getItem() == null || e.getItem().getType() != Material.BOOK)
                return;
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                // ^^ Checks if the the player right clicked, and the item is a book
                //TODO: Check if the book's name equals that of a custom enchant book as well as the lore
                ItemStack item = e.getItem();
                if (ChatColor.stripColor(item.getItemMeta().getDisplayName()).split(" ", 2)[1].equalsIgnoreCase("Enchantment Book (Right Click)"))

                    if (item.getItemMeta().hasLore()) {
                        List<String> lore = item.getItemMeta().getLore();
                        if (ChatColor.stripColor(lore.get(0)).equalsIgnoreCase("Right Click to receive a random")) {
                            e.getPlayer().getInventory().addItem(EnchantBook.getRandomBook(Rarity.valueOf(ChatColor.stripColor(item.getItemMeta().getDisplayName().split(" ")[0]).toUpperCase())).getBook());
                            Rarity rarity = Rarity.fromString(ChatColor.stripColor(item.getItemMeta().getDisplayName().split(" ")[0]));
                            ItemMeta itemm = item.getItemMeta();
                            itemm.setDisplayName("Remove");
                            item.setItemMeta(itemm);

                            if(item.getAmount() == 1) {
                                e.getPlayer().getInventory().remove(item);
                            } else {
                                item.setAmount(item.getAmount() - 1);
                                itemm.setDisplayName(ChatColor.RESET + "" + rarity.getRarityColor() + Utils.camelCase(rarity.toString()) + " Enchantment Book " + ChatColor.GRAY + "(Right Click)");
                                item.setItemMeta(itemm);
                            }

                            Firework f = e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
                            FireworkMeta meta = f.getFireworkMeta();
                            meta.addEffect(FireworkEffect.builder()
                                .flicker(false)
                                .trail(true)
                                .with(FireworkEffect.Type.BURST)
                                .withColor((Color) Utils.pickRandom(Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW))
                                .withFade((Color) Utils.pickRandom(Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW))
                                .build()
                            );
                            f.setFireworkMeta(meta);
                        }
                    } else return;
>>>>>>> creeperbranch

            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new BukkitRunnable() {
                @Override
                public void run() {
                    playerMap.replace(e.getPlayer(), false);
                }
            }, 10);
        } else {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new BukkitRunnable() {
                @Override
                public void run() {
                    playerMap.replace(e.getPlayer(), false);
                }
            }, 10);
        }

    }
}

