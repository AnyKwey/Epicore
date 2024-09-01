package eu.epicore.com.events;

import eu.epicore.com.Epicore;
import eu.epicore.com.commands.*;
import eu.epicore.com.listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class EventsManager {

    private Plugin plugin;

    public EventsManager(Plugin plugin){
        this.plugin = plugin;
    }

    public void registerListeners(){
        registerListener(new PlayerJoinListener());
    }

    public void registerCommands(){
        registerCommand("credits", new CreditsCommand());
        registerCommand("gems", new GemsCommand());
        registerCommand("list", new ListCommand());
        registerCommand("map", new MapCommand());
        registerCommand("mod", new ModCommand());
        registerCommand("plugin", new PluginCommand());
        registerCommand("report", new ReportCommand());
        registerCommand("shop", new ShopCommand());
        registerCommand("tph", new TeleportPlayerHereCommand());
        registerCommand("whois", new WhoisCommand());
        registerCommand("rank", new RankCommand());
    }


    private void registerListener(Listener listener){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(listener, plugin);
    }

    private void registerCommand(String cmd, CommandExecutor command){
        Epicore.getInstance().getCommand(cmd).setExecutor(command);
    }
}
