package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.customevents.PlayerDamaged;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Sturdy extends Enchant {

	public Sturdy() {
		super("Sturdy", 3, Rarity.EPIC, new ItemSet[]{ItemSet.ALL_ARMOUR}, "Gives your armor more durability", 100, 20);
	}
	
	@Override
	public void playerDamaged(PlayerDamaged e) {
		Player player = e.getPlayer();
		
		for (ItemStack equipment : player.getEquipment().getArmorContents()) {
			if (equipment == null) continue;
			if (equipment.getDurability() != 0) {
				equipment.setDurability((short) (equipment.getDurability() + 1));
			}
		}
	}
}
