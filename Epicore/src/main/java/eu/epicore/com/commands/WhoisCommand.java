package eu.epicore.com.commands;

import eu.epicraft.com.data.utils.TextUtil;
import eu.epicraft.com.data.yaml.PlayerInfos;
import eu.epicraft.com.data.yaml.RankUnit;
import eu.epicraft.com.manager.game.GameMessage;
import eu.epicraft.com.manager.moderation.ModManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by AnyKwey
 */
public class WhoisCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cError: You cannot do it here.");
            return false;
        }

        Player player = (Player) sender;

        if (label.equalsIgnoreCase("whois")) {
            if (RankUnit.getRank(player.getUniqueId()).getPower() < RankUnit.STAFF.getPower()) {
                player.sendMessage(TextUtil.sendNeedPerm(RankUnit.STAFF.getName()));
                return false;
            }

            if(args.length > 1){
                TextUtil.falseArgument(player, args[0]);
                return false;
            }

            if (args.length == 0) {
                for(Player players : Bukkit.getOnlinePlayers()){
                    player.sendMessage(" ");
                    if(ModManager.isInMod(players.getUniqueId())){
                        player.sendMessage("§b" + players.getName() + " §f(§cMOD§f) ");
                    } else {
                        player.sendMessage("§b" + players.getName());
                    }
                    player.sendMessage(" ");
                }
            }

            if(args.length == 1){
                String targetName = args[0];

                if(!PlayerInfos.exist(targetName)){
                    GameMessage.PLAYER_NEVER_CONNECT.getMessage();
                    return false;
                }

                if (Bukkit.getPlayer(targetName) == null) {
                    GameMessage.PLAYER_OFFLINE_ONTHISSERVER.getMessage();
                    return false;
                }

                UUID targetUUID = PlayerInfos.getUUID(targetName);

                player.sendMessage(TextUtil.setLineRed() + TextUtil.setLineRed());
                player.sendMessage( "§7Joueur: " + RankUnit.getRank(targetUUID).getName() + " " + PlayerInfos.getPseudo(targetUUID));
                player.sendMessage(" ");
                player.sendMessage("§7Gemmes: §a" + PlayerInfos.getGemes(targetName));
                player.sendMessage("§7Crédits: §c" + PlayerInfos.getCredits(targetName));
                player.sendMessage("§7Première connexion: §8" + PlayerInfos.getFirstConnection(targetName));
                player.sendMessage("§7Dernière connexion: §8" + PlayerInfos.getLastConnection(targetName));
                player.sendMessage("§7Temps de jeu: §b" + PlayerInfos.getTimeTotal(targetName));
                player.sendMessage(TextUtil.setLineRed() + TextUtil.setLineRed());
            }
        }
        return false;
    }
}