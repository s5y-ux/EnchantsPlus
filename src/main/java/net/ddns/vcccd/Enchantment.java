package net.ddns.vcccd;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Enchantment {
	
	private ItemStack returnBook;
	
	private ItemStack generateBook(String enchantmentName) {
		ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta bookData = book.getItemMeta();
		List<String> bookLore = new ArrayList<String>();
		bookLore.add(ChatColor.translateAlternateColorCodes('&', "&9Ingredients"));
		bookLore.add(ChatColor.GRAY + enchantmentName + " I");
		bookData.setLore(bookLore);
		book.setItemMeta(bookData);
		return(book);
	}
	
	public Enchantment(String customEnchant) {
		switch(customEnchant) {
		case "Gamer":
			this.returnBook = generateBook(customEnchant);
			break;
		}
	}
	
	public ItemStack getBook() {
		return(this.returnBook);
	}
}
