package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.customevents.PlayerAttackedEntity;
import org.bukkit.entity.Player;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class LifeSaver extends Enchant {

	public LifeSaver() {
		super("Life Saver", 5, Rarity.LEGENDARY, new ItemSet[]{ItemSet.SWORD}, "Chance to give your enemies' health to you", 1, 1);
	}
	
	@Override
	public void playerAttackedEntity(PlayerAttackedEntity e) {
		if (!(e.getAttackedEntity() instanceof Player)) return;

		Player damager = e.getPlayerAttacker();
		Player entity = (Player) e.getAttackedEntity();
		
		if (damager.getHealth() < entity.getHealth()) { //If the damager has less health
			double damagerOriginal = damager.getHealth(); //Health to be given to the entity
			double entityOriginal = entity.getHealth(); //Health to be given to the damager
			
			damager.setHealth(entityOriginal);
			entity.setHealth(damagerOriginal);			
		}
	}
	
}
