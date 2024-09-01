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
public class ModCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cError: You cannot do it here.");
            return false;
        }

        Player player = (Player) sender;

        if (label.equalsIgnoreCase("mod")) {
            if (RankUnit.getRank(player.getUniqueId()).getPower() < RankUnit.MOD.getPower()) {
                player.sendMessage(TextUtil.sendNeedPerm(RankUnit.MOD.getName()));
                return false;
            }

            if(args.length == 0){
                if(!ModManager.isInMod(player.getUniqueId())){
                    ModManager.add(player.getUniqueId());
                    player.sendMessage(" ");
                    player.sendMessage(TextUtil.setLineRed() + TextUtil.setLineRed());
                    player.sendMessage(" ");
                    player.sendMessage(" §c» §7Votre Mode Modération a été §aactivé §7!");
                    player.sendMessage(" §c» §7Il prendra effet au prochain §c§nchangement de serveur§7.");
                    player.sendMessage(" ");
                    player.sendMessage(TextUtil.setLineRed() + TextUtil.setLineRed());
                    player.sendMessage(" ");
                } else {
                    ModManager.remove(player.getUniqueId());
                    player.sendMessage(" ");
                    player.sendMessage(TextUtil.setLineRed() + TextUtil.setLineRed());
                    player.sendMessage(" ");
                    player.sendMessage(" §c» §7Votre Mode Modération a été §cdésactivé §7!");
                    player.sendMessage(" §c» §7Il prendra effet au prochain §c§nchangement de serveur§7.");
                    player.sendMessage(" ");
                    player.sendMessage(TextUtil.setLineRed() + TextUtil.setLineRed());
                    player.sendMessage(" ");
                }
                return false;
            }
        }
        return false;
    }
}