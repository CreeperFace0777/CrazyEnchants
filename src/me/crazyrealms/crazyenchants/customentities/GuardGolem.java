package me.crazyrealms.crazyenchants.customentities;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;

//For use with the Guard enchantment
public class GuardGolem {

	private IronGolem entity;
	private UUID target;
	private UUID owner;
	
	public GuardGolem(UUID owner) {
		entity = (IronGolem) Bukkit.getPlayer(owner).getWorld().spawnEntity(Bukkit.getPlayer(owner).getLocation(), EntityType.IRON_GOLEM);
		this.owner = owner;
		
		entity.setCanPickupItems(false);
		entity.getEquipment().clear();
		entity.setHealth(20);
		entity.setMaxHealth(20);
		
		for (Entity ent : Bukkit.getPlayer(owner).getNearbyEntities(10, 10, 10)) {
			if (!(ent instanceof Monster)) continue;
			entity.setTarget((LivingEntity) ent);
			break;
		}
	}
	
	public UUID getOwner() {
		return owner;
	}
	
	public UUID getTarget() {
		return target;
	}
	
	public IronGolem getGolem() {
		return entity;
	}
	
	public void setTarget(LivingEntity en) {
		entity.setTarget(en);
		target = en.getUniqueId();
	}
}
