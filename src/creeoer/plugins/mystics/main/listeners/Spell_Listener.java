package creeoer.plugins.mystics.main.listeners;

import creeoer.plugins.mystics.main.Spells.Cleanse;
import creeoer.plugins.mystics.main.Spells.Spell;
import creeoer.plugins.mystics.main.crystal.MagicType;
import creeoer.plugins.mystics.main.manager.WizardManager;
import creeoer.plugins.mystics.main.user.Wand;
import creeoer.plugins.mystics.main.user.Wizard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Frank on 7/2/2017.
 */
public class Spell_Listener implements Listener {

    @EventHandler
    public void onWandUse(PlayerInteractEvent e) {

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.hasItem()) {
                if (e.getItem().hasItemMeta()) {
                    if (e.getItem().getItemMeta().hasDisplayName()) {
                        if (ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName()).contains("Wand")) {
                            String name = e.getItem().getItemMeta().getDisplayName().replace("Wand", " ");
                            String newName = ChatColor.stripColor(name.trim());
                            Wand wand = new Wand(MagicType.parseType(newName));

                            Wizard wizard = WizardManager.getInstance().getWizard(e.getPlayer().getName());
                            Spell spell = wizard.getCurrentSpell();

                            if (spell != null)
                                if (wizard.getMana() >= wizard.getCurrentSpell().getMana()) {
                                    wand.cast(wizard, wizard.getCurrentSpell());
                                    wizard.getPlayer().sendMessage(ChatColor.GREEN + "Successfully cast the spell of " + wizard.getCurrentSpell().getName() + " of type " + wizard.getCurrentSpell().getSpellType().getName());

                                } else {
                                    wizard.getPlayer().sendMessage(ChatColor.RED + "Out of mana!");

                                }
                        }


                    }

                }

            }
        }

    }
}

