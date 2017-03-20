package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Blast extends Enchant {

	public Blast() {
		super("Blast", 3, Rarity.EPIC, new ItemSet[]{ItemSet.PICKAXE, ItemSet.SHOVEL}, "When mining, you will destroy in a radius of blocks increasing by each level", 100, false);
	}
	
}
