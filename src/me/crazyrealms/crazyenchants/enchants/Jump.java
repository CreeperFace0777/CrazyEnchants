package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Jump extends Enchant {

	public Jump() {
		super("Jump", 3, Rarity.RARE, new ItemSet[]{ItemSet.BOOTS}, "Permanent Jump Boost effect, each level increases jump boost level by 1", 100, 0, true);
	}

	@Override
	public void alwaysActive(Player player) {
		int level = Enchant.getArmorEnchants(player).get(this);
		player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 60, level-1), true);
	}
}
