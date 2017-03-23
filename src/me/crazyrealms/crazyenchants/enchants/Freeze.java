package me.crazyrealms.crazyenchants.enchants;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.crazyrealms.crazyenchants.CrazyEnchants;
import me.crazyrealms.crazyenchants.Enchant;
import me.crazyrealms.crazyenchants.enums.ItemSet;
import me.crazyrealms.crazyenchants.enums.Rarity;

public class Freeze extends Enchant implements Listener {

	private static CrazyEnchants main; //Instance of the main class, used for creating schedulers
	private static ArrayList<UUID> frozenPlayers = new ArrayList<UUID>(); //List of frozen players
	
	public Freeze() {
		super("Freeze", 3, Rarity.RARE, new ItemSet[]{ItemSet.SWORD}, "Chance to make the enemy not able to move", 3, 3);
	}
	
	@Override
	public void playerHitEvent(EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player)) return;
		if (!(e.getEntity() instanceof Player)) return;
		Player damager = (Player) e.getDamager();
		Player entity = (Player) e.getEntity();
		
		int level = Enchant.getEnchants(damager.getItemInHand()).get(this);
		
		frozenPlayers.add(entity.getUniqueId()); //Set the player to be frozen
		new BukkitRunnable() {
			@Override
			public void run() {
				frozenPlayers.remove(entity.getUniqueId()); //Remove player from the frozen list afte X time
			}
		}.runTaskLater(main, 20*level);//1 Second per extra level
	}

	@EventHandler
	public void playerMove(PlayerMoveEvent e) {
		if (frozenPlayers.contains(e.getPlayer().getUniqueId())) e.setCancelled(true); //Don't allow the player to move if they are frozen.
	}
	
	public static void addMain(CrazyEnchants mainClass) {
		main = mainClass;
	}
}
