package me.crazyrealms.crazyenchants.enchants;

import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Speed extends Enchant {
    //Setting up the enchant
    public Speed() {
        super("Speed", 3, Rarity.LEGENDARY, new ItemSet[]{ItemSet.BOOTS}, "Permanent speed effect, each level increases speed level by 1", 100, true);
    }

}
