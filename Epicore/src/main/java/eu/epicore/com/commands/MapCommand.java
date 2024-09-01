package eu.epicore.com.commands;

import eu.epicore.com.Epicore;
import eu.epicraft.com.data.utils.TextUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by AnyKwey
 */
public class MapCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("");
            return false;
        }

        Player player = (Player) sender;

        if(args.length != 0){
            TextUtil.falseArgument(player, args[0]);
            return false;
        }

        if(args.length == 0){
            if(!Epicore.getInstance().getConfig().getBoolean("map.access")){
                player.sendMessage("§cErreur: Cette carte a était généré par défaut.");
            } else {
                player.sendMessage(" ");
                player.sendMessage(TextUtil.setLine() + TextUtil.setLine());
                player.sendMessage(" §8■ §eNom: §b" + Epicore.getInstance().getConfig().getString("map.name"));
                player.sendMessage(" §8■ §eCréateur: §b" + Epicore.getInstance().getConfig().getString("map.author"));
                player.sendMessage(" §8■ §eDate de création: §b" + Epicore.getInstance().getConfig().getString("map.date"));
                player.sendMessage(TextUtil.setLine() + TextUtil.setLine());
                player.sendMessage(" ");
            }
            return false;
        }

        return false;
    }
}
