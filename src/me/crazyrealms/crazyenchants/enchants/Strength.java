package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customevents.PlayerAttackedEntity;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Strength extends Enchant {

	public Strength() {
		super("Strength", 3, Rarity.LEGENDARY, new ItemSet[]{ItemSet.ALL_ARMOUR}, "Chance to do more damage", 3, 3);
	}
	
	@Override
	public void playerAttackedEntity(PlayerAttackedEntity e) {
		e.setDamage(e.getDamage() * 1.5);
	}
}
