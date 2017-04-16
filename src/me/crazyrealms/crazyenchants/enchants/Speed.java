package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Speed extends Enchant {
    //Setting up the enchant
    public Speed() {
        super("Speed", 3, Rarity.LEGENDARY, new ItemSet[]{ItemSet.BOOTS}, "Permanent speed effect, each level increases speed level by 1", 100, 0, true);
    }

    public void alwaysActive(Player player) {
        PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 60, Enchant.getEnchantsOnPlayer(player).get(this)-1);
        player.addPotionEffect(speed);
    }
}
