package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Overworld extends Enchant {

	public Overworld() {
		super("Overworld", 3, Rarity.COMMON, new ItemSet[]{ItemSet.BOOTS}, "Chance to give the regeneration effect when at low health", 25, false, false);
	}
	
	@Override
	public void genericDamageEvent(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) return; //Not our player. Probably a pig. I hate pigs.
		Player pl = (Player) e.getEntity();
		if (pl.getEquipment().getBoots() == null) return; //How did this activate if it can only go on boots, yet the boots are null? It's the illuminati, I tell ya!
		int level = Enchant.getEnchants(pl.getEquipment().getBoots()).get(this); //Get Level
		
		if (pl.getHealth()/pl.getMaxHealth() <= .20) { //Less than 20% health remaining, <= 2 full hearts.
			pl.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 6, level-1), true); //Apply the regeneration effect, dependant on the level.
		}
	}
}
