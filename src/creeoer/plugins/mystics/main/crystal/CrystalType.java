package creeoer.plugins.mystics.main.crystal;

import org.bukkit.ChatColor;
import org.bukkit.Material;

/**
 * Created by black on 7/1/2017.
 */
public enum CrystalType {

    DARK(ChatColor.DARK_PURPLE + "Dark Crystal", Material.OBSIDIAN), LIGHT(ChatColor.YELLOW + "Light Crystal", Material.QUARTZ);

    private String name;
    private Material mat;

    CrystalType (String name, Material mat)
    {
        this.name = name;
        this.mat = mat;
    }

    public String getName(){return name;}

    public Material getMaterial(){return mat;}
}
