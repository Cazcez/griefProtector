package Cazcez.Storage;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;

import java.io.File;

public class DeleteClaim
{
    public void DeleteClaim(Chunk chunk, Player owner, boolean sure)
    {

        File claimDataFolder = new File("plugins/griefProtector/claimData", "X=" + chunk.getX() + ", Z=" + chunk.getZ()  + ".yml");
        if (claimDataFolder.exists())
        {
            claimDataFolder.delete();
            owner.sendMessage("Protector'ünü geri alabilirsin!");
        }
        else
        {
            owner.sendMessage("Böyle bir claim zaten yok!");
        }

    }

    public void DeleteClaimSure(Chunk chunk, Player owner)
    {
        //that is for now
        boolean sure = true;

        //TODO GUI CLICK MESSAGE


        DeleteClaim(chunk, owner, sure);



    }


}
