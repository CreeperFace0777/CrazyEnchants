package me.crazyrealms.crazyenchants;

import me.crazyrealms.crazyenchants.commands.Enchanter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

//Main class
public class CrazyEnchants extends JavaPlugin {
    private static String prefix = ChatColor.DARK_AQUA + "CrazyEnchants » " + ChatColor.GRAY;

    public void onEnable() {
        Bukkit.getPluginCommand("enchanter").setExecutor(new Enchanter());
    }

    public static String getPrefix() {
        return prefix;
    }
}
