package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customevents.PlayerAttackedEntity;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Blind extends Enchant {

	public Blind() {
		super("Blind", 3, Rarity.RARE, new ItemSet[]{ItemSet.BOW, ItemSet.SWORD}, "Chance to give the enemy blindness", 5, 5, false, false);
	}
	
	@Override
	public void playerAttackedEntity(PlayerAttackedEntity e) {
		if (!(e.getAttackedEntity() instanceof LivingEntity)) return;
		LivingEntity entity = (LivingEntity) e.getAttackedEntity();
		
		int level = Enchant.getHeldEnchants(e.getPlayerAttacker()).get(this);
		
		entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*(level+1), 0), true);
	}
}
