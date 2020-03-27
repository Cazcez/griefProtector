package Cazcez;

import Cazcez.Storage.AddMember;
import Cazcez.Storage.CreateClaim;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class command implements CommandExecutor {

    private griefProtection plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        //TODO
        if (label.equalsIgnoreCase("claim"))
        {


            Player player = (Player)sender;

            if (args.length == 0)
            {

            }
            else if (args[0].equalsIgnoreCase("create"))
            {
                CreateClaim claim = new CreateClaim();


                claim.CreateClaimYAML(player, player.getLocation().getChunk());

                player.sendMessage("blablabla");
            }
            else if (args[0].equalsIgnoreCase("add"))
            {

                if (args.length == 2)
                {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null)
                    {
                        sender.sendMessage(ChatColor.DARK_PURPLE + args[0] + "adlı Oyuncu bulunamadı!");
                        return true;
                    }
                    else
                    {
                        AddMember member = new AddMember();

                        member.AddMember(player.getLocation().getChunk(), player, target);
                    }

                }

                else
                {
                    player.sendMessage("Kullanım: /claim add <player>");
                }

            }

        }
        return false;
    }
}