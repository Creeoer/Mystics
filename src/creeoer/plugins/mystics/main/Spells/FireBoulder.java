package creeoer.plugins.mystics.main.Spells;

import creeoer.plugins.mystics.main.crystal.MagicType;
import creeoer.plugins.mystics.main.util.ParticleUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Frank on 7/2/2017.
 */
public class FireBoulder extends Spell{


    public FireBoulder(){
        spellMaterial = Material.FIREBALL;
        spellName = "FireBoulder";
        setMana(5);
        setSpellType(MagicType.DARK);


    }

    @Override
    public void cast() {
        //Cast fireball at what player is looking at
        HashSet<Material> transparent = new HashSet<>();
        Block target = caster.getTargetBlock(transparent, 120);

        //Create small circle at

        List<Location> locs = ParticleUtil.createCircle(caster.getEyeLocation(), 1, 3);

        for(Location loc: locs){
            caster.launchProjectile(Fireball.class, loc.toVector());
        }
    }

}
