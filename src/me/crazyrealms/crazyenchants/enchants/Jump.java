package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;
import org.bukkit.Bukkit;

public class Jump extends Enchant {

	public Jump() {
		super("Jump", 3, Rarity.RARE, new ItemSet[]{ItemSet.BOOTS}, "Permanent Jump Boost effect, each level increases jump boost level by 1", 100, true);
	}


	
}
