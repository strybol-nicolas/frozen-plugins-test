package be.xlga.plugin;

import be.xlga.plugin.events.JoinEvent;
import be.xlga.plugin.tasks.BroadcastMOTD;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigPlugin extends JavaPlugin{


    public void onEnable(){

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "frozen-plugins-test Enabled\n");

        loadConfig();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "This is the motd from the config.yml = "
                                                                      + getConfig().get("motd").toString());

        BroadcastMOTD.messageOfTheDayBroadcast();

        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
    }


    public void onDisable(){

        getServer().getScheduler().cancelAllTasks();

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "frozen-plugins-test Disabled\n");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Aaaaaaaaaw... Why you unloading me? :'(");
    }


    private void loadConfig(){

        getConfig().options().copyDefaults(true);
        getConfig().set("motd", "This is the MOTD generated through the loadConfig()!");
        saveConfig();
    }
}
