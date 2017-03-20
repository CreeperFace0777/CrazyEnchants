package me.crazyrealms.crazyenchants.listeners;

import me.crazyrealms.crazyenchants.Enchant;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Random;

public class EntityDamage implements Listener {
    
    @EventHandler
    public void playerHitEvent(EntityDamageByEntityEvent e) {
        //If the damager isn't a player
        if(!(e.getDamager() instanceof Player)) return;
        //Damager IS player
        Player p = (Player) e.getDamager();
        if(Enchant.getEnchants(p.getItemInHand(), p.getInventory().getBoots(), p.getInventory().getChestplate(), p.getInventory().getHelmet(), p.getInventory().getLeggings()) != null) {
            for(Enchant ench : Enchant.getEnchants(p.getItemInHand(), p.getInventory().getBoots(), p.getInventory().getChestplate(), p.getInventory().getHelmet(), p.getInventory().getLeggings()).keySet()) {
                //TODO: CHANCE NEED TO BE INCREASED DEPENDING ON LEVEL
                if(ench.getChance() > new Random().nextInt(100)) {
                    ench.playerHitEvent(e);
                }
            }
        }
    }

    @EventHandler
    public void genericDamage(EntityDamageEvent e) {
        //If the damager isn't a player
        if(!(e.getEntity() instanceof Player)) return;
        //Damager IS player
        Player p = (Player) e.getEntity();
        if(Enchant.getEnchants(p.getItemInHand(), p.getInventory().getBoots(), p.getInventory().getChestplate(), p.getInventory().getHelmet(), p.getInventory().getLeggings()) != null) {
            for(Enchant ench : Enchant.getEnchants(p.getItemInHand(), p.getInventory().getBoots(), p.getInventory().getChestplate(), p.getInventory().getHelmet(), p.getInventory().getLeggings()).keySet()) {
                //TODO: CHANCE NEED TO BE INCREASED DEPENDING ON LEVEL
                if(ench.getChance() > new Random().nextInt(100)) {
                    ench.genericDamageEvent(e);
                }
            }
        }
    }
}
