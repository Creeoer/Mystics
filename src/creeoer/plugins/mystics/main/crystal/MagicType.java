package creeoer.plugins.mystics.main.crystal;

import org.bukkit.ChatColor;
import org.bukkit.Material;

/**
 * Created by black on 7/1/2017.
 */
public enum MagicType {

    DARK(ChatColor.DARK_PURPLE + "Dark", Material.OBSIDIAN), LIGHT(ChatColor.YELLOW + "Light", Material.QUARTZ);

    private String name;
    private Material mat;

    MagicType (String name, Material mat)
    {
        this.name = name;
        this.mat = mat;
    }

    public String getName(){return name;}

    public Material getMaterial(){return mat;}

    public static MagicType parseType(String name){
        if(name.equalsIgnoreCase("Light"))
            return MagicType.LIGHT;

        if(name.equalsIgnoreCase("Dark"))
            return MagicType.DARK;

            return null;
    }
}
