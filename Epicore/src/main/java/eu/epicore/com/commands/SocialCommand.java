package eu.epicore.com.commands;

import eu.epicraft.com.data.utils.TextUtil;
import eu.epicraft.com.data.yaml.RankUnit;
import eu.epicraft.com.manager.moderation.ModManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by AnyKwey
 */
public class SocialCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cError: You cannot do it here.");
            return false;
        }

        Player player = (Player) sender;

        if (label.equalsIgnoreCase("social")) {
            if (RankUnit.getRank(player.getUniqueId()).getPower() < RankUnit.GRADE3.getPower()) {
                player.sendMessage(TextUtil.sendNeedPerm(RankUnit.GRADE3.getName()));
                return false;
            }

            if(args.length == 0){
                // Ouvrir l'inventaire
            }
        }
        return false;
    }
}