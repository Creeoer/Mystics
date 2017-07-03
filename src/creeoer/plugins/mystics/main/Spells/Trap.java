package creeoer.plugins.mystics.main.Spells;

import creeoer.plugins.mystics.main.Mystics;
import creeoer.plugins.mystics.main.crystal.MagicType;
import creeoer.plugins.mystics.main.util.ParticleUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * Created by Frank on 7/3/2017.
 */
public class Trap extends Spell {

public Trap(){
    setMana(15);
    spellMaterial = Material.STONE;
    setSpellType(MagicType.DARK);
    spellName = "Trap";
}

    @Override
    public void cast() {
        //Make a circle above a target
Set<Material> materials = new HashSet<>();

        List<Location> locs = ParticleUtil.createCircle(caster.getLocation().add(caster.getEyeLocation().getDirection().multiply(8)), 2, 10);

        new BukkitRunnable(){

            int counter = 0;
            @Override
            public void run() {
                if(counter == 10)
                    cancel();


                counter++;
                for(Location loc: locs){
                    loc.getWorld().spawnFallingBlock(loc, Material.STONE, (byte) 0x0);
                }

            }
        }.runTaskTimer(Mystics.getInstance(),0, 10L);


    }




}
