package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.Player;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customevents.PlayerAttackedEntity;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Regain extends Enchant {

	public Regain() {
		super("Regain", 4, Rarity.SIMPLE, new ItemSet[]{ItemSet.AXE}, "Chance to gain hunger when you attack a player", 10, 5);
	}
	
	@Override
	public void playerAttackedEntity(PlayerAttackedEntity e) {
		Player pl = e.getPlayerAttacker();
		
		if (pl.getFoodLevel()+1 >= 20) { //More than "20" would return InvalidArgumentException
			pl.setFoodLevel(20);
		} else {
			pl.setFoodLevel(pl.getFoodLevel()+1);
		}
	}
}
