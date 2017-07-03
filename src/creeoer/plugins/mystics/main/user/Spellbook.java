package creeoer.plugins.mystics.main.user;

import creeoer.plugins.mystics.main.Spells.Spell;
import creeoer.plugins.mystics.main.crystal.MagicType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Frank on 7/3/2017.
 */
public class Spellbook {

    public Inventory inv;

    public Spellbook(Wizard wiz){
        inv = Bukkit.createInventory(wiz.getPlayer(),27, "Learned Spells");
        int slot = 0;
        if(wiz == null)
            Bukkit.broadcastMessage("Wizard is null");

        for(Spell spell: wiz.getKnownSpells()){
            ItemStack stack = new ItemStack(spell.getSpellMaterial(), 1);
            ItemMeta meta = stack.getItemMeta();

            if(spell.getSpellType() == MagicType.LIGHT)
                meta.setDisplayName(ChatColor.YELLOW +  spell.getName());

                if(spell.getSpellType() == MagicType.DARK)
                    meta.setDisplayName(ChatColor.DARK_PURPLE + spell.getName());

            stack.setItemMeta(meta);

            inv.setItem(slot, stack);
            slot += 2;

        }

    }






    public Inventory build(){
        return inv;
    }

}
