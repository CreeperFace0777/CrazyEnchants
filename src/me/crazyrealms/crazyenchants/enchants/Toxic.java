package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customevents.PlayerAttackedEntity;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Toxic extends Enchant {
    public Toxic() {
        super("Toxic", 3, Rarity.RARE, new ItemSet[]{ItemSet.BOW}, "Gives the poison effect once a player is hit with an arrow", 20, 10, false);
    }

    @Override
    public void playerAttackedEntity(PlayerAttackedEntity e) {
    	Player damager = e.getPlayerAttacker();
    	
    	if (!(e.getAttackedEntity() instanceof LivingEntity)) return;
    	LivingEntity entity = (LivingEntity) e.getAttackedEntity();
    	
    	int level = Enchant.getEnchantsOnPlayer(damager).get(this);
    	
    	entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 40*level, 1), true);
    }
}
