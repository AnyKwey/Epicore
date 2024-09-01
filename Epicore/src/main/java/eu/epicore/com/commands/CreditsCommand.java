package eu.epicore.com.commands;

import eu.epicraft.com.data.utils.TextUtil;
import eu.epicraft.com.data.yaml.PlayerInfos;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by AnyKwey
 */
public class CreditsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§cError: You cannot do it here.");
            return false;
        }

        Player player = (Player) sender;

        if(args.length == 0){
            player.sendMessage("§eVous avez §c" + PlayerInfos.getCredits(player.getName()) + " Crédits §esur votre compte.");
            player.sendMessage("§7> Vous pouvez faire le stock de crédits sur la /boutique ;)");
        }

        if(args.length != 0){
            TextUtil.falseArgument(player, args[0]);
            return false;
        }
        return false;
    }
}
