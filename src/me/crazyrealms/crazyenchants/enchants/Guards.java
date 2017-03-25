package me.crazyrealms.crazyenchants.enchants;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customentities.GuardGolem;

import me.crazyrealms.crazyenchants.customevents.PlayerDamaged;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Guards extends Enchant {

	private static ArrayList<GuardGolem> golems = new ArrayList<GuardGolem>(); //Stores all spawned iron golems
	
	public Guards() {
		super("Guards", 10, Rarity.EPIC, new ItemSet[]{ItemSet.ALL_ARMOUR}, "Chance to spawn multiple iron golems that will attack enemies around the player", 1, 1);
	}
	
	@Override
	public void alwaysActive(Player player) {
		for (GuardGolem golem : golems) {
			if (golem.getGolem().getTicksLived() >= 20*7.5) { //If lived for long enough
				golem.getGolem().damage(666); //evil.
			} else {
				for (Entity ent : Bukkit.getPlayer(golem.getOwner()).getNearbyEntities(10, 10, 10)) {
					if (!((ent instanceof Monster))) continue;
					if (ent.getUniqueId().equals(golem.getTarget())) {
						golem.getGolem().setTarget(Bukkit.getPlayer(golem.getTarget())); //Set target to existing target
						return;
					}
				}
				for (Entity ent : Bukkit.getPlayer(golem.getOwner()).getNearbyEntities(10, 10, 10)) {
					if (!(ent instanceof Monster)) continue;
					Monster mon = (Monster) ent;
					golem.setTarget(mon);
				}
				
			}
		}
	}
	
	@Override
	public void playerDamaged(PlayerDamaged e) {
		if (e.getAttacker() == null) return;
		golems.add(new GuardGolem(e.getPlayer().getUniqueId())); //Constructor spawns golem
	}
}
