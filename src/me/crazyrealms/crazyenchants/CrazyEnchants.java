package me.crazyrealms.crazyenchants;

import org.bukkit.Bukkit;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

//Main class
public class CrazyEnchants extends JavaPlugin {

    public void onEnable() {
        //Loop through every enchant and add each listener
        for(Enchant e : Enchant.enchants) {
            Bukkit.getPluginManager().registerEvents(e, this);
        }
    }
}
