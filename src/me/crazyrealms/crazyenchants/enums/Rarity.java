package me.crazyrealms.crazyenchants.enums;

import org.bukkit.ChatColor;

//Chance of an enchant appearing when you open a book.
public enum Rarity {
    SIMPLE(ChatColor.GRAY), COMMON(ChatColor.YELLOW), RARE(ChatColor.DARK_AQUA), EPIC(ChatColor.DARK_PURPLE), LEGENDARY(ChatColor.GOLD);

    ChatColor rarityColor;

    Rarity(ChatColor rarityColor) {
        this.rarityColor = rarityColor;
    }

    public ChatColor getRarityColor() {
        return rarityColor;
    }

}
