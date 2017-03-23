package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Toxic extends Enchant {
    public Toxic() {
        super("Toxic", 3, Rarity.RARE, new ItemSet[]{ItemSet.BOW}, "Gives the poison effect once a player is hit with an arrow", 20, 10, false);
    }

    @Override
    public void playerHitEvent(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Arrow)) return;
        Arrow arrow = (Arrow) e.getDamager();
        if (!(e.getEntity() instanceof LivingEntity)) return;
        
        LivingEntity damagedEntity = (LivingEntity) e.getEntity();
        damagedEntity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 40+Enchant.getEnchantsOnPlayer((Player) arrow.getShooter()).get(this)*20, Enchant.getEnchantsOnPlayer((Player) arrow.getShooter()).get(this)));

    }
}
