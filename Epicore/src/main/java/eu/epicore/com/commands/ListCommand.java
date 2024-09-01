package eu.epicore.com.commands;

import eu.epicraft.com.data.utils.TextUtil;
import eu.epicraft.com.manager.game.GameMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by AnyKwey
 */
public class ListCommand implements CommandExecutor {

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
            player.sendMessage(GameMessage.NAMESERVER_PREFIX.getMessage() + "§fIl y a actuellement §b" + Bukkit.getOnlinePlayers().size() + "§f connecté(s) sur ce serveur.");
        }
        return false;
    }
}
