package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Toxic extends Enchant {
    public Toxic() {
        super("Toxic", 3, Rarity.RARE, new ItemSet[]{ItemSet.BOW}, "Gives the poison effect once a player is hit with an arrow", 20, false);
    }

    @Override
    public void arrowHit(ProjectileHitEvent e) {
        if(!(e.getEntity().getShooter() instanceof Player)) return;
        Player player = (Player) e.getEntity().getShooter();
        if(e.getEntity().getType() == EntityType.ARROW) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 2+Enchant.getEnchantsOnPlayer(player).get(this), Enchant.getEnchantsOnPlayer(player).get(this)));
        }

    }
}
