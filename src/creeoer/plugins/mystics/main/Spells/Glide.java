package creeoer.plugins.mystics.main.Spells;

import creeoer.plugins.mystics.main.crystal.MagicType;
import creeoer.plugins.mystics.main.util.ParticleUtil;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Created by Frank on 7/3/2017.
 */
public class Glide extends Spell {



    public Glide(){
        spellName = "Glide";
        spellMaterial = Material.FEATHER;
        setSpellType(MagicType.LIGHT);
    }

    @Override
    public void cast() {

       Vector vec = caster.getLocation().getDirection();
       caster.setVelocity(vec.multiply(9));
       ParticleUtil.createTrail(caster.getLocation(), caster.getLocation().getDirection(),  Effect.FIREWORKS_SPARK);
       caster.playSound(caster.getLocation(), Sound.ENTITY_BLAZE_SHOOT,  2, 2);

    }
}
