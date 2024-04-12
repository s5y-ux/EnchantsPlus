package net.ddns.vcccd;

import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class EnchantEffects implements Listener {
	
	private void poisonEnchant(Entity entity, Player player) {
		Random randObject = new Random();
		
		//0 to 10
		int randomNumber = randObject.nextInt(11);
		if(entity instanceof LivingEntity) {
			LivingEntity ourVictim = (LivingEntity) entity;
			if(randomNumber == 5) {
				player.sendMessage("Hit");
				ourVictim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 140, 1));
			}
		}
	}
	
	private void floatEnchant(Entity entity) {
		Random randObject = new Random();
	
		//0 to 10
		int randomNumber = randObject.nextInt(11);
		if(entity instanceof LivingEntity) {
			LivingEntity ourVictim = (LivingEntity) entity;
			if(randomNumber == 5) {
				ourVictim.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 40, 2));
			}
		}
		
	}
	
	private void antiKnockback(Player player) {
		Vector playerDirection = player.getEyeLocation().getDirection();
		player.setVelocity(playerDirection);
		player.sendMessage(playerDirection.toString());
	}
	
	private void explodeEnchant(Entity entity) {
		Random randObject = new Random();
		
		//0 to 10
		int randomNumber = randObject.nextInt(11);
		if(randomNumber == 5) {
			Location victimLocal = entity.getLocation();
			World currentWorld = entity.getWorld();
			currentWorld.createExplosion(victimLocal, 2);
		}
	}
	
	@EventHandler	
	public void onPlayerStrike(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player)) {
			assert true;
		} else {
			Player player = (Player) event.getDamager();
			Entity victim = event.getEntity();
			
			ItemStack itemInHand = player.getInventory().getItemInMainHand();
			ItemMeta itemInHandData = itemInHand.getItemMeta();
			List<String> itemLore = itemInHandData.getLore();

			switch(itemLore.get(1).substring(2, itemLore.get(1).length())) {
			case "Anti-Knockback I":
				player.sendMessage("Test");
				antiKnockback(player);
				break;
			case "Explode I":
				player.sendMessage("Test Two");
				explodeEnchant(victim);
				break;
			case "Float I":
				player.sendMessage("Test Thro");
				floatEnchant(victim);
				break;
			case "Poison I":
				player.sendMessage("Test four");
				poisonEnchant(victim, player);
			default:
				assert true;
			}
		}
	}
	
}
