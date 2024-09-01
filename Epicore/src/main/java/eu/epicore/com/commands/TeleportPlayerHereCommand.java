package eu.epicore.com.commands;

import eu.epicraft.com.data.utils.TextUtil;
import eu.epicraft.com.data.yaml.PlayerInfos;
import eu.epicraft.com.data.yaml.RankUnit;
import eu.epicraft.com.manager.game.GameMessage;
import eu.epicraft.com.manager.moderation.ModManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by AnyKwey
 */
public class TeleportPlayerHereCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cError: You cannot do it here.");
            return false;
        }

        Player player = (Player) sender;

        if (label.equalsIgnoreCase("tph")) {
            if (RankUnit.getRank(player.getUniqueId()).getPower() < RankUnit.MOD.getPower()) {
                player.sendMessage(TextUtil.sendNeedPerm(RankUnit.MOD.getName()));
            } else if(RankUnit.getRank(player.getUniqueId()).getPower() >= RankUnit.MOD.getPower() && (!ModManager.isInMod(player.getUniqueId()))){
                player.sendMessage("§cErreur: Vous devez être en mode modération pour utiliser cette commande.");
                return false;
            }

            if(args.length == 0){
                player.sendMessage("§cSyntaxe: /tph (pseudo)");
            }

            if(args.length > 1){
                TextUtil.falseArgument(player, args[1]);
                return false;
            }

            if(args.length == 1) {
                String targetName = args[0];
                Player target = Bukkit.getPlayer(targetName);

                if(!PlayerInfos.exist(targetName)){
                    GameMessage.PLAYER_NEVER_CONNECT.getMessage();
                    return false;
                }

                if(target == null){
                    GameMessage.PLAYER_OFFLINE_ONTHISSERVER.getMessage();
                    return false;
                }

                target.teleport(player);
                target.playSound(target.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                player.sendMessage("§6[Téléportation] §fVous avez téléporté §e" + targetName + " §fvers vous.");
            }
        }
        return false;
    }
}