package me.ShermansWorld.AlathraExtras.misc;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ShermansWorld.AlathraExtras.Helper;

public class CustomItems {

	public static ItemStack tutorialBook() {
		ItemStack tutorialBook = new ItemStack(Material.BOOK, 1);
		ItemMeta meta = tutorialBook.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Helper.color("&eRight click the book in your hand or type /help"));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(Helper.color("&6&lPlayer's Guide to &a&lAlathra&2&lMC"));
		meta.setCustomModelData(14899);
		tutorialBook.setItemMeta(meta);
		return tutorialBook;
	}

	public static ItemStack getCarrotPouch() {
		ItemStack carrotPouch = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = carrotPouch.getItemMeta();
		meta.setCustomModelData(14701);
		meta.setDisplayName(Helper.color("&6Carrot Pouch"));
		carrotPouch.setItemMeta(meta);
		return carrotPouch;
	}

	public static ItemStack getBeetrootPouch() {
		ItemStack beeetrootPouch = new ItemStack(Material.PAPER, 1);
		ItemMeta meta = beeetrootPouch.getItemMeta();
		meta.setCustomModelData(14700);
		meta.setDisplayName(Helper.color("&4Beetroot Pouch"));
		beeetrootPouch.setItemMeta(meta);
		return beeetrootPouch;
	}

	public static ItemStack getInvisibleItemFrame() {
		ItemStack item = new ItemStack(Material.ITEM_FRAME, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Helper.color("&cInvisible Item Frame"));
		item.setItemMeta(meta);
		return item;
	}
}
