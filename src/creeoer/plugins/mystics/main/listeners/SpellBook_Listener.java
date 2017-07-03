package creeoer.plugins.mystics.main.listeners;

import creeoer.plugins.mystics.main.Spells.Spell;
import creeoer.plugins.mystics.main.Spells.SpellFactory;
import creeoer.plugins.mystics.main.manager.WizardManager;
import creeoer.plugins.mystics.main.user.Spellbook;
import creeoer.plugins.mystics.main.user.Wizard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Frank on 7/2/2017.
 */
public class SpellBook_Listener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getClickedInventory().getName() != null){
            if(e.getClickedInventory().getName().equals("Learned Spells")){
                if(e.getCurrentItem() != null || e.getCurrentItem().getType() != Material.AIR){
                    ItemStack spellItem = e.getCurrentItem();
                    Spell selectedSpell = SpellFactory.getSpell(ChatColor.stripColor(spellItem.getItemMeta().getDisplayName()));
                    Wizard wiz = WizardManager.getInstance().getWizard(e.getWhoClicked().getName());
                    wiz.setCurrentSpell(selectedSpell);
                    wiz.getPlayer().sendMessage(ChatColor.AQUA + "Selected Spell: " + selectedSpell.getName());
                    wiz.getPlayer().getScoreboard().getObjective("currentSpell").setDisplayName("Current Spell: " + selectedSpell.getName());
                }
            }
        }

    }

    @EventHandler
    public void onSpellbookClick(PlayerInteractEvent e){
        if(e.hasItem()) {
            if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
                if(e.getItem().hasItemMeta()){
                    if(e.getItem().getItemMeta().hasDisplayName()){
                        String dName = e.getItem().getItemMeta().getDisplayName();
                        if(dName.equals("Spell Book")){

                          e.getPlayer().openInventory( new Spellbook(WizardManager.getInstance().getWizard(e.getPlayer().getName())).build());
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onItemMove(InventoryMoveItemEvent e){
        if(e.getSource().getTitle().equalsIgnoreCase("Learned Spells") || e.getDestination().getTitle().equalsIgnoreCase("Learned Spells"))
            e.setCancelled(true);
    }

}
