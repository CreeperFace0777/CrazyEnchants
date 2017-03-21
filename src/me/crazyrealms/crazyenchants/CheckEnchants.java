package me.crazyrealms.crazyenchants;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Set;

public class CheckEnchants implements Runnable {

    @Override
    public void run() {
        for(Player p : Bukkit.getOnlinePlayers()) {
            //Check if the armor or the item held contains any enchants
            if(Enchant.getEnchants(p.getItemInHand(), p.getInventory().getBoots(), p.getInventory().getChestplate(), p.getInventory().getHelmet(), p.getInventory().getLeggings()) != null) {
                //The players armor/item contains an enchant
                for(Enchant ench : Enchant.getEnchantsOnPlayer(p).keySet()) {
                    if(ench.isActive()) {
                        ench.alwaysActive(p);
                    }
                }

            } /* The player doesn't have any enchants*/else continue;
        }


    }

}
