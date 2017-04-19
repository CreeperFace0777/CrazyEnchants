package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customevents.PlayerAttackedEntity;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Poison extends Enchant {

	public Poison() {
		super("Poison", 3, Rarity.RARE, new ItemSet[]{ItemSet.SWORD}, "Chance to give the enemy the poison effect", 100, 5);
	}
	
	@Override
	public void playerAttackedEntity(PlayerAttackedEntity e) {
		if (!(e.getAttackedEntity() instanceof LivingEntity)) return;
		
		LivingEntity entity = (LivingEntity) e.getAttackedEntity();
		Player damager = e.getPlayerAttacker();
		int level = Enchant.getHeldEnchants(damager).get(this);
		
		entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20+20*level, 1));
	}
}
