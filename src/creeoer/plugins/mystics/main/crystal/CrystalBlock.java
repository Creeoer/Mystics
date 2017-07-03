package creeoer.plugins.mystics.main.crystal;

import org.bukkit.block.Block;

/**
 * Created by Frank on 7/2/2017.
 */
public class CrystalBlock implements Crystal{

    private Block block;

    public CrystalBlock(MagicType type) {
        block.setType(type.getMaterial());


    }

    public Block getBlock(){
        return block;
    }


    @Override
    public MagicType getType() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
