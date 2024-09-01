package eu.epicore.com.commands;

import eu.epicraft.com.data.utils.TextUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by AnyKwey
 */
public class ReportCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§cError: You cannot do it here.");
            return false;
        }

        Player player = (Player) sender;

        if(args.length >= 0){
            player.sendMessage(TextUtil.setLineRed() + TextUtil.setLineRed());
            player.sendMessage("§fLa fonction §b/report §fest désactivé à cause des faux reports et des reports abusifs.");
            player.sendMessage(" ");
            player.sendMessage("§f§nComment signaler un tricheur ?");
            player.sendMessage("§fRendez-vous sur notre Discord, créer un ticket est écrivez son pseudo et la raison.");
            player.sendMessage(TextUtil.setLineRed() + TextUtil.setLineRed());
            return false;
        }
        return false;
    }
}
