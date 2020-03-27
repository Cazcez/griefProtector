package Cazcez;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.File;
import java.util.Map;

public class event implements Listener
{

    private griefProtection plugin;

    @EventHandler
    public void breakBlock(BlockBreakEvent e)
    {
        //e.getPlayer().sendMessage("Blok: " +e.getBlock());
        //e.getPlayer().sendMessage("Dünya: " +e.getBlock().getWorld());
        //e.getPlayer().sendMessage("xyz: " +e.getBlock().getLocation().getBlockX() + " " + e.getBlock().getLocation().getBlockY() + " " + e.getBlock().getLocation().getBlockZ());

        //e.getPlayer().sendMessage("Konum: "+e.getBlock().getLocation());
        //e.getPlayer().sendMessage("Chunk: " + e.getBlock().getChunk());
        //e.getPlayer().sendMessage("Biome: "+ e.getBlock().getBiome());

        Chunk chunk = e.getBlock().getLocation().getChunk();

        File claimDataFolder = new File("plugins/griefProtector/claimData", "X=" + chunk.getX() + ", Z=" + chunk.getZ()  + ".yml");

        if (claimDataFolder.exists())
        {
            FileConfiguration dataConfiguration = YamlConfiguration.loadConfiguration(claimDataFolder);



            if (dataConfiguration.get("claimOwner").equals(e.getPlayer().getUniqueId().toString()))
            {
                e.getPlayer().sendMessage("okey bu sensin");
            }
            else
            {
                e.getPlayer().sendMessage("hey bu arsanın bir sahibi var ve bu sen değilsin!");
                e.setCancelled(true);
            }
            //TODO add check for if player is a member of claim and has permission for break
        }
        else
        {
            e.getPlayer().sendMessage("k kırabilirsin");
        }

    }

}