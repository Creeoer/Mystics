package creeoer.plugins.mystics.main.crystal;

import org.bukkit.Material;

/**
 * Created by black on 7/1/2017.
 */
public class CrystalItem implements Crystal {
    private MagicType type;
    private String name;
    private Material material;
    private int amount;

    public CrystalItem(MagicType type, int amount) {
        this.type = type;
        this.amount = amount;
        material = type.getMaterial();
    }
    public Material getMaterial() {
        return material;
    }

    public int amount() {
        return amount;
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
