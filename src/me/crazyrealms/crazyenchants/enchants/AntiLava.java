package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class AntiLava extends Enchant {

	public AntiLava() {
		super("Anti-Lava", 1, Rarity.EPIC, new ItemSet[]{ItemSet.ALL_ARMOUR}, "Gives the player permanant Fire Resistance Effect", 100, 0, true);
	}
	
	@Override
	public void alwaysActive(Player player) {
		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 6, 0), true);
	}
}
