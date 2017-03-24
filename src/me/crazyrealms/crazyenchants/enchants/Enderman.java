package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customevents.PlayerAttackedEntity;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Enderman extends Enchant {

	public Enderman() { 
		super("Enderman", 3, Rarity.EPIC, new ItemSet[]{ItemSet.BOOTS}, "Chance to teleport behind your enemy", 1, 1, false);
	}
	
	@Override
	public void playerAttackedEntity(PlayerAttackedEntity e) {
		Player player = (Player) e.getPlayerAttacker();
		
		int level = Enchant.getEnchants(player.getEquipment().getBoots()).get(this); //Get Level
		if ((int) (Math.random()*3) <= level) { //Since each level is more likely to activate, I have to limit the 1st and 2nd levels.
		
			Vector loc1 = e.getAttackedEntity().getLocation().toVector(); //Vector of location of Entity
			Vector loc2 = player.getLocation().toVector(); //Vector of location of Damager Player
			
			Location newLocation = loc2.subtract(loc1).multiply(-1).toLocation(player.getWorld()); //Get the new location of the attacker
			
			
			Vector damagerVelocity = player.getVelocity().setX(player.getVelocity().getX()*-1).setZ(player.getVelocity().getZ()*-1); //Save velocity so they don't stop moving, and turn them around
			player.teleport(newLocation);
			player.setVelocity(damagerVelocity); //Re-set velocity
			
			player.getWorld().playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 0.001); //Play Particles! It's Cool!
			player.getWorld().playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1); //Play a sound! It's Cool!
			
		}
	}
	
}
