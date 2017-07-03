package creeoer.plugins.mystics.main.Spells;

import creeoer.plugins.mystics.main.Mystics;
import creeoer.plugins.mystics.main.crystal.MagicType;
import creeoer.plugins.mystics.main.util.ParticleUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

/**
 * Created by Frank on 7/3/2017.
 */
public class Cleanse extends Spell {


    public Cleanse() {
        spellMaterial = Material.LAVA_BUCKET;
        spellName = "Cleanse";
        setMana(10);
        setSpellType(MagicType.DARK);


    }

    //
    @Override
    public void cast() {

        new BukkitRunnable() {
            Location center = caster.getLocation();
            List<Location> locs;
            int counter = 0;

            @Override
            public void run() {
                counter++;
                locs = ParticleUtil.createCircle(center, 2 + counter, 1 + counter);
                for (Location loc : locs) {

                    if (loc.getBlock().getType() == Material.LONG_GRASS) {
                        loc.getBlock().setType(Material.FIRE);
                        continue;
                    }

                    loc.getBlock().getRelative(BlockFace.UP).setType(Material.FIRE);
                }
                caster.playSound(center, Sound.ITEM_FIRECHARGE_USE, 6, 5);


                if (counter == 6)
                    cancel();
//cancel it


            }
        }.runTaskTimer(Mystics.getInstance(), 0, 6L);

    }


}
