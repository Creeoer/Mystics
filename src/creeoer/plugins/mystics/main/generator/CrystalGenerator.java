package creeoer.plugins.mystics.main.generator;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by black on 7/1/2017.
 */
public class CrystalGenerator {

    public void generate(Chunk target) {
        //20% chance of generation
        //66-78
        int count = ThreadLocalRandom.current().nextInt(1, 3 + 1);

        while (count <= 3) {
            count++;
            int chunkLoc = ThreadLocalRandom.current().nextInt(1, 16 + 1);
            int chunkY = ThreadLocalRandom.current().nextInt(66, 76 + 1);
            Block block = target.getBlock(chunkLoc, chunkY, chunkLoc);

            int x = ThreadLocalRandom.current().nextInt(block.getX(), block.getX() + 3);
            int y = ThreadLocalRandom.current().nextInt(block.getY(), block.getY() + 3);
            int z = ThreadLocalRandom.current().nextInt(block.getZ(), block.getZ() + 3);

            Block targetBlock = block.getLocation().clone().add(x, y, z).getBlock();

            targetBlock.setType(Material.COAL_BLOCK);
        }

    }

}
