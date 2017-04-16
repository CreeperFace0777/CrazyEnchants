package me.crazyrealms.crazyenchants;

import com.mewin.WGCustomFlags.WGCustomFlagsPlugin;
import me.crazyrealms.crazyenchants.commands.Enchanter;
import me.crazyrealms.crazyenchants.enchants.*;
import me.crazyrealms.crazyenchants.listeners.BlockBreak;
import me.crazyrealms.crazyenchants.listeners.EnchantAdd;
import me.crazyrealms.crazyenchants.listeners.EntityDamage;
import me.crazyrealms.crazyenchants.listeners.PlayerInteract;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

//Main class
public class CrazyEnchants extends JavaPlugin {
    private static String prefix = ChatColor.DARK_AQUA + "CrazyEnchants » " + ChatColor.GRAY;
    public static WGCustomFlagsPlugin wg;

    public void onEnable() {
        buildEnchants();
    	enableWGCustomFlags();
    	Freeze.addMain(this);
    	
        Enchanter enchanter = new Enchanter();
        Bukkit.getPluginCommand("enchanter").setExecutor(enchanter);
        Bukkit.getPluginManager().registerEvents(enchanter, this);
        Bukkit.getPluginManager().registerEvents(new Freeze(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract(this), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamage(), this);
        Bukkit.getPluginManager().registerEvents(new EnchantAdd(), this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new CheckEnchants(), 0, 15);
    }

    private boolean enableWGCustomFlags() {
        Plugin plugin = getServer().getPluginManager().getPlugin("WGCustomFlags");

        if (plugin == null || !(plugin instanceof WGCustomFlagsPlugin)) {
            getLogger().severe("CrazyEnchants couldn't load as dependency plugins were not enabled");
            setEnabled(false);
            return false;
        }

        wg = (WGCustomFlagsPlugin) plugin;
        return true;
    }
    
    public static String getPrefix() {
        return prefix;
    }

    //Probably a better way of doing this.
    private void buildEnchants() {
        new AntiLava();
        new Blast();
        new Blind();
        new Combo();
        new Confusion();
        new Enderman();
        new Featherweight();
        new Freeze();
        new Guards();
        new Glow();
        new Haste();
        new Humble();
        new Jump();
        new LifeSaver();
        new Lightning();
        new Lucky();
        new LuckyOre();
        new Overworld();
        new Poison();
        new Regain();
        new Savior();
        new Speed();
        new Strength();
        new Sturdy();
        new Toxic();
        new XP();
    }

}
