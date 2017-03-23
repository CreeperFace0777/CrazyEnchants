package me.crazyrealms.crazyenchants.enchants;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Lucky extends Enchant {

	/*
	 * This enchantment just basically just has to run the code from the generic listeners,
	 * but only for armor pieces. I just copy+pasted code from listeners that have to do
	 * with armor ItemSets, so that it will just have x2 the chance of getting inside
	 * the enchantment's predefined chance, instead of modifying it and sending that
	 * to the listeners inside their respecive events.
	 */
	
	public Lucky() {
		super("Lucky", 10, Rarity.EPIC, new ItemSet[]{ItemSet.ALL_ARMOUR}, "Increases the chance of any enchant activating on that armor piece", 100, 0);
	}
	
	@Override
	public void playerHitEvent(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			Player entity = (Player) e.getEntity();
	        if (Enchant.getEnchantsOnPlayer(entity) != null) {
	            for (Enchant ench : Enchant.getEnchantsOnPlayer(entity).keySet()) {
	                int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(entity).get(ench) - 1);
	                if (chance >= 100) {
	                    ench.playerHitEvent(e);
	                    return;
	                }
	                if (chance > new Random().nextInt(100)) {
	                    ench.playerHitEvent(e);
	                }
	            }
	        }
		}
	} 
	
	@Override
	public void entityDeathEvent(EntityDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) return;
		Player player = (Player) e.getEntity();
        if (Enchant.getEnchantsOnPlayer(player) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(player).keySet()) {
                int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(player).get(ench) - 1);
                if (chance >= 100) {
                    ench.entityDeathEvent(e);
                    return;
                }
                if (chance > new Random().nextInt(100)) {
                    ench.entityDeathEvent(e);
                }
            }
        }
	}
	
	@Override
	public void genericDamageEvent(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) return;
		Player player = (Player) e.getEntity();
        if (Enchant.getEnchantsOnPlayer(player) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(player).keySet()) {
                int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(player).get(ench) - 1);
                if (chance >= 100) {
                    ench.genericDamageEvent(e);
                    return;
                }
                if (chance > new Random().nextInt(100)) {
                    ench.genericDamageEvent(e);
                }
            }
        }
	}
	
}
