package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.Player;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Haste extends Enchant {

	public Haste() {
		super("Haste", 3, Rarity.SIMPLE, new ItemSet[]{ItemSet.ALL_TOOLS}, "Gives the haste effect to the player", 100, true);
	}
	
	@Override
	public void alwaysActive(Player player) {
		// TODO Auto-generated method stub
		super.alwaysActive(player);
	}
	
}
