package me.crazyrealms.crazyenchants.listeners;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customevents.PlayerAttackedEntity;
import me.crazyrealms.crazyenchants.customevents.PlayerDamaged;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Random;

public class EntityDamage implements Listener {
    @EventHandler
    public void arrowHit(ProjectileHitEvent e) {
        if(!(e.getEntity().getShooter() instanceof Player)) return;

        Player p = (Player) e.getEntity().getShooter();
        if (Enchant.getEnchantsOnPlayer(p) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(p).keySet()) {
                int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(p).get(ench) - 1);
                if (chance >= new Random().nextInt(100)) {
                    ench.arrowHit(e);

                }
            }
        }
    }

    @EventHandler
    public void entityDeathEvent(EntityDeathEvent e) {
        if(!(e.getEntity() instanceof Player)) return;

        Player p = (Player) e.getEntity();
        if (Enchant.getEnchantsOnPlayer(p) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(p).keySet()) {
                int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(p).get(ench) - 1);
                if (chance >= new Random().nextInt(100)) {
                    ench.entityDeathEvent(e);
                }
            }
        }
    }

    @EventHandler
    public void playerAttackedEntity(PlayerAttackedEntity e) {
        Player p = e.getPlayerAttacker();
        if (Enchant.getEnchantsOnPlayer(p) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(p).keySet()) {
                int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(p).get(ench) - 1);
                if (chance >= new Random().nextInt(100)) {
                    ench.playerAttackedEntity(e);
                }
            }
        }
    }

    @EventHandler
    public void playerDamaged(PlayerDamaged e) {
        Player p = e.getPlayer();
        if (Enchant.getEnchantsOnPlayer(p) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(p).keySet()) {
                int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(p).get(ench) - 1);
                if (chance >= new Random().nextInt(100)) {
                    ench.playerDamaged(e);
                }
            }
        }
    }

    /*
    @EventHandler
    public void arrowHit(ProjectileHitEvent e) {
        if(!(e.getEntity().getShooter() instanceof Player)) return;

        Player p = (Player) e.getEntity().getShooter();
        if (Enchant.getEnchantsOnPlayer(p) != null) {
            for (Enchant ench : Enchant.getEnchantsOnPlayer(p).keySet()) {
                int chance = ench.getChance() + ench.getChanceIncrease() * (Enchant.getEnchantsOnPlayer(p).get(ench) - 1);
                if (chance >= new Random().nextInt(100)) {
                    ench.arrowHit(e);

                }
            }
        }
    }
    */
}
