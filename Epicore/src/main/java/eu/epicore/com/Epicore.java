package eu.epicore.com;

import eu.epicore.com.events.EventsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Epicore extends JavaPlugin {

    private static Epicore instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        new EventsManager(this).registerListeners();
        new EventsManager(this).registerCommands();

        getServer().getConsoleSender().sendMessage("§aThe plugin is available!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§aThe plugin is stopped correctly!");
    }

    public static Epicore getInstance() {
        return instance;
    }
}
