package creeoer.plugins.mystics.main.generator;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by black on 7/1/2017.
 */
public class CrystalGenerator{

    public void generate(Chunk target) {
        //20% chance of generation
        //66-78
        int count = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        while (count <= 3) {
            Bukkit.broadcastMessage("Ran");
            count++;
            int chunkY = ThreadLocalRandom.current().nextInt(60, 72);
            Block block = target.getWorld().getBlockAt(16 * target.getX(), chunkY, 16 * target.getZ());
            Bukkit.broadcastMessage(Integer.toString(block.getX()) + " " + Integer.toString(block.getZ()));
            int x = ThreadLocalRandom.current().nextInt(1, 4);
            int y = ThreadLocalRandom.current().nextInt(1, 4);
            int z = ThreadLocalRandom.current().nextInt(1, 4);

            Block targetBlock = block.getLocation().add(x, y, z).getBlock();
Bukkit.broadcastMessage(Integer.toString(targetBlock.getX()) + " " + Integer.toString(targetBlock.getY()) + " " + Integer.toString(targetBlock.getZ()));
            //Change to crystal block
            targetBlock.setType(Material.COAL_BLOCK);
        }

    }

}
