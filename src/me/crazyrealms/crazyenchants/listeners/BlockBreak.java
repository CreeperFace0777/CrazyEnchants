package me.crazyrealms.crazyenchants.listeners;

import me.crazyrealms.crazyenchants.Enchant;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class BlockBreak implements Listener {

    @EventHandler
    public void blockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (Enchant.getEnchants(p.getItemInHand(), p.getInventory().getBoots(), p.getInventory().getChestplate(), p.getInventory().getHelmet(), p.getInventory().getLeggings()) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(p).keySet()) {
                int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(p).get(ench) - 1);
                if (chance >= 100) {
                    ench.playerBreakBlock(e);
                    return;
                }
                if (chance > new Random().nextInt(100))
                    ench.playerBreakBlock(e);
            }
        }
    }
}
