package eu.epicore.com.commands;

import eu.epicraft.com.data.utils.TextUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

/**
 * Created by AnyKwey
 */
public class PluginCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§cError: You cannot do it here.");
            return false;
        }

        Player player = (Player) sender;

        if(args.length != 0){
            TextUtil.falseArgument(player, args[0]);
            return false;
        }

        if(args.length == 0){
            PluginManager pm = Bukkit.getPluginManager();
            player.sendMessage(TextUtil.setLine() + TextUtil.setLine());
            player.sendMessage("§6Informations du serveur:");
            player.sendMessage("§eServeur: §b" + player.getServer().getName());
            player.sendMessage("§eVersion: §bPaper (MC: 1.20)");
            player.sendMessage("§ePlugins:");
            byte b;
            int j;
            Plugin[] arrayOfPlugin;
            for (j = (arrayOfPlugin = pm.getPlugins()).length, b = 0; b < j; ) {
                Plugin p = arrayOfPlugin[b];
                b++;

                player.sendMessage(" §8■ §b" + p.getName() +" §8(" + p.getDescription().getVersion() + ")");
            }
            player.sendMessage(TextUtil.setLine() + TextUtil.setLine());
        }
        return false;
    }
}
