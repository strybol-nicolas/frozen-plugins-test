package be.xlga.plugin.events;

import be.xlga.plugin.ConfigPlugin;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class JoinEvent implements Listener {

    private Plugin plugin = ConfigPlugin.getPlugin(ConfigPlugin.class);


    @EventHandler
    public void onJoin(PlayerJoinEvent evt){

        Player player = evt.getPlayer();

        String message = plugin.getConfig().get("motd").toString();

        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 10, 1);
        player.sendMessage(message);
    }
}
