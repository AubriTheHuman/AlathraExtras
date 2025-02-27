package me.ShermansWorld.AlathraExtras.crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import me.ShermansWorld.AlathraExtras.Main;

public class SmithingTableListener implements Listener {

	@EventHandler
	public void onInvClick(final InventoryClickEvent e) {
		if (e.getInventory().getType() == InventoryType.SMITHING) {
			// if empty inventory
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				public void run() {
					if (e.getInventory().getItem(0) != null) {
						if (e.getInventory().getItem(0).getType() == Material.COBBLESTONE
								|| e.getInventory().getItem(0).getType() == Material.COBBLED_DEEPSLATE) {
							int amount = e.getInventory().getItem(0).getAmount();
							ItemStack gravel = new ItemStack(Material.GRAVEL, amount);
							e.getInventory().clear();
							Player p = (Player) e.getView().getPlayer();
							p.closeInventory();
							p.getInventory().addItem(gravel);
							p.getWorld().playSound(p.getLocation(), Sound.UI_STONECUTTER_TAKE_RESULT, 1.0f, 0.25f);
						} else if (e.getInventory().getItem(0).getType() == Material.GRAVEL) {
							int amount = e.getInventory().getItem(0).getAmount();
							ItemStack sand = new ItemStack(Material.SAND, amount);
							e.getInventory().clear();
							Player p = (Player) e.getView().getPlayer();
							p.closeInventory();
							p.getInventory().addItem(sand);
							p.getWorld().playSound(p.getLocation(), Sound.UI_STONECUTTER_TAKE_RESULT, 1.0f, 0.25f);
						} else if (e.getInventory().getItem(0).getType() == Material.DIORITE) {
							int amount = e.getInventory().getItem(0).getAmount();
							ItemStack quartz = new ItemStack(Material.QUARTZ, amount);
							e.getInventory().clear();
							Player p = (Player) e.getView().getPlayer();
							p.closeInventory();
							p.getInventory().addItem(quartz);
							p.getWorld().playSound(p.getLocation(), Sound.UI_STONECUTTER_TAKE_RESULT, 1.0f, 0.25f);
						} else if (e.getInventory().getItem(0).getType() == Material.COARSE_DIRT) {
                            int amount = e.getInventory().getItem(0).getAmount();
                            ItemStack quartz = new ItemStack(Material.DIRT, amount);
                            e.getInventory().clear();
                            Player p = (Player) e.getView().getPlayer();
                            p.closeInventory();
                            p.getInventory().addItem(quartz);
                            p.getWorld().playSound(p.getLocation(), Sound.UI_STONECUTTER_TAKE_RESULT, 1.0f, 0.25f);
                        } else if (e.getInventory().getItem(0).getType() == Material.PAPER) {
                            int amount = e.getInventory().getItem(0).getAmount();
                            ItemStack result = null;
                            boolean found = false;
                            if (e.getInventory().getItem(0).getItemMeta().hasCustomModelData()) {
            					if (e.getInventory().getItem(0).getItemMeta().getCustomModelData() == 14700) { // is beetroot pouch
            						result = new ItemStack(Material.BEETROOT, 9*amount);
            						found = true;
            					} else if (e.getInventory().getItem(0).getItemMeta().getCustomModelData() == 14701) { // is carrot pouch
            						result = new ItemStack(Material.CARROT, 9*amount);
            						found = true;
            					}
            				}
                            if (found) {
                            	e.getInventory().clear();
                                Player p = (Player) e.getView().getPlayer();
                                p.closeInventory();
                                p.getInventory().addItem(result);
                                p.getWorld().playSound(p.getLocation(), Sound.ITEM_BUNDLE_REMOVE_ONE, 1.0f, 0.25f);
                            }
                        }
						
					}
				}
			}, 5L); // 20 Tick (1 Second) delay before run() is called
		}
	}

}
