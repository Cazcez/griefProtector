package Cazcez;

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
        if (label.equalsIgnoreCase("claimchunk"))
        {
            //Player player = (Player)sender; // gerek yok la

            //plugin.hash.putIfAbsent(player.getLocation().getChunk(), player);
            CreateClaim claim = new CreateClaim();
            //claim.CreateClaimYAML(player, player.getLocation().getChunk());

            World anadunya = Bukkit.getWorld("survival");
            Chunk testchunk = anadunya.getSpawnLocation().getChunk();
            claim.CreateClaimYAML(sender, testchunk);

            sender.sendMessage("blablabla");
        }
        return false;
    }
}