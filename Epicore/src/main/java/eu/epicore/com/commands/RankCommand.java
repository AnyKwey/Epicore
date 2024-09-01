package eu.epicore.com.commands;

import eu.epicraft.com.data.utils.TextUtil;
import eu.epicraft.com.data.yaml.PlayerInfos;
import eu.epicraft.com.data.yaml.RankUnit;
import eu.epicraft.com.manager.game.GameMessage;
import eu.epicraft.com.manager.moderation.ModManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by AnyKwey
 */
public class RankCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cError: You cannot do it here.");
            return false;
        }

        Player player = (Player) sender;

        if (label.equalsIgnoreCase("rank")) {
            if (RankUnit.getRank(player.getUniqueId()).getPower() < RankUnit.ADMIN.getPower()) {
                player.sendMessage(TextUtil.sendNeedPerm(RankUnit.ADMIN.getName()));
                return false;
            }

            if(args.length == 0){
                player.sendMessage("§cSyntaxe: /rank set <pseudo> <nom du grade>");
                return false;
            }


            if(args.length == 3){
                if(!args[0].equalsIgnoreCase("set")){
                    GameMessage.falseArgument(player, args[0]);
                    return false;
                }

                String targetName = args[1];
                UUID targetUUID = PlayerInfos.getUUID(targetName);

                if(!PlayerInfos.exist(targetName)){
                    player.sendMessage(GameMessage.PLAYER_NEVER_CONNECT.getMessage());
                    return false;
                }

                if(args[2].equalsIgnoreCase("JOUEUR")){
                    if(RankUnit.getRank(targetUUID).getPower() == RankUnit.NONE.getPower()){
                        player.sendMessage("§cErreur: Le joueur possède déjà ce grade.");
                        return false;
                    }

                    RankUnit.setRank(targetUUID, 0);
                    player.sendMessage("§8[§a§l✔§8] §a" + targetName + " §fest maintenant " + RankUnit.NONE.getName() + "§f.");
                } else if(args[2].equalsIgnoreCase("MINI-VIP")){
                    if(RankUnit.getRank(targetUUID).getPower() == RankUnit.GRADE1.getPower()){
                        player.sendMessage("§cErreur: Le joueur possède déjà ce grade.");
                        return false;
                    }

                    RankUnit.setRank(targetUUID, 1);
                    player.sendMessage("§8[§a§l✔§8] §a" + targetName + " §fest maintenant " + RankUnit.GRADE1.getName() + "§f.");
                } else if(args[2].equalsIgnoreCase("VIP")){
                    if(RankUnit.getRank(targetUUID).getPower() == RankUnit.GRADE2.getPower()){
                        player.sendMessage("§cErreur: Le joueur possède déjà ce grade.");
                        return false;
                    }

                    RankUnit.setRank(targetUUID, 2);
                    player.sendMessage("§8[§a§l✔§8] §a" + targetName + " §fest maintenant " + RankUnit.GRADE2.getName() + "§f.");
                } else if(args[2].equalsIgnoreCase("EPICVIP")){
                    if(RankUnit.getRank(targetUUID).getPower() == RankUnit.GRADE3.getPower()){
                        player.sendMessage("§cErreur: Le joueur possède déjà ce grade.");
                        return false;
                    }

                    RankUnit.setRank(targetUUID, 3);
                    player.sendMessage("§8[§a§l✔§8] §a" + targetName + " §fest maintenant " + RankUnit.GRADE3.getName() + "§f.");
                } else if(args[2].equalsIgnoreCase("YOUTUBEUR")){
                    if(RankUnit.getRank(targetUUID).getPower() == RankUnit.YOUTUBER.getPower()){
                        player.sendMessage("§cErreur: Le joueur possède déjà ce grade.");
                        return false;
                    }

                    RankUnit.setRank(targetUUID, 4);
                    player.sendMessage("§8[§a§l✔§8] §a" + targetName + " §fest maintenant " + RankUnit.YOUTUBER.getName() + "§f.");
                } else if(args[2].equalsIgnoreCase("AMI")){
                    if(RankUnit.getRank(targetUUID).getPower() == RankUnit.FRIEND.getPower()){
                        player.sendMessage("§cErreur: Le joueur possède déjà ce grade.");
                        return false;
                    }

                    RankUnit.setRank(targetUUID, 5);
                    player.sendMessage("§8[§a§l✔§8] §a" + targetName + " §fest maintenant " + RankUnit.FRIEND.getName() + "§f.");
                } else if(args[2].equalsIgnoreCase("STAFF")){
                    if(RankUnit.getRank(targetUUID).getPower() == RankUnit.STAFF.getPower()){
                        player.sendMessage("§cErreur: Le joueur possède déjà ce grade.");
                        return false;
                    }

                    RankUnit.setRank(targetUUID, 6);
                    player.sendMessage("§8[§a§l✔§8] §a" + targetName + " §fest maintenant " + RankUnit.STAFF.getName() + "§f.");
                } else if(args[2].equalsIgnoreCase("HELPER")){
                    if(RankUnit.getRank(targetUUID).getPower() == RankUnit.HELPER.getPower()){
                        player.sendMessage("§cErreur: Le joueur possède déjà ce grade.");
                        return false;
                    }

                    RankUnit.setRank(targetUUID, 7);
                    player.sendMessage("§8[§a§l✔§8] §a" + targetName + " §fest maintenant " + RankUnit.HELPER.getName() + "§f.");
                } else if(args[2].equalsIgnoreCase("MODERATEUR")){
                    if(RankUnit.getRank(targetUUID).getPower() == RankUnit.MOD.getPower()){
                        player.sendMessage("§cErreur: Le joueur possède déjà ce grade.");
                        return false;
                    }

                    RankUnit.setRank(targetUUID, 8);
                    player.sendMessage("§8[§a§l✔§8] §a" + targetName + " §fest maintenant " + RankUnit.MOD.getName() + "§f.");
                } else if(args[2].equalsIgnoreCase("MANAGER")){
                    if(RankUnit.getRank(targetUUID).getPower() == RankUnit.MANAGER.getPower()){
                        player.sendMessage("§cErreur: Le joueur possède déjà ce grade.");
                        return false;
                    }

                    RankUnit.setRank(targetUUID, 9);
                    player.sendMessage("§8[§a§l✔§8] §a" + targetName + " §fest maintenant " + RankUnit.MANAGER.getName() + "§f.");
                } else if(args[2].equalsIgnoreCase("ADMIN")){
                    if(RankUnit.getRank(targetUUID).getPower() == RankUnit.ADMIN.getPower()){
                        player.sendMessage("§cErreur: Le joueur possède déjà ce grade.");
                        return false;
                    }

                    RankUnit.setRank(targetUUID, 10);
                    player.sendMessage("§8[§a§l✔§8] §a" + targetName + " §fest maintenant " + RankUnit.ADMIN.getName() + "§f.");
                } else {
                    player.sendMessage("§cLes différents grade sont:");
                    player.sendMessage(" §c- JOUEUR");
                    player.sendMessage(" §c- MINI-VIP");
                    player.sendMessage(" §c- VIP");
                    player.sendMessage(" §c- EPICVIP");
                    player.sendMessage(" §c- YOUTUBEUR");
                    player.sendMessage(" §c- AMI");
                    player.sendMessage(" §c- STAFF");
                    player.sendMessage(" §c- HELPER");
                    player.sendMessage(" §c- MODERATEUR");
                    player.sendMessage(" §c- MANAGER");
                    player.sendMessage(" §c- ADMIN");
                    player.sendMessage(" ");
                }
            }
        }
        return false;
    }
}