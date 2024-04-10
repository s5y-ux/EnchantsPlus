package net.ddns.vcccd;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchantEffects implements Listener {
	
	@EventHandler
	public void onPlayerStrike(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player)) {
			assert true;
		} else {
			Player player = (Player) event.getDamager();
			ItemStack itemInHand = player.getInventory().getItemInMainHand();
			ItemMeta itemInHandData = itemInHand.getItemMeta();
			List<String> itemLore = itemInHandData.getLore();
			switch(itemLore.get(1).substring(2, itemLore.get(1).length())) {
			case "Gamer I":
				player.sendMessage("Test");
				break;
			default:
				player.sendMessage(itemLore.get(-1).substring(2, itemLore.get(-1).length()));
			}
		}
	}
	
}
