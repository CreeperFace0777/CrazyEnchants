package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Savior extends Enchant {

	public Savior() {
		super("Savior", 4, Rarity.LEGENDARY, new ItemSet[]{ItemSet.HELMET}, "Chance to heal when low on health", 20, false);
	}
	
}
