package me.ShermansWorld.AlathraExtras.tpacooldown.listener.player;

import me.ShermansWorld.AlathraExtras.Helper;
import me.ShermansWorld.AlathraExtras.Main;
import me.ShermansWorld.AlathraExtras.tpacooldown.CooldownCache;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class PlayerCommandPreprocessListener implements Listener {
    private final static List<String> BLOCKED_COMMANDS = List.of(new String[]{
            "/tpa",
            "/essentials:tpa",
            "/tpask",
            "/essentials:tpask",
    });

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        final String originalMessage = e.getMessage();
        int space = originalMessage.indexOf(" ");
        if (space == -1) {
            space = originalMessage.length() - 1;
        }

        final String originalCommand = originalMessage.substring(0, space); // Just the command without prefix slash

        if (!BLOCKED_COMMANDS.contains(originalCommand)) return;

        // Tpa cost
        final double bal = Main.economy.getBalance(Bukkit.getOfflinePlayer(e.getPlayer().getUniqueId()));
        if (bal < 50) {
            e.getPlayer().sendMessage(Helper.Chatlabel() + Helper.color("&cTeleportation request canceled. You need at least &a$50 &cto run this command!"));
            e.setCancelled(true);
            return;
        }

        if (CooldownCache.isCooldownActive(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(CooldownCache.getCooldownMessage(CooldownCache.get(e.getPlayer().getUniqueId())));
            return;
        }
    }
}
