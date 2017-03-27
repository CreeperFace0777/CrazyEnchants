package me.crazyrealms.crazyenchants.enums;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

//Possible items an enchant can be enchanted on
public enum ItemSet {
    HELMET(Material.LEATHER_HELMET, Material.IRON_HELMET, Material.CHAINMAIL_HELMET, Material.GOLD_HELMET, Material.DIAMOND_HELMET),
    CHESTPLATE(Material.LEATHER_CHESTPLATE, Material.IRON_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.DIAMOND_CHESTPLATE),
    LEGGINGS(Material.LEATHER_LEGGINGS, Material.IRON_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.GOLD_LEGGINGS, Material.DIAMOND_LEGGINGS),
    BOOTS(Material.LEATHER_BOOTS, Material.IRON_BOOTS, Material.CHAINMAIL_BOOTS, Material.GOLD_BOOTS, Material.DIAMOND_BOOTS),
    SWORD(Material.WOOD_SWORD, Material.IRON_SWORD, Material.STONE_SWORD, Material.GOLD_SWORD, Material.DIAMOND_SWORD),
    BOW(Material.BOW),
    PICKAXE(Material.WOOD_PICKAXE, Material.IRON_PICKAXE, Material.STONE_PICKAXE, Material.GOLD_PICKAXE, Material.DIAMOND_PICKAXE),
    SHOVEL(Material.WOOD_SPADE, Material.IRON_SPADE, Material.STONE_SPADE, Material.GOLD_SPADE, Material.DIAMOND_SPADE),
    AXE(Material.WOOD_AXE, Material.IRON_AXE, Material.STONE_AXE, Material.GOLD_AXE, Material.DIAMOND_AXE),
    HOE(Material.WOOD_HOE, Material.IRON_HOE, Material.STONE_HOE, Material.GOLD_HOE, Material.DIAMOND_HOE),
    ALL_TOOL(ItemSet.PICKAXE, ItemSet.SHOVEL, ItemSet.AXE, ItemSet.HOE),
    ALL_ARMOUR(ItemSet.HELMET, ItemSet.CHESTPLATE, ItemSet.LEGGINGS, ItemSet.BOOTS),
    ALL_WEAPON(ItemSet.SWORD, ItemSet.AXE);


    private List<Material> items = new ArrayList<>();

    ItemSet(Material... itemss) {
        for (Material item : itemss) {
            items.add(item);
        }
    }

    ItemSet(ItemSet... it) {
        for (ItemSet i : it) {
            items.addAll(i.getItems());
        }
    }

    public List<Material> getItems() {
        return items;
    }
}
