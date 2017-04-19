package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Glow extends Enchant {
	
	public Glow() {
		super("Glow", 1, Rarity.SIMPLE, new ItemSet[]{ItemSet.HELMET}, "Gives the player a permanant Night Vision effect", 100, 0, true);
	}

	@Override
	public void alwaysActive(Player player) {
		for(PotionEffect pot : player.getActivePotionEffects()) {
			if(pot.getType() == PotionEffectType.NIGHT_VISION) {
				if(pot.getDuration() <= 15)
				player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 350, 0), true);
				else return;
			}
		}

		player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 350, 0), true);
	}
}
