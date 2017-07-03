package creeoer.plugins.mystics.main.Spells;

import creeoer.plugins.mystics.main.crystal.MagicType;
import creeoer.plugins.mystics.main.user.Wizard;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * Created by Frank on 7/2/2017.
 */
public abstract class Spell {

protected String spellName;
protected MagicType type;
protected Player caster;
protected int mana;
protected Material spellMaterial;

public Spell(){
    this.caster = caster;

}

    public abstract void cast();


    public String getName(){
        return spellName;
    }

    public MagicType getSpellType(){
        return type;
    }

    public void setSpellType(MagicType type){
        this.type = type;
    }

    public void setName(){
        this.spellName = spellName;
    }

    public Player getCaster(){
        return caster;
    }

    public void setMana(int mana){
        this.mana = mana;
    }

    public int getMana(){ return mana; }

    public Material getSpellMaterial(){
        return spellMaterial;
    }

    public void setCaster(Wizard wiz){
        this.caster = wiz.getPlayer();

    }
}
