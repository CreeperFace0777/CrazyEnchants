package me.crazyrealms.crazyenchants.enchants;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Combo extends Enchant {

	private static Map<UUID, Integer> hitCounter = new HashMap<UUID, Integer>(); //If you can think of a better way to do this, replace this. Stores the hitcounter of all players.
	
	public Combo() {
		super("Combo", 6, Rarity.LEGENDARY, new ItemSet[]{ItemSet.ALL_WEAPONS}, "The more you attack without being hit, the more damage you do", 100, false);
	}
	
	@Override
	public void playerHitEvent(EntityDamageByEntityEvent e) {
		if (e.getEntity().getType() != EntityType.PLAYER) return; //Don't hitbuild on mobs, can be abused with grinding. Removed if unwanted.
		Player hitPlayer = (Player) e.getEntity();
		hitCounter.remove(hitPlayer.getUniqueId()); //Reset the hit player's combo
		
		if (e.getDamager().getType() == EntityType.PLAYER) {
			Player damagerPlayer = (Player) e.getDamager();
			if (hitCounter.get(damagerPlayer.getUniqueId()) == null) {
				hitCounter.put(damagerPlayer.getUniqueId(), 1); //Null-Check if player has no Combo
			} else {
				hitCounter.put(damagerPlayer.getUniqueId(), hitCounter.get(damagerPlayer.getUniqueId()) + 1); //Increase counter by 1
			}
			int level = Enchant.getEnchants(damagerPlayer.getItemInHand()).get(this); //Get
			
			double damage = e.getDamage();
			damage = damage + (damage * level/6 * (1-(1/hitCounter.get(damagerPlayer.getUniqueId())))); //damage = damage + damage * 1/level * (1 - 1/hitCounter) - [ask me for an example!]
			e.setDamage(damage);
		}
	}
}
