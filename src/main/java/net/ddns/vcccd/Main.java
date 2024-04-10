package net.ddns.vcccd;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	ConsoleCommandSender console = getServer().getConsoleSender();
	
	@Override
	public void onEnable() {
		console.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f[&eEnchants+&f] - Enchantments+ plugin enabled successfully!"));
		this.getCommand("enchantsplus").setExecutor(new getEnchantmentBook());
		getServer().getPluginManager().registerEvents(new EnchantEffects(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
