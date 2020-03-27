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
    public File fileConfig = new File("plugins//griefProtector", "config.yml");

    public void CreateClaimYAML(Player owner, Chunk chunk)
    {

        File claimDataFolder = new File("plugins/griefProtector/claimData", "X=" + chunk.getX() + ", Z=" + chunk.getZ()  + ".yml");
        FileConfiguration dataConfiguration = YamlConfiguration.loadConfiguration(claimDataFolder);



        if (claimDataFolder.exists()) //check chunk is already claimed
        {
            owner.sendMessage("already claimed");
        }
        else
        {
            if (!claimDataFolder.getParentFile().exists())
                claimDataFolder.getParentFile().mkdirs(); // creates the /plugins/griefProtector/claimData directory if not found

            try
            {
                claimDataFolder.createNewFile(); // create YAML file for claim
            }
            catch (IOException e)
            {
                Bukkit.getLogger().info(ChatColor.RED + "'" + chunk + ".yml' datasını oluşturamadım!");
            }

        }

        //set YAML data
        dataConfiguration.set("claimTitle", owner.getName() + "'s claim");
        dataConfiguration.set("claimDescription", owner.getName() + " Default description");

        dataConfiguration.set("claimProtectorCoordinate.X", 0);
        dataConfiguration.set("claimProtectorCoordinate.Y", 60);
        dataConfiguration.set("claimProtectorCoordinate.Z", 0);

        dataConfiguration.set("claimVault", 0);
        dataConfiguration.set("claimOwner", owner.getUniqueId().toString());



        try
        {
            dataConfiguration.save(claimDataFolder);
        }
        catch (IOException e)
        {
            Bukkit.getLogger().info(ChatColor.RED + "'" + chunk + ".yml' datasını kaydedemedim!");
        }
        owner.sendMessage((String)dataConfiguration.get("claimTitle"));

    }

}
