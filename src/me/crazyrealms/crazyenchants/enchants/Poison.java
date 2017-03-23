package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Poison extends Enchant {

	public Poison() {
		super("Poison", 3, Rarity.RARE, new ItemSet[]{ItemSet.SWORD}, "Chance to give the enemy the poison effect", 5, 5);
	}
	
	@Override
	public void playerHitEvent(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof LivingEntity)) return;
		if (!(e.getDamager() instanceof Player)) return;
		
		LivingEntity entity = (LivingEntity) e.getEntity();
		Player damager = (Player) e.getDamager();
		int level = Enchant.getEnchants(damager.getItemInHand()).get(this);
		
		entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20+20*level, 1));
	}
}
