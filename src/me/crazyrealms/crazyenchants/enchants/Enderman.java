package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Enderman extends Enchant {

	//15% chance because I have to do the most likely percentage, the 3rd level
	public Enderman() { 
		super("Enderman", 3, Rarity.EPIC, new ItemSet[]{ItemSet.BOOTS}, "Chance to teleport behind your enemy", 15, false);
	}
	
	@Override
	public void playerHitEvent(EntityDamageByEntityEvent e) {
		if (e.getDamager().getType() != EntityType.PLAYER) return; //If damager is a player
		Player player = (Player) e.getDamager();
		
		int level = Enchant.getEnchants(player.getEquipment().getBoots()).get(this); //Get Level
		if ((int) (Math.random()*3) <= level) { //Since each level is more likely to activate, I have to limit the 1st and 2nd levels.
		
			Vector loc1 = e.getEntity().getLocation().toVector(); //Vector of location of Entity
			Vector loc2 = e.getDamager().getLocation().toVector(); //Vector of location of Entity
			
			Location newLocation = loc2.subtract(loc1).multiply(-1).toLocation(player.getWorld()); //Get the new location of the attacker
			
			
			Vector damagerVelocity = player.getVelocity().multiply(-1); //Save velocity so they don't stop moving
			player.teleport(newLocation);
			player.setVelocity(damagerVelocity); //Re-set velocity
			
			player.getWorld().playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 0.001); //Play Particles! It's Cool!
			player.getWorld().playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1); //Play a sound! It's Cool!
			
		}
	}
	
}
