package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Savior extends Enchant {

	public Savior() {
		super("Savior", 4, Rarity.LEGENDARY, new ItemSet[]{ItemSet.HELMET}, "Chance to heal when low on health", 10, 5, true);
	}
	
	@Override
	public void genericDamageEvent(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) return; //Not a player, can't have savior.
		Player pl = (Player) e.getEntity();
		
		if (pl.getHealth()/pl.getMaxHealth() <= .20) { //Less than 20% health remaining, <= 2 full hearts.
			pl.setHealth(pl.getMaxHealth());
		}
	}
	
	@Override
	public void playerHitEvent(EntityDamageByEntityEvent e) {
		genericDamageEvent(e);
	}


}
