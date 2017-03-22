package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;
import org.bukkit.entity.Creature;
import org.bukkit.event.entity.EntityDeathEvent;

public class XP extends Enchant {
    XP() {
        super("XP", 4, Rarity.LEGENDARY, new ItemSet[]{ItemSet.SWORD}, "Gives the player more experience points when killing a mob", 100, false);
    }

    @Override
    public void entityDeathEvent(EntityDeathEvent e) {
        //If the entity killed is a mob (Not a player or another entity such as experience)
        if(e.getEntity() instanceof Creature) {
            e.setDroppedExp(e.getDroppedExp() + e.getDroppedExp()*(Enchant.getEnchantsOnPlayer(e.getEntity().getKiller()).get(this)/2));
        }
        
    }

}
