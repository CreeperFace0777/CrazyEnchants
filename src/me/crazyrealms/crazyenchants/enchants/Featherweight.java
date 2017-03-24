package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.customevents.PlayerAttackedEntity;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Featherweight extends Enchant {
    public Featherweight() {
        super("Featherweight", 3, Rarity.COMMON, new ItemSet[]{ItemSet.SWORD}, "A chance to give the player a burst of haste", 7, 5, false);
    }

    @Override
    public void playerAttackedEntity(PlayerAttackedEntity e) {
        Player player = (Player) e.getPlayerAttacker();
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 2+Enchant.getEnchantsOnPlayer(player).get(this), 2));

    }
}
