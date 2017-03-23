package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class LifeSaver extends Enchant {

	public LifeSaver() {
		super("Life Saver", 5, Rarity.LEGENDARY, new ItemSet[]{ItemSet.SWORD}, "Chance to give your enemies' health to you", 2, 2);
	}
	
	@Override
	public void playerHitEvent(EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player)) return;
		if (!(e.getEntity() instanceof Player)) return;
		Player damager = (Player) e.getDamager();
		Player entity = (Player) e.getEntity();
		
		if (damager.getHealth() < entity.getHealth()) { //If the damager has less health
			double damagerOriginal = damager.getHealth(); //Health to be given to the entity
			double entityOriginal = entity.getHealth(); //Health to be given to the damager
			
			damager.setHealth(entityOriginal);
			entity.setHealth(damagerOriginal);			
		}
	}
	
}
