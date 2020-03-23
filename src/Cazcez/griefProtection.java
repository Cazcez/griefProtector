package Cazcez;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class griefProtection extends JavaPlugin
{
    public static HashMap<Chunk, Player> hash = new HashMap<Chunk, Player>();

    public File fileConfig = new File("plugins/griefProtector", "config.yml");
    public File fileData = new File("plugins/griefProtector/claimData");


    @Override
    public void onEnable()
    {

        getCommand("claimchunk").setExecutor(new Cazcez.command());
        Bukkit.getPluginManager().registerEvents(new Cazcez.event(), this);
        getLogger().info(ChatColor.DARK_PURPLE + "Cazcez'in komutları ve eventleri kaydedildi!");


        if (!fileConfig.exists()) {
            fileConfig.mkdir();
        }
        if (!fileData.exists()) {
            fileData.mkdir();
        }
    }



    @Override
    public void onDisable()
    {

    }


}
