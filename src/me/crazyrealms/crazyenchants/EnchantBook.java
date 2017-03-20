package me.crazyrealms.crazyenchants;


import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//The actual book the player has
public class EnchantBook {

    private ItemStack book = new ItemStack(Material.BOOK);
    private ItemMeta meta = book.getItemMeta();
    private int level; //The level of the enchant
    private Enchant enchant; //The enchant on the book
    private int success; //The success percentage
    private int destroy; //The destroy percentage

    public EnchantBook(int level, Enchant enchant, int success, int destroy) {
        this.level = level;
        this.enchant = enchant;
        this.success = success;
        this.destroy = destroy;

        //Make the item using the following variables (Reference Image: http://prntscr.com/elt45o)
        meta.setDisplayName(ChatColor.RESET + "" + enchant.getRarity().getRarityColor() + "" + ChatColor.UNDERLINE + enchant.getName() + " " + Utils.intToRomanNumeral(level));
        List<String> lore = new ArrayList<>();
        lore.set(0, ChatColor.GREEN + "" + success + "% Success Rate");
        lore.set(1, ChatColor.RED + "" + destroy + "% Destroy Rate");
        //Format the description so that it doesn't go off page
        lore.addAll(Utils.loreLineFormat(enchant.getDescription(), ChatColor.YELLOW));
        //If the enchant can go on more than 1 thing
        if(enchant.getItemSet().length > 1) {
            String items = "";
            //Add all the items the enchant can be added to, to one string seperated with a ','
            for(int i = 0; i < enchant.getItemSet().length; i++) {
                items = items + enchant.getItemSet()[i].toString() + ", ";
            } //If there is a ', ' at the end then remove it
            if(items.endsWith(", ")) {
                items = items.substring(0,items.length()-2);
            }
            //Turn the first enum from all caps to first letter capital
            lore.add(ChatColor.GRAY + Utils.camelCase(items.toString()) + " Enchantment");
        } else {
            //Turn the enum from all caps to first letter capital
            lore.add(ChatColor.GRAY + Utils.camelCase(enchant.getItemSet()[0].toString()) + " Enchantment");
        }

        lore.add(ChatColor.DARK_AQUA + "Max Level: " + ChatColor.YELLOW + enchant.getMaxLevel());
    }

    public static EnchantBook getRandomBook(Rarity rarity) {
        Enchant e = (Enchant) Utils.pickRandom(Enchant.enchants);
        if(e.getRarity() != rarity) getRandomBook(rarity);
        return new EnchantBook(new Random().nextInt(e.getMaxLevel())+1, e, new Random().nextInt(100)+1,new Random().nextInt(100)+1);
    }


    //GETTERS
    public ItemStack getBook() {
        return book;
    }

    public int getLevel() {
        return level;
    }

    public Enchant getEnchant() {
        return enchant;
    }

    public int getSuccess() {
        return success;
    }

    public int getDestroy() {
        return destroy;
    }
}
