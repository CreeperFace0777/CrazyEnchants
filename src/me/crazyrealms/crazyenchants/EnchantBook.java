package me.crazyrealms.crazyenchants;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

//The actual book the player has
public class EnchantBook {

    ItemStack book = new ItemStack(Material.BOOK);
    int level; //The level of the enchant
    Enchant enchant; //The enchant on the book
    double success; //The success percentage
    double destroy; //The destroy percentage


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

    public double getSuccess() {
        return success;
    }

    public double getDestroy() {
        return destroy;
    }
}
