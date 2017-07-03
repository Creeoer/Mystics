package creeoer.plugins.mystics.main.util;

import creeoer.plugins.mystics.main.Mystics;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 7/3/2017.
 */
public class ParticleUtil {


    public static List<Location> createCircle(Location loc, double radius, int amount){
        //(x-h)squared + (y -k) 2 = r 2

        World world = loc.getWorld();
        double counter = (2 * Math.PI) / amount;
        List<Location> locs = new ArrayList<>();

        for(int i = 0; i < amount; i ++){

            double ang = i * counter;
            double x = loc.getX() + (radius * Math.cos(ang));
            double z = loc.getZ() + (radius * Math.sin(ang));
            locs.add(new Location(world, x , loc.getY(), z));
        }
        return locs;
    }

    public static void createTrail(Location startLoc, Vector direction, Effect type){

        new BukkitRunnable(){
            int counter = 0;
            @Override
            public void run() {
                if(counter == 100)
                    cancel();

                Location point = startLoc.add(direction);
                startLoc.getWorld().playEffect(point, type, 1);
                counter++;
            }
        }.runTaskTimer(Mystics.getInstance(), 0l, 1L);

    }

}
