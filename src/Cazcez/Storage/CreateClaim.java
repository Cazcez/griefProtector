package Cazcez.Storage;

import net.minecraft.server.v1_15_R1.IPlayerFileData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;

public class CreateClaim
{
    public File fileConfig = new File("plugins/griefProtector", "config.yml");

    public void CreateClaimYAML(Player owner, Chunk chunk)
    {

        File claimDataFolder = new File("plugins" + File.separator + "griefProtector" + File.separator + "claimData" + File.separator , "X=" + chunk.getX() + ", Z=" + chunk.getZ()   + ".yml");
        FileConfiguration dataConfiguration = YamlConfiguration.loadConfiguration(claimDataFolder);

        if (claimDataFolder.exists())
        {
            owner.sendMessage("already claimed");
        }
        else
        {
            try
            {
                claimDataFolder.createNewFile();

            }
            catch (IOException e)
            {
                Bukkit.getLogger().info(ChatColor.RED + "'" + chunk + ".yml' datasını oluşturamadım!");
            }

        }
        dataConfiguration.set("claimTitle", owner.getName() + "'s claim");

        owner.sendMessage(String.format("" + dataConfiguration.get("claimTitle")));

    }

}
