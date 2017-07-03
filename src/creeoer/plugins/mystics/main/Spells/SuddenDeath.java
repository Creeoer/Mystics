package creeoer.plugins.mystics.main.Spells;

import creeoer.plugins.mystics.main.Mystics;
import creeoer.plugins.mystics.main.crystal.MagicType;
import creeoer.plugins.mystics.main.util.ParticleUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

/**
 * Created by Frank on 7/3/2017.
 */
public class SuddenDeath extends Spell {

    public SuddenDeath(){
        setMana(15);
        spellMaterial = Material.QUARTZ;
        setSpellType(MagicType.LIGHT);
        spellName = "SuddenDeath";
    }

    @Override
    public void cast() {
        //Create shrinking circle spawn lighting


        new BukkitRunnable() {
            int counter = 0;

            @Override
            public void run() {

                if(counter == 10)
                    cancel();

                List<Location> locs = ParticleUtil.createCircle(caster.getLocation().add(caster.getEyeLocation().getDirection().multiply(7)), 12 - counter, 7 );

                counter ++;
                for(Location loc : locs) {
                    caster.getLocation().getWorld().strikeLightning(loc);
                }
            }
        }.runTaskTimer(Mystics.getInstance(), 0l, 7l);


    }



    }

