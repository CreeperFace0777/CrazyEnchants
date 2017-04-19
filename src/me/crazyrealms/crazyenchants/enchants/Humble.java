package me.crazyrealms.crazyenchants.enchants;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customentities.HumbleZombie;
import me.crazyrealms.crazyenchants.customevents.PlayerDamaged;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Humble extends Enchant {

	private static ArrayList<HumbleZombie> zombies = new ArrayList<HumbleZombie>(); //Stores all zombies that are Humble
	
	public Humble() {
		super("Humble", 5, Rarity.RARE, new ItemSet[]{ItemSet.ALL_ARMOUR}, "Chance to spawn a zombie horde that will target the player you hit", 100, 3, true, false);
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
	public void playerDamaged(PlayerDamaged e) {
		if (e.getAttacker() == null || !(e.getAttacker() instanceof Player)) return;
		
		zombies.add(new HumbleZombie(e.getPlayer().getUniqueId(), e.getAttacker().getUniqueId())); //Constructor spawns zombie
	}
}
