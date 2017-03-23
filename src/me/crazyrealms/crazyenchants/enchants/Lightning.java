package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Lightning extends Enchant {

	public Lightning() {
		super("Lightning", 3, Rarity.SIMPLE, new ItemSet[]{ItemSet.BOW}, "Chance to smite (strike lightning upon) your enemy", 1, 1, false);
	}
	
	@Override
	public void playerHitEvent(EntityDamageByEntityEvent e) {
		if (e.getDamager().getType() != EntityType.ARROW) return;
		
		e.getEntity().getWorld().strikeLightningEffect(e.getEntity().getLocation());
		e.getEntity().setFireTicks(20*10);
		((Damageable) e.getEntity()).damage(8);
	}
	
}
