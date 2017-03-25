package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.customevents.PlayerAttackedEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Confusion extends Enchant {

	public Confusion() {
		super("Confusion", 3, Rarity.SIMPLE, new ItemSet[]{ItemSet.SWORD, ItemSet.AXE}, "Chance to give your enemy the nausea effect", 10, 5, false, false);
	}
	
	@Override
	public void playerAttackedEntity(PlayerAttackedEntity e) {
		if (!(e.getAttackedEntity() instanceof LivingEntity)) return; //Only Living Entities can have Potion Effects
		LivingEntity entity = (LivingEntity) e.getAttackedEntity();
		
		entity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 50, 0), true);
	}
}
