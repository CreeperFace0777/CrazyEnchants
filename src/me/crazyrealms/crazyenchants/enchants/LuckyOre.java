package me.crazyrealms.crazyenchants.enchants;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class LuckyOre extends Enchant {

	public LuckyOre() {
		super("LuckyOre", 5, Rarity.RARE, new ItemSet[]{ItemSet.PICKAXE}, "Chance to instantly smelt an ore mined", 15, 5, false, false);
	}
	
	@Override
	public void playerBreakBlock(BlockBreakEvent e) {
		Collection<ItemStack> newDrops = new ArrayList<ItemStack>();		
		
		newDrops = e.getBlock().getDrops(e.getPlayer().getItemInHand()); //Don't need a null check.
		for (ItemStack drops : newDrops) {
			if (drops.getType().name().contains("_ORE")) {
				ItemStack newStack = getSmeltedForm(drops.getType());
				newDrops.remove(drops);
				newDrops.add(newStack);
			}
		}
	}
	
	private ItemStack getSmeltedForm(Material m) {
		switch (m) {
			case COAL_ORE: return new ItemStack(Material.COAL);
			case IRON_ORE: return new ItemStack(Material.IRON_INGOT);
			case GOLD_ORE: return new ItemStack(Material.GOLD_INGOT);
			case QUARTZ_ORE: return new ItemStack(Material.QUARTZ);
			case DIAMOND_ORE: return new ItemStack(Material.DIAMOND);
			case EMERALD_ORE: return new ItemStack(Material.EMERALD);
			case LAPIS_ORE: return new ItemStack(Material.INK_SACK, 1, (short) 4);
			case REDSTONE_ORE: return new ItemStack(Material.REDSTONE);
			case GLOWING_REDSTONE_ORE: return new ItemStack(Material.REDSTONE);
		default: return null;
		}
	}
}
