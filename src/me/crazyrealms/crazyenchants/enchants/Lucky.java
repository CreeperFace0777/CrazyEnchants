package me.crazyrealms.crazyenchants.enchants;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customevents.PlayerAttackedEntity;
import me.crazyrealms.crazyenchants.customevents.PlayerDamaged;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Lucky extends Enchant {

	/*
	 * This enchantment just basically just has to run the code from the generic listeners,
	 * but only for armor pieces. I just copy+pasted code from listeners that have to do
	 * with armor ItemSets, so that it will just have x2 the chance of getting inside
	 * the enchantment's predefined chance, instead of modifying it and sending that
	 * to the listeners inside their respecive events.
	 */
	
	public Lucky() {
		super("Lucky", 10, Rarity.EPIC, new ItemSet[]{ItemSet.ALL_ARMOUR}, "Increases the chance of any enchant activating on that armor piece", 100, 0);
	}
	
	@Override
	public void playerAttackedEntity(PlayerAttackedEntity e) {
        for (Enchant ench : Enchant.getEnchantsOnPlayer(e.getPlayerAttacker()).keySet()) {
            int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(e.getPlayerAttacker()).get(ench) - 1);
            if (chance >= new Random().nextInt(100)) {
            	if (ench instanceof Lucky) continue;
                ench.playerAttackedEntity(e);
            }
        }
	}
	
	@Override
	public void playerBreakBlock(BlockBreakEvent e) {
        for (Enchant ench : Enchant.getEnchantsOnPlayer(e.getPlayer()).keySet()) {
            int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(e.getPlayer()).get(ench) - 1);
            if (chance >= new Random().nextInt(100)) {
            	if (ench instanceof Lucky) continue;
                ench.playerBreakBlock(e);
            }
        }
	}
	
	@Override
	public void playerDamaged(PlayerDamaged e) {
        for (Enchant ench : Enchant.getEnchantsOnPlayer(e.getPlayer()).keySet()) {
            int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(e.getPlayer()).get(ench) - 1);
            if (chance >= new Random().nextInt(100)) {
            	if (ench instanceof Lucky) continue;
                ench.playerDamaged(e);
            }
        }
	}
	
	@Override
	public void entityDeathEvent(EntityDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) return;
		Player player = (Player) e.getEntity();
		
        for (Enchant ench : Enchant.getEnchantsOnPlayer(player).keySet()) {
            int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(player).get(ench) - 1);
            if (chance >= new Random().nextInt(100)) {
            	if (ench instanceof Lucky) continue;
                ench.entityDeathEvent(e);
            }
        }
	}
}
