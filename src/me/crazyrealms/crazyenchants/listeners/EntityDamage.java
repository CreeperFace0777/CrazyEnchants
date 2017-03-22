package me.crazyrealms.crazyenchants.listeners;

import me.crazyrealms.crazyenchants.Enchant;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Random;

public class EntityDamage implements Listener {

    @EventHandler
    public void playerHitEvent(EntityDamageByEntityEvent e) {
        //If the damager isn't a player
        if (!(e.getDamager() instanceof Player)) return;
        //Damager IS player
        Player p = (Player) e.getDamager();
        if (Enchant.getEnchantsOnPlayer(p) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(p).keySet()) {
                int chance = ench.getChance() + 5 * (Enchant.getEnchantsOnPlayer(p).get(ench) - 1);
                if (chance >= 100) {
                    ench.playerHitEvent(e);
                    return;
                }
                if (chance > new Random().nextInt(100)) {
                    ench.playerHitEvent(e);
                }
            }
        }
    }

    @EventHandler
    public void genericDamage(EntityDamageEvent e) {
        //If the damager isn't a player
        if (!(e.getEntity() instanceof Player)) return;
        //Damager IS player
        Player p = (Player) e.getEntity();
        if (Enchant.getEnchantsOnPlayer(p) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(p).keySet()) {
                int chance = ench.getChance() + 5 * (Enchant.getEnchantsOnPlayer(p).get(ench) - 1);
                if (chance >= 100) {
                    ench.genericDamageEvent(e);
                    return;
                }
                if (chance > new Random().nextInt(100)) {
                    ench.genericDamageEvent(e);
                }
            }
        }
    }

    @EventHandler
    public void playerDeathEvent(EntityDeathEvent e) {
        Player p = e.getEntity().getKiller();
        if (Enchant.getEnchantsOnPlayer(p) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(p).keySet()) {
                int chance = ench.getChance() + 5 * (Enchant.getEnchantsOnPlayer(p).get(ench) - 1);
                if (chance >= 100) {
                    ench.entityDeathEvent(e);
                    return;
                }
                if (chance > new Random().nextInt(100)) {
                    ench.entityDeathEvent(e);
                }
            }
        }
    }

    @EventHandler
    public void arrowHit(ProjectileHitEvent e) {
        if(!(e.getEntity().getShooter() instanceof Player)) return;

        Player p = (Player) e.getEntity().getShooter();
        if (Enchant.getEnchantsOnPlayer(p) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(p).keySet()) {
                int chance = ench.getChance() + 5 * (Enchant.getEnchantsOnPlayer(p).get(ench) - 1);
                if (chance >= 100) {
                    ench.arrowHit(e);
                    return;
                }
                if (chance > new Random().nextInt(100)) {
                    ench.arrowHit(e);
                }
            }
        }
    }
}
