package me.crazyrealms.crazyenchants.customentities;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

// For use with the Humble enchantment
public class HumbleZombie {

	private Zombie entity;
	private UUID target;
	private UUID owner;
	
	public HumbleZombie(UUID owner, UUID target) {
		entity = (Zombie) Bukkit.getPlayer(owner).getWorld().spawnEntity(Bukkit.getPlayer(owner).getLocation(), EntityType.ZOMBIE);
		this.target = target;
		this.owner = owner;
		
		entity.setCanPickupItems(false);
		entity.getEquipment().clear();
		entity.setHealth(4);
		entity.setMaxHealth(4);
		entity.setTarget(Bukkit.getPlayer(target));
	}
	
	public UUID getOwner() {
		return owner;
	}
	
	public UUID getTarget() {
		return target;
	}
	
	public Zombie getZombie() {
		return entity;
	}
}
