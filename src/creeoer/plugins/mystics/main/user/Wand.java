package creeoer.plugins.mystics.main.user;

import creeoer.plugins.mystics.main.Spells.Spell;
import creeoer.plugins.mystics.main.crystal.MagicType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Frank on 7/2/2017.
 */
public class Wand {

    private String name;
    private ItemStack wand;
    private MagicType wandType;

    public Wand(MagicType type){
        wandType = type;
        wand = new ItemStack(Material.STICK, 1);
        name = type.getName() + " Wand";
        ItemMeta meta = wand.getItemMeta();
        meta.setDisplayName(name);
        wand.setItemMeta(meta);
    }


    public void cast(Wizard wizard, Spell spell){
        int newM = wizard.getMana() - spell.getMana();
        wizard.setMana(newM);
        wizard.getPlayer().getScoreboard().getObjective("mana").getScore("Mana:").setScore(newM);

        spell.setCaster(wizard);
        spell.cast();

    }


    public String getName(){
        return name;
    }


    public MagicType getWandType(){
        return wandType;
    }

    public ItemStack getWandItem(){
        return wand;
    }




}
