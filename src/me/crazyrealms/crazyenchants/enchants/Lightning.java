package me.crazyrealms.crazyenchants.enchants;

import org.bukkit.entity.Arrow;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customevents.PlayerDamaged;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Lightning extends Enchant {

	public Lightning() {
		super("Lightning", 3, Rarity.SIMPLE, new ItemSet[]{ItemSet.BOW}, "Chance to smite (strike lightning upon) your enemy", 100, 2, false);
	}
	
	@Override
	public void playerDamaged(PlayerDamaged e) {
		if (!(e.getAttacker() instanceof Arrow)) return;
		
		e.getPlayer().getWorld().strikeLightningEffect(e.getPlayer().getLocation());
		e.getPlayer().setFireTicks(20*5);
		e.getPlayer().damage(8);
	}
	

}
