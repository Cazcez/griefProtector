package Cazcez.Storage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class AddMember
{
    public void AddMember (Chunk chunk, Player owner, Player member)
    {

        if (member.equals(owner))
        {
            owner.sendMessage(ChatColor.DARK_RED + "KENDİNİ EKLEYEMEZSİN!");
            return;
        }

        File claimDataFolder = new File("plugins/griefProtector/claimData", "X=" + chunk.getX() + ", Z=" + chunk.getZ()  + ".yml");

        if (claimDataFolder.exists())
        {
            FileConfiguration dataConfiguration = YamlConfiguration.loadConfiguration(claimDataFolder);

            if (dataConfiguration.get("claimOwner").equals(owner.getUniqueId().toString())) {
                owner.sendMessage("okey bu senin claim");

                dataConfiguration.set("claimMembers." + member.getUniqueId().toString() + ".canAddNewMember", false);

                dataConfiguration.set("claimMembers." + member.getUniqueId().toString() + ".canBreak", false);
                dataConfiguration.set("claimMembers." + member.getUniqueId().toString() + ".canBuild", false);

                dataConfiguration.set("claimMembers." + member.getUniqueId().toString() + ".canUseContainers", false);
                dataConfiguration.set("claimMembers." + member.getUniqueId().toString() + ".canUseDoors", false);

                dataConfiguration.set("claimMembers." + member.getUniqueId().toString() + ".canDeposit", false);
                dataConfiguration.set("claimMembers." + member.getUniqueId().toString() + ".canWithdraw", false);

                try
                {
                    dataConfiguration.save(claimDataFolder);
                }
                catch (IOException e)
                {
                    Bukkit.getLogger().info(ChatColor.RED + "'" + chunk + ".yml' datasını kaydedemedim!");
                }
            }
            else
            {
                owner.sendMessage(ChatColor.DARK_RED + "Bu arsanın sahibi değilsin!");
            }
            //TODO add check for if player is a member of claim and has permission for break
        }
        else
        {
            owner.sendMessage(ChatColor.DARK_RED + "OLMAYAN CLAIM'E KİMİ EKLİYORSUN BRE GAFİL!");

        }
        //TODO

    }



}
