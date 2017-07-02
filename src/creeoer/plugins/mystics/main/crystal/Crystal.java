package creeoer.plugins.mystics.main.crystal;

import org.bukkit.Material;

/**
 * Created by black on 7/1/2017.
 */
public class Crystal {
    private CrystalType type;
    private String name;
    private Material material;
    private int amount;

    public Crystal(CrystalType type, int amount){
    this.type = type;
    this.amount = amount;
    }


    public Material getType(){
        return material;
    }

    public String getName(){
        return name;
    }

    public int amount(){
        return amount;
    }


}
