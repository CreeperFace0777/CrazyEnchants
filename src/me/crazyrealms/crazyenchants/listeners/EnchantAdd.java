package me.crazyrealms.crazyenchants.listeners;

import me.crazyrealms.crazyenchants.CrazyEnchants;
import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.EnchantBook;
import me.crazyrealms.crazyenchants.Utils;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class EnchantAdd implements Listener {

    Map<Player, Boolean> hasClicked = new HashMap<>();
    Map<Player, ItemStack> oldItem = new HashMap<>();

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory().equals(player.getInventory())) {
            //We know that the inventory is the players
            if (hasClicked.get(player) != null && hasClicked.get(player) == true) {
                hasClicked.replace(player, false);
                final ItemStack item = oldItem.get(player);
                oldItem.remove(player);
                Enchant enchant = Enchant.getEnchantByName(ChatColor.stripColor(item.getItemMeta().getDisplayName().split(" ")[0]));
                if (enchant != null) {
                    for (ItemSet i : enchant.getItemSet())
                        for (Material m : i.getItems())
                            if (e.getCurrentItem().getType() == m) {
                                //If the item can be enchanted with the enchant the player just clicked it with
                                List<String> lore = e.getCurrentItem().getItemMeta().getLore();
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
                                            player.sendMessage(CrazyEnchants.getPrefix() + "You have too many enchants on this item!");
                                            return;
                                        }
                                    }


                                } else lore = new ArrayList<>();
                                EnchantBook enchBook = EnchantBook.getEnchantBook(item);
                                //Add the enchant to item if the success is done.
                                if(enchBook.getSuccess() == 100 || enchBook.getSuccess() >= new Random().nextInt(100)) {
                                    List<String> lorea;
                                    if (e.getCurrentItem().getItemMeta().hasLore()) lorea = e.getCurrentItem().getItemMeta().getLore();
                                    else lorea = new ArrayList<>();
                                    lorea.add(enchBook.getEnchant().getRarity().getRarityColor() + enchBook.getEnchant().getName() + " " + Utils.intToRomanNumeral(enchBook.getLevel()));
                                    ItemMeta meta = e.getCurrentItem().getItemMeta();
                                    meta.setLore(lorea);
                                    e.getCurrentItem().setItemMeta(meta);
                                    net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(e.getCurrentItem());
                                    NBTTagCompound tag = null;
                                    if (!nmsStack.hasTag()) {
                                        tag = new NBTTagCompound();
                                        nmsStack.setTag(tag);
                                    }
                                    if (tag == null) tag = nmsStack.getTag();
                                    NBTTagList ench = new NBTTagList();
                                    tag.set("ench", ench);
                                    nmsStack.setTag(tag);
                                    e.setCurrentItem( CraftItemStack.asCraftMirror(nmsStack));
                                    e.getWhoClicked().getInventory().remove(item);
                                    e.getWhoClicked().sendMessage(CrazyEnchants.getPrefix() + "Added the enchant to the item");
                                    return;
                                } else if(enchBook.getDestroy() == 100 || enchBook.getDestroy() >= new Random().nextInt(100)) {
                                    e.getWhoClicked().getInventory().remove(e.getCurrentItem());
                                    e.getWhoClicked().getInventory().remove(item);
                                    e.getWhoClicked().sendMessage(CrazyEnchants.getPrefix() + "Your item was destroyed");
                                } else {
                                    e.getWhoClicked().getInventory().remove(item);
                                }
                            }

                }
                //TODO: Add compatibility for whitescroll
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

//
//    @EventHandler
//    public void playerDragItemEvent(InventoryDragEvent e) {
//        if (!(e.getInventory().getHolder() instanceof Player)) return;
//        Player player = (Player) e.getInventory().getHolder();
//        if (e.getInventory() == player.getInventory()) {
//            ItemStack book = e.getOldCursor(); //The enchant book*
//            ItemStack item = e.getCursor(); //The item to add enchants to
//            if(book != null || item != null) {
//                EnchantBook enchantBook = EnchantBook.getEnchantBook(book); //Test to see if the item dragged was a enchant book
//                if (enchantBook != null) {
//                    Enchant enchant = enchantBook.getEnchant();
//                    for (ItemSet it : enchant.getItemSet())
//                        for (Material m : it.getItems()) {
//                            if (item.getType().equals(m)) {
//                                //If the item they clicked on can be enchanted
//                                List<String> lore = item.getItemMeta().getLore();
//                                if (lore != null) {
//                                    boolean permFinding = true;
//                                    int current = 0;
//                                    //Find how many enchants can be on one item for that player;
//                                    while (permFinding) {
//                                        if (player.hasPermission("crazyenchants.lore." + current)) {
//                                            permFinding = false;
//                                        } else current++;
//                                    }
//                                    //Current is now equal to the max amount of enchants that player is allowed on one item.
//                                    if (lore.size() >= current) {
//                                        if (isMax(lore, current)) {
//                                            player.closeInventory();
//                                            player.sendMessage(CrazyEnchants.getPrefix() + "You have to many enchants on this item!");
//                                            return;
//                                        }
//                                    }
//
//                                    lore = item.getItemMeta().getLore();
//
//                                }
//                                EnchantBook enchBook = EnchantBook.getEnchantBook(item);
//                                //Add the enchant to item if the success is done.
//                                if(enchBook.getSuccess() == 100 || enchBook.getSuccess() >= new Random().nextInt(100)) {
//                                    List<String> lorea;
//                                    if (item.getItemMeta().hasLore()) lorea = item.getItemMeta().getLore();
//                                    else lorea = new ArrayList<>();
//                                    lorea.add(enchBook.getEnchant().getRarity().getRarityColor() + enchBook.getEnchant().getName() + " " + Utils.intToRomanNumeral(enchBook.getLevel()));
//                                    item.getItemMeta().setLore(lorea);
//                                    for(ItemStack i : e.getWhoClicked().getInventory().getContents()) {
//                                        if(i.equals(book)) {
//                                            ItemMeta im = i.getItemMeta();
//                                            List<String> newLore = new ArrayList<>();
//                                            newLore.add("Remove Item");
//                                            im.setLore(newLore);
//                                            im.setDisplayName("Remove Item");
//                                            i.setItemMeta(im);
//                                            e.getWhoClicked().getInventory().remove(i);
//                                        }
//                                    }
//                                    e.getWhoClicked().getInventory().remove(book);
//                                    e.getWhoClicked().sendMessage(CrazyEnchants.getPrefix() + "Added the enchant to the item");
//                                    return;
//                                } else if(enchBook.getDestroy() == 100 || enchBook.getDestroy() >= new Random().nextInt(100)) {
//                                    e.getWhoClicked().getInventory().remove(item);
//                                    e.getWhoClicked().getInventory().remove(book);
//                                    e.getWhoClicked().sendMessage(CrazyEnchants.getPrefix() + "Your item was destroyed");
//                                }
//                            }
//                        }
//
//                }
//            }
//
//        }
//    }

}
