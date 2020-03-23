package Cazcez;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

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


        boolean flag = plugin.hash.containsKey(e.getBlock().getLocation().getChunk());
        if (flag == false)
        {
            return;
        }
        else if (plugin.hash.get(e.getBlock().getLocation().getChunk()).equals(e.getPlayer()))
        {
            e.getPlayer().sendMessage("ah adamım arsa seninmiş\nben de kötü adamlar arsanı sikiyo' sandım");
        }
        else
        {
            e.setCancelled(true);
            e.getPlayer().sendMessage("iptal edildi");
        }



    }

}