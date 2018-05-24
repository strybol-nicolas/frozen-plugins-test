package be.xlga.plugin.tasks;

import be.xlga.plugin.ConfigPlugin;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import static org.bukkit.Bukkit.broadcastMessage;
import static org.bukkit.Bukkit.getServer;

public class BroadcastMOTD {

    private static Plugin plugin = ConfigPlugin.getPlugin(ConfigPlugin.class);

    public static void messageOfTheDayBroadcast(){

        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(ConfigPlugin.getPlugin(ConfigPlugin.class),
                () -> broadcastMessage(plugin.getConfig().get("motd").toString()),

                0L, 12000L);

    }
}
