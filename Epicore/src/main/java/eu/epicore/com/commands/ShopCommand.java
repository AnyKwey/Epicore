package eu.epicore.com.commands;

import eu.epicraft.com.data.utils.TextUtil;
import eu.epicraft.com.data.yaml.PlayerInfos;
import eu.epicraft.com.manager.game.GameMessage;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by AnyKwey
 */
public class ShopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§cError: You cannot do it here.");
            return false;
        }

        Player player = (Player) sender;

        if(args.length == 0){
            TextComponent s = new TextComponent("§6[Boutique] ");
            TextComponent b = new TextComponent("§bBoutique d'Epicraft");
            b.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§a§lLIEN SECURISÉ\n\n§7Vous allez être redirigé sur\n§7un site internet.\n\n§6» §eClique-Gauche pour accéder").create()));
            b.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://epicraft.eu/boutique"));
            player.spigot().sendMessage(s, b);
        }

        if(args.length != 0){
            TextUtil.falseArgument(player, args[0]);
            return false;
        }
        return false;
    }
}
