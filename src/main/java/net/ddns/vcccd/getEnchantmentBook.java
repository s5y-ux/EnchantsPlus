package net.ddns.vcccd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class getEnchantmentBook implements CommandExecutor {

	private void getHelpMenu(Player player) {
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/enchantsplus &fhelp &6- Pulls up the menu you are currently looking at"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/enchantsplus &fgivebook <enchantment> <player> &6- Gives the player the specified enchanement book"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/enchantsplus &flist &6- Lists the enchantmens provided in the plugin"));
	}
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(!(arg0 instanceof Player)) {
			arg0.sendMessage(ChatColor.RED + "Only players can use this command...");
			return false;
		}
		
		Player player = (Player) arg0;
		
		if(arg3.length == 0) {
			getHelpMenu(player);
			return false;
		}
		
		switch(arg3[0]) {
		case "help":
			getHelpMenu(player);
			break;
		case "list":
			player.sendMessage("Currently Empty...");
			break;
		case "getbook":
			if(arg3.length == 1) {
				getHelpMenu(player);
			} else {
				try {
					Enchantment usedEnchant = new Enchantment(arg3[1]);
					player.getInventory().addItem(usedEnchant.getBook());
				} catch (Exception e) {
					player.sendMessage(ChatColor.RED + "Could not find that enchantment...");
				}
			}
			break;
		default:
			getHelpMenu(player);
		}
		
		return false;
	}

}
