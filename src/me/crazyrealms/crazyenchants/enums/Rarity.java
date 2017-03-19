package me.crazyrealms.crazyenchants.enums;

import org.bukkit.ChatColor;

//Chance of an enchant appearing when you open a book.
public enum Rarity {
    SIMPLE(ChatColor.GRAY), COMMON(ChatColor.GREEN), RARE(ChatColor.YELLOW), EPIC(ChatColor.DARK_PURPLE), LEGENDARY(ChatColor.GOLD);

    ChatColor rarityColor;

    Rarity(ChatColor rarityColor) {
        this.rarityColor = rarityColor;
    }

    public ChatColor getRarityColor() {
        return rarityColor;
    }

}
