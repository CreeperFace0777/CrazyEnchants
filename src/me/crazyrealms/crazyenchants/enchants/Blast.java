package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Blast extends Enchant {

	//Create Enchantment
	public Blast() {
		super("Blast", 3, Rarity.EPIC, new ItemSet[]{ItemSet.PICKAXE, ItemSet.SHOVEL}, "When mining, you will destroy in a radius of blocks increasing by each level", 100, 0, false);
	}
	
	@Override
	public void playerBreakBlockEvent(BlockBreakEvent e) {
		if (e.getPlayer().getItemInHand() == null) return; //Somehow this was called, even if player has no item? Whatever.
		int level = Enchant.getEnchants(e.getPlayer().getItemInHand()).get(this); //Loop through item's custom enchants, return level.
		int size = 1 + (level * 2); //Size of the blast. Lv 1= 3x3, Lv2 = 5x5, Lv3 = 7x7 ***CHANGE IF NECESSARY***
		
		for (int x = -size; x < size; x++) { 		  //Loop through X coordinates
			for (int y = -size; y < size; y++) {	  //Loop through Y coordinates
				for (int z = -size; z < size; z++) {  //Loop through Z coordinates
					
					Block block = e.getBlock().getRelative(x, y, z); //Block to be removed, relative to e.getBlock()
					
					block.breakNaturally(e.getPlayer().getItemInHand()); //Break block & Drop item, if item used is correct.
					
				}
			}
		}
	}
}
