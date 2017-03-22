package me.crazyrealms.crazyenchants.enchants;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class LuckyOre extends Enchant {

	public LuckyOre() {
		super("LuckyOre", 5, Rarity.RARE, new ItemSet[]{ItemSet.PICKAXE}, "Chance to instantly smelt an ore mined", 15, false, false);
	}
	
	@Override
	public void playerBreakBlockEvent(BlockBreakEvent e) {
		Collection<ItemStack> newDrops = new ArrayList<ItemStack>();		
		
		if (e.getPlayer().getItemInHand() == null) {
		newDrops = e.getBlock().getDrops(e.getPlayer().getItemInHand());
		for (ItemStack drops : e.getBlock().getDrops()) {
			if (drops.getType().name().contains("_ORE")) {
				
			}
		}
	}
}
