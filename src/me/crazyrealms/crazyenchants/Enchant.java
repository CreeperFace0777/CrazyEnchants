package me.crazyrealms.crazyenchants;


import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.List;

//Each of the plugins enchants will extend this class
public abstract class Enchant {

    //A list of all enchants in the game (mainly for looping through)
    public static List<Enchant> enchants = new ArrayList<Enchant>();

    public String name; //Enchants name
    public int maxLevel; //Enchant max level
    public Rarity rarity; //The enchants rarity
    public ItemSet[] itemSet; //Items the enchant can be applied to
    public String description; //What the enchant does

    //Runs for new enchants
    public Enchant(String name, int maxLevel, Rarity rarity, ItemSet[] itemSet, String description) {
        //Sets variables
        this.name = name;
        this.maxLevel = maxLevel;
        this.rarity = rarity;
        this.itemSet = itemSet;
        this.description = description;
        //Adds the enchant to the enchants list
        enchants.add(this);
    }

    //Events (These will not be registered in the enchant, but will be registered in a seperate class. When the enchant is found, the method will be called from here):

    //If player is hit with a projectile/melee combat
    public void playerHitEvent (EntityDamageByEntityEvent e) {}

    //If the enchant is a tool enchant (block broken)
    public void playerBreakBlockEvent(BlockBreakEvent e) {}

    //Getters
    public String getName() {
        return name;
    }
    public int getMaxLevel() {
        return maxLevel;
    }
    public Rarity getRarity() {
        return rarity;
    }
    public ItemSet[] getItemSet() {
        return itemSet;
    }
    public String getDescription() {
        return description;
    }

}
