package me.crazyrealms.crazyenchants.enchants;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customentities.HumbleZombie;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Humble extends Enchant {

	private static ArrayList<HumbleZombie> zombies = new ArrayList<HumbleZombie>(); //Stores all zombies that are Humble
	
	public Humble() {
		super("Humble", 5, Rarity.RARE, new ItemSet[]{ItemSet.ALL_ARMOUR}, "Chance to spawn a zombie horde that will target the player you hit", 1, 1, true, false);
	}
	
	@Override
	public void alwaysActive(Player player) {
		for (HumbleZombie zombie : zombies) {
			if (zombie.getZombie().getTicksLived() >= 20*7.5) { //If lived for long enough
				zombie.getZombie().damage(666); //evil.
			} else {
				if (Bukkit.getPlayer(zombie.getTarget()) == null) return; //Target is Offline
				zombie.getZombie().setTarget(Bukkit.getPlayer(zombie.getTarget())); //Set Zombie's target to "target"
			}
		}
	}
	
	@Override
	public void playerHitEvent(EntityDamageByEntityEvent e) {
		if (e.getDamager().getType() != EntityType.PLAYER) return;
		if (e.getEntity().getType() != EntityType.PLAYER) return;
		
		zombies.add(new HumbleZombie(e.getDamager().getUniqueId(), e.getEntity().getUniqueId())); //Constructor spawns zombie
	}
}
